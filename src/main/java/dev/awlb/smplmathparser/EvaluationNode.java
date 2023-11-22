package dev.awlb.smplmathparser;

import java.io.Serializable;

/**
 * Class representing a node in a evaluation tree
 * 
 * @author Alex Barfoot
 * 
 */

public abstract class EvaluationNode implements Serializable {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 2618640894320266872L;
	/**
	 * Indicates whether the node has a constant value or not
	 */
	private boolean constant = false;

	/**
	 * Evaluate this evaluation tree node
	 */
	public abstract double evaluate();

	/**
	 * Returns true if the value of this node will never change so therefore is
	 * constant, returns false otherwise
	 * 
	 * @return false by default, subclass nodes must set constant value to true
	 *         if their value is constant
	 */
	public boolean isConstant() {
		return constant;
	}
}
