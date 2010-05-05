/*	Copyright (C) 2010  Alex Barfoot
 
 	This file is part of SimpleMathParser http://smplmathparse.sourceforge.net/.

    SimpleMathParser is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    SimpleMathParser is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with SimpleMathParser.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.smplmathparser;

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
