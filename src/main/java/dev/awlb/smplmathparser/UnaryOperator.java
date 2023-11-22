package dev.awlb.smplmathparser;

/**
 * Class used to represent a unary operator
 * 
 * @author Alex Barfoot
 * 
 */

public abstract class UnaryOperator extends Operator {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1547418889170989250L;
	/**
	 * The string that represents this unary operator
	 */
	private String operatorString;
	/**
	 * The precedence of this unary operator
	 */
	private int precedence;

	/**
	 * Construct a unary operator with the given operator string
	 * 
	 * @param operatorString
	 *            The string that represents this operator
	 */
	public UnaryOperator(String operatorString, int precedence) {
		super(precedence);
		this.operatorString = operatorString;
	}

	/**
	 * Perform the unary operator on the given value
	 * 
	 * @param value
	 *            The value to perform this operator on
	 * @return The result of the operator applied to the input value
	 */
	public abstract double evaluate(double value);

	/**
	 * @return the operatorString
	 */
	public String getOperatorString() {
		return operatorString;
	}

	/**
	 * @return the precedence
	 */
	public int getPrecedence() {
		return precedence;
	}
}
