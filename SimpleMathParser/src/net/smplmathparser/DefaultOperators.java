package net.smplmathparser;

public class DefaultOperators {
	public static void addDefaultBinaryOperators(MathParser parser) {
		// addition operator
		parser.addBinaryOperator(new BinaryOperator('+', 4, true) {
			@Override
			public double evaluate(double a, double b) {
				return a + b;
			}
		});
		// subtraction operator
		parser.addBinaryOperator(new BinaryOperator('-', 4, true) {
			@Override
			public double evaluate(double a, double b) {
				return a - b;
			}
		});
		// multiplication operator
		parser.addBinaryOperator(new BinaryOperator('*', 3, false) {
			@Override
			public double evaluate(double a, double b) {
				return a * b;
			}
		});
		// division operator
		parser.addBinaryOperator(new BinaryOperator('/', 3, false) {
			@Override
			public double evaluate(double a, double b) {
				return a / b;
			}
		});
		// power operator
		parser.addBinaryOperator(new BinaryOperator('^', 2, false) {
			@Override
			public double evaluate(double a, double b) {
				return Math.pow(a, b);
			}
		});
	}

	public static void addDefaultConstants(MathParser parser) {
		parser.addConstant(new Constant("PI",Math.PI));
		parser.addConstant(new Constant("E",Math.E));
	}
	public static void addDefaultUnaryOperators(MathParser parser) {
		// Trigonometric functions
		parser.addUnaryOperator(new UnaryOperator("cos", 1) {
			@Override
			public double evaluate(double a) {
				return Math.cos(a);
			}
		});
		parser.addUnaryOperator(new UnaryOperator("sin", 1) {
			@Override
			public double evaluate(double a) {
				return Math.sin(a);
			}
		});
		parser.addUnaryOperator(new UnaryOperator("tan", 1) {
			@Override
			public double evaluate(double a) {
				return Math.tan(a);
			}
		});
		// inverse trigonometric functions
		parser.addUnaryOperator(new UnaryOperator("acos", 1) {
			@Override
			public double evaluate(double a) {
				return Math.acos(a);
			}
		});
		parser.addUnaryOperator(new UnaryOperator("asin", 1) {
			@Override
			public double evaluate(double a) {
				return Math.asin(a);
			}
		});
		parser.addUnaryOperator(new UnaryOperator("atan", 1) {
			@Override
			public double evaluate(double a) {
				return Math.atan(a);
			}
		});
		// Hyperbolic trigonometric functions
		parser.addUnaryOperator(new UnaryOperator("cosh", 1) {
			@Override
			public double evaluate(double a) {
				return Math.cosh(a);
			}
		});
		parser.addUnaryOperator(new UnaryOperator("sinh", 1) {
			@Override
			public double evaluate(double a) {
				return Math.sinh(a);
			}
		});
		parser.addUnaryOperator(new UnaryOperator("tanh", 1) {
			@Override
			public double evaluate(double a) {
				return Math.tanh(a);
			}
		});
		// unary sign operators
		parser.addUnaryOperator(new UnaryOperator("-", 1) {
			@Override
			public double evaluate(double a) {
				return -a;
			}
		});
		parser.addUnaryOperator(new UnaryOperator("+", 1) {
			@Override
			public double evaluate(double a) {
				return +a;
			}
		});
		parser.addUnaryOperator(new UnaryOperator("abs", 1) {
			@Override
			public double evaluate(double a) {
				return Math.abs(a);
			}
		});
	}
}
