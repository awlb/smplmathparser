package dev.awlb.smplmathparser;

/**
 * Class representing a constant
 * 
 * @author Alex Barfoot
 * 
 */

public class Constant extends DataValue{
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = 1501002391434699927L;
	/**
	 * The value for this constant
	 */
	private final double value;

	public Constant(String name, double value) {
		super(name);
		this.value = value;
	}

	/**
	 * @return the value of this constant
	 */
	public double getValue() {
		return value;
	}
}
