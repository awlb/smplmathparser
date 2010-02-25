package net.smplmathparse;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that represents an evaluation tree for a function.
 * 
 * @author Alex Barfoot
 * 
 */

public class EvaluationTree {
	/**
	 * The binary operators of this tree
	 */
	private Map<Character, BinaryOperator> binaryOperators = new HashMap<Character, BinaryOperator>();
	/**
	 * The unary operators of this tree
	 */
	private Map<String, UnaryOperator> unaryOperators = new HashMap<String, UnaryOperator>();
	/**
	 * The variable names and values for this tree
	 */
	private Map<String, Variable> variables = new HashMap<String, Variable>();
	/**
	 * The constant names and values for this tree
	 */
	private Map<String, Constant> constants = new HashMap<String, Constant>();
	/**
	 * The root node of this evaluation tree
	 */
	private EvaluationNode root;

	/**
	 * Initialise and build the evaluation tree
	 * 
	 * @param binaryOperators
	 *            The binary operators to be used by this evaluation tree
	 * @param unaryOperators
	 *            The unary operators to be used by this evaluation tree
	 * @param function
	 *            The string represeting the mathmatical function to parsed into
	 *            a tree
	 * @throws MathParserException
	 * 
	 */
	public EvaluationTree(Map<Character, BinaryOperator> binaryOperators,
			Map<String, UnaryOperator> unaryOperators, String function)
			throws MathParserException {
		// set operators to defaults provided by MathParser
		this.binaryOperators = binaryOperators;
		this.unaryOperators = unaryOperators;
		// get root node by parsing function
		root = parse(function);
	}

	/**
	 * Evaluate this tree using the currently set varible values
	 * 
	 * @return The result from the evalution of the tree
	 */
	public double evaluate() {
		return root.evaluate();
	}

