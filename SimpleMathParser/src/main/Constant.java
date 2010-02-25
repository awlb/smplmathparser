package main;

/**
 * Class representing a constant
 * 
 * @author Alex Barfoot
 * 
 */

public class Constant {
	/**
	 * The string that represents the name of this variable
	 */
	private final String name;
	/**
	 * The current value of this variable
	 */
	private final double value;

	public Constant(String name, double value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * @return the name of this constant
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the value of this constant
	 */
	public double getValue() {
		return value;
	}
}
