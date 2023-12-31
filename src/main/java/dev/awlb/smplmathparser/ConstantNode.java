package dev.awlb.smplmathparser;

/**
 * Class representing a numerical constant node in a evaluation tree
 * 
 * @author Alex Barfoot
 * 
 */

public class ConstantNode extends EvaluationNode {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 6007983239795201053L;
	/**
	 * The current constant for this node
	 */
	private Constant value;

	/**
	 * Construct a constant node with the given constant
	 */
	public ConstantNode(Constant value) {
		this.value = value;
	}

	@Override
	public double evaluate() {
		return value.getValue();
	}
}
