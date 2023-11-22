package dev.awlb.smplmathparser;

/**
 * Class representing a variable node in a evaluation tree
 * 
 * @author Alex Barfoot
 * 
 */

public class VariableNode extends EvaluationNode {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 7196821894528024L;
	/**
	 * The current variable for this node
	 */
	private Variable value;

	/**
	 * Construct a variable node with the given variable value
	 * 
	 * @param value
	 */
	public VariableNode(Variable value) {
		this.value = value;
	}

	/**
	 * Returns the current value for this variable node
	 */
	@Override
	public double evaluate() {
		return value.getValue();
	}
}