	/**
	 * Parse a function part and produce a Evaluation node that represents it
	 * 
	 * @param functionPtr
	 *            The function part to be parsed
	 * @return The evaluation node that represents this function part
	 * @throws MathParserException
	 */
	public EvaluationNode parse(String functionPtr) throws MathParserException {
		// the current highest precedence binary operator found
		BinaryOperator binOperator = null;
		// the current highest precedence unary operator found
		UnaryOperator uniOperator = null;
		// the position of the current precedent operator
		int precedentOpPos = 0;
		// position of the last found operator
		int lastOpPos = 0;
		// current bracket depth
		int bracketDepth = 0;
		// array form of the function
		char[] charFunc = functionPtr.toCharArray();
		// loop through the characters in the function
		for (int i = 0; i < charFunc.length; i++) {
			// get current char being parsed
			char currentChar = charFunc[i];
			// check if the current char is a binary operator
			if (binaryOperators.containsKey(currentChar) && bracketDepth == 0) {
				if (i == 0) {
					/*
					 * If operator is at position 0 it must also be a unary one
					 * If this is not the case there must be an error in the
					 * function
					 */
					if (binaryOperators.get(currentChar).isAlsoUnary()) {
						// create unary operator
						UnaryOperator tempUniOperator = unaryOperators.get(""
								+ currentChar);
						/*
						 * set the position of the last operator to i+1 this is
						 * a special case for unary operators that are
						 * represented by a binary operator char
						 */
						lastOpPos = i + 1;
						/*
						 * set highest precedence unary operator to found one if
						 * its precedence is higher or current op is null
						 */
						if (uniOperator == null) {
							uniOperator = tempUniOperator;
							precedentOpPos = i;
						} else if (tempUniOperator.getPrecedence() > uniOperator
								.getPrecedence()) {
							uniOperator = tempUniOperator;
							precedentOpPos = i;
						}
					} else {
						throw new MathParserException(
								"Found binary operator where unary was expected",
								functionPtr);
					}
				} else if (lastOpPos == i - 1 && lastOpPos > 0) {
					/*
					 * If a operator is directly right of a binary operator it
					 * must be unary Its not possible for it to be the most
					 * precedent operator so just set it as the last one
					 */
					lastOpPos = i + 1;
				} else {
					/*
					 * Binary operator has been found Check if it must be set as
					 * the most precedent one
					 */
					lastOpPos = i;
					BinaryOperator tempBinOperator = binaryOperators
							.get(currentChar);
					if (binOperator == null) {
						binOperator = tempBinOperator;
						precedentOpPos = i;
					} else if (tempBinOperator.getPrecedence() > binOperator
							.getPrecedence()) {
						binOperator = tempBinOperator;
						precedentOpPos = i;
					}
				}
			} else if (currentChar == '(') {
				/*
				 * Bracket was found indicating a probable unary operator
				 */
				if (i != 0) {
					/*
					 * As bracket was not at position 0 we can assume the string
					 * between last last found operator and this bracket is a
					 * unary operator
					 */
					if (binOperator == null && bracketDepth == 0) {
						/*
						 * Create unary operator only if the found one is not
						 * located in brackets and a binary operator does not
						 * already exist. Also don't set if there is currently a
						 * unary operator of higher precedence.
						 */
						String unaryOp = functionPtr.substring(lastOpPos, i);
						UnaryOperator tempUniOperator = unaryOperators
								.get(unaryOp);
						if (tempUniOperator != null) {
							if (uniOperator == null) {
								uniOperator = tempUniOperator;
								precedentOpPos = i;
							} else if (tempUniOperator.getPrecedence() > uniOperator
									.getPrecedence()) {
								uniOperator = tempUniOperator;
								precedentOpPos = i;
							}
						} else {
							throw new MathParserException(
									"Unknow unary operator: " + unaryOp,
									functionPtr);
						}
					}
				} else {
					/*
					 * If a appears as the first and last characters then the
					 * unary operator + must be inserted to make it a valid
					 * operation
					 */
					if (charFunc[charFunc.length - 1] == ')') {
						UnaryOperator tempUniOperator = unaryOperators.get("+");
						uniOperator = tempUniOperator;
						// function string must be updated with the added +
						functionPtr = "+" + functionPtr;
						i++;
						charFunc = functionPtr.toCharArray();
					}
				}
				// increase bracket depth as an opening one was found
				bracketDepth++;
			} else if (currentChar == ')') {
				// decrease bracket depth as an closing one was found
				bracketDepth--;
			}
		}
		/*
		 * Finished reading function string Create node to represent it from
		 * found operator
		 */
		EvaluationNode node = null;
		if (binOperator != null) {
			node = new BinaryNode(binOperator, precedentOpPos, functionPtr,
					this);
		} else if (uniOperator != null) {
			node = new UnaryNode(uniOperator, functionPtr, this);
		} else {
			// no operator was found so function must be variable or constant
			if (charFunc.length > 0) {
				if (constants.containsKey(functionPtr)) {
					/*
					 * function string is a already defined constant so link
					 * constant node to it
					 */
					Constant con = constants.get(functionPtr);
					node = new ConstantNode(con);
				} else if (MathParser.isNumeric(functionPtr)) {
					// function string an undefined numeric constant
					double conValue = Double.parseDouble(functionPtr);
					Constant con = new Constant(functionPtr, conValue);
					constants.put(functionPtr, con);
					node = new ConstantNode(con);
				} else {
					// function string is a variable
					Variable var;
					if (!variables.containsKey(functionPtr)) {
						// variable does not already exist so create it
						var = new Variable(functionPtr);
						variables.put(functionPtr, var);
					} else {
						// variable already exists so link node to it
						var = variables.get(functionPtr);
					}
					node = new VariableNode(var);
				}
			} else {
				throw new MathParserException("Blank function string",
						functionPtr);
			}
		}
		if (node == null) {
			// there was an error with the function string
			throw new MathParserException(
					"There was an error with the function", functionPtr);
		}
		return node;
	}

	/**
	 * Set a variable in the evaluation tree
	 * 
	 * @param name
	 *            The name of the variable to be set
	 * @param value
	 *            The value to set this variable to
	 * @throws MathParserException
	 */
	public void setVariable(String name, double value)
			throws MathParserException {
		if (variables.containsKey(name)) {
			variables.get(name).setValue(value);
		} else {
			throw new MathParserException("Variable not found: " + name, this
					.toString());
		}
	}
}
