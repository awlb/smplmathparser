package dev.awlb.smplmathparser;

/**
 * Class representing a variable
 * 
 * @author Alex Barfoot
 * 
 */

public class Variable extends DataValue{
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -6621276378216824276L;
	/**
	 * The current value of this variable
	 */
	private double value;

	/**
	 * Construct a variable with the given name
	 * 
	 * @param name
	 *            The that variable will be identified by
	 */
	public Variable(String name) {
		super(name);
	}

	/**
	 * @return the value of this variable
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets the current value of this variable
	 * 
	 * @param value
	 *            The value to set this variable to
	 */
	public void setValue(double value) {
		this.value = value;
	}
}
