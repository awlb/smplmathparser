package dev.awlb.smplmathparser;

/**
 * Class representing a unary operator node in a evaluation tree
 * 
 * @author Alex Barfoot
 * 
 */

public class UnaryNode extends EvaluationNode {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1785260805118262581L;
	/**
	 * The UnaryOperator for the operator to be performed
	 */
	private UnaryOperator operator;
	/**
	 * The parameter for this unary operator
	 */
	private EvaluationNode parameter;

	public UnaryNode(UnaryOperator operator, String function,
			EvaluationTree parent) throws MathParserException {
		// set operator
		this.operator = operator;
		String middleStr;
		// get string of function operator is to be applied to
		int start = function.indexOf("(");
		int end = function.lastIndexOf(")");
		if (start > -1 && end > -1
				&& start == operator.getOperatorString().length()) {
			middleStr = function.substring(start + 1, end);
		} else {
			middleStr = function.substring(operator.getOperatorString()
					.length());
		}
		// parse string to get evaluation node operator will be applied to
		parameter = parent.parse(middleStr);
	}

	@Override
	public double evaluate() {
		double parameterValue = parameter.evaluate();
		double value = operator.evaluate(parameterValue);
		return value;
	}
}
