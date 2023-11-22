package dev.awlb.smplmathparser;

import java.io.Serializable;

/**
 * Class used to represent an operator More specific types of operator will
 * extend this
 * 
 * @author Alex Barfoot
 * 
 */

public class Operator implements Serializable {
	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -8526367439301015577L;
	/**
	 * The precedence of this operator
	 */
	private int precedence;

	public Operator(int precedence) {
		this.precedence = precedence;
	}

	/**
	 * @return the precedence of this operator
	 */
	public int getPrecedence() {
		return precedence;
	}
}
