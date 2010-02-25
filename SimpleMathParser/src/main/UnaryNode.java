package main;

/**
 * Class representing a unary operator node in a evaluation tree
 * 
 * @author Alex Barfoot
 * 
 */

public class UnaryNode extends EvaluationNode {
	/**
	 * The parameter for this unary operator
	 */
	private EvaluationNode parameter;
	/**
	 * The UnaryOperator for the operator to be performed
	 */
	private UnaryOperator operator;

	public UnaryNode(UnaryOperator operator, String function,
			EvaluationTree parent) throws MathParserException {
		this.operator = operator;
		String middleStr;
		int start = function.indexOf("(");
		int end = function.lastIndexOf(")");
		if (start > -1 && end > -1
				&& start == operator.getOperatorString().length()) {
			middleStr = function.substring(start + 1, end);
		} else {
			middleStr = function.substring(operator.getOperatorString()
					.length());
		}
		parameter = parent.parse(middleStr);
	}

	@Override
	public double evaluate() {
		double parameterValue = parameter.evaluate();
		double value = operator.evaluate(parameterValue);
		return value;
	}
}
