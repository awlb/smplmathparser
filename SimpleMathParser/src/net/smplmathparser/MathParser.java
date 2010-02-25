/*	Copyright (C) 2010  Alex Barfoot
 
 	This file is part of SimpleMathParser.

    SimpleMathParser is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    SimpleMathParser is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with SimpleMathParser.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.smplmathparser;

import java.util.HashMap;
import java.util.Map;

/**
 * Parses mathematical expressions to produce a evaluation tree.
 * 
 * @author Alex Barfoot
 * 
 */

public class MathParser {
	/**
	 * The default binary operators *
	 */
	private Map<Character, BinaryOperator> defaultBinaryOperators = new HashMap<Character, BinaryOperator>();
	/**
	 * The default unary operators
	 */
	private Map<String, UnaryOperator> defaultUnaryOperators = new HashMap<String, UnaryOperator>();

	/**
	 * Initialise the math parser
	 */
	public MathParser() {
		addBinaryOperator(new BinaryOperator('+', 4, true) {
			@Override
			public double evaluate(double a, double b) {
				return a + b;
			}
		});
		addBinaryOperator(new BinaryOperator('-', 4, true) {
			@Override
			public double evaluate(double a, double b) {
				return a - b;
			}
		});
		addBinaryOperator(new BinaryOperator('*', 3, false) {
			@Override
			public double evaluate(double a, double b) {
				return a * b;
			}
		});
		addBinaryOperator(new BinaryOperator('^', 2, false) {
			@Override
			public double evaluate(double a, double b) {
				return Math.pow(a, b);
			}
		});
		addUnaryOperator(new UnaryOperator("cos", 1) {
			@Override
			public double evaluate(double a) {
				return Math.cos(a);
			}
		});
		addUnaryOperator(new UnaryOperator("sin", 1) {
			@Override
			public double evaluate(double a) {
				return Math.cos(a);
			}
		});
		addUnaryOperator(new UnaryOperator("tan", 1) {
			@Override
			public double evaluate(double a) {
				return Math.cos(a);
			}
		});
		addUnaryOperator(new UnaryOperator("-", 1) {
			@Override
			public double evaluate(double a) {
				return -a;
			}
		});
		addUnaryOperator(new UnaryOperator("+", 1) {
			@Override
			public double evaluate(double a) {
				return +a;
			}
		});
	}

	/**
	 * Parses the function to produce an evaluation tree
	 * 
	 * @param function
	 *            String of the function to parsed
	 * @throws MathParserException
	 */
	public EvaluationTree parse(String function) throws MathParserException {
		function = preParse(function);
		EvaluationTree tree = new EvaluationTree(defaultBinaryOperators,
				defaultUnaryOperators, function);
		return tree;
	}

	/**
	 * Makes the function string ready for parsing
	 * 
	 * @param function
	 *            The string to be made ready for parsing
	 * @return The string preParsed ready for parsing
	 */
	private String preParse(String function) {
		if (function.contains("=")) {
			// strip off = sign and anything before if user has include it
			int equalIndex = function.indexOf('=');
			function = function.substring(equalIndex + 1);
		}
		return function;
	}

	/**
	 * Add a binary operator to the default set
	 * 
	 * @param binaryOperator
	 *            The binary operator to be added
	 */
	public void addBinaryOperator(BinaryOperator binaryOperator) {
		defaultBinaryOperators.put(binaryOperator.getOperatorChar(),
				binaryOperator);
	}

	/**
	 * Add a binary operator to the default set
	 * 
	 * @param unaryOperator
	 *            The unary operator to be added
	 */
	public void addUnaryOperator(UnaryOperator unaryOperator) {
		defaultUnaryOperators.put(unaryOperator.getOperatorString(),
				unaryOperator);
	}

	/**
	 * Method used to check if a string is a number
	 * 
	 * @param numStr
	 *            The string to be tested
	 * @return Returns true if string represents a number otherwise false
	 */
	public static boolean isNumeric(String numStr) {
		try {
			Double.parseDouble(numStr);
			return true;
		} catch (NumberFormatException e) {
			// numStr is not numeric
			return false;
		}
	}
}
