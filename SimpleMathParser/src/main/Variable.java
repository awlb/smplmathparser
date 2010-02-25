package main;

/**
 * Class representing a variable
 * 
 * @author Alex Barfoot
 * 
 */

public class Variable {
	/**
	 * The string that represents the name of this variable
	 */
	private String name;
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
		this.name = name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
