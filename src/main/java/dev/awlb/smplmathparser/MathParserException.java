package dev.awlb.smplmathparser;

@SuppressWarnings("serial")
public class MathParserException extends Exception {
	/**
	 * The expression string in which the error occurred
	 */
	public final String expression;

	/**
	 * Construct a new math parser exception with the given error message and
	 * function
	 * 
	 * @param message
	 *            The detail message describing the error
	 * @param expression
	 *            The string of the mathematical expression that caused the
	 *            error
	 */
	public MathParserException(String message, String expression) {
		super(message + " when parsing \"" + expression + "\"");
		this.expression = expression;
	}
}
