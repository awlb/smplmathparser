/*	Copyright (C) 2010  Alex Barfoot
 
 	This file is part of SimpleMathParser.

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

public class MathParserTester {
	public static void main(String[] args) {
		String function = "y = sin( x )";
		MathParser parser = new MathParser();
		try {
			EvaluationTree tree = parser.parse(function);
			tree.setVariable("x", 10);
			System.out.println(tree.evaluate());
		} catch (MathParserException e) {
			e.printStackTrace();
		}
	}
}
