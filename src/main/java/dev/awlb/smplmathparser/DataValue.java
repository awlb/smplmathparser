package dev.awlb.smplmathparser;

import java.io.Serializable;

/**
 * Class representing a data value such as variable or constant More specific
 * types of data value will extend this
 * 
 * @author Alex Barfoot
 * 
 */

public class DataValue implements Serializable {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -1094061118930962748L;
	/**
	 * The string that represents the name of this data value
	 */
	private final String name;
	
	public DataValue(String name) {
		this.name = name;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
