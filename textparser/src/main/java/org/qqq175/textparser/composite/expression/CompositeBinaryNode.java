package org.qqq175.textparser.composite.expression;

public abstract class CompositeBinaryNode extends ExpressionComponent {
	private ExpressionComponent left;
	private ExpressionComponent right;

	public CompositeBinaryNode(ExpressionComponent left, ExpressionComponent right) {
		this.left = left;
		this.right = right;
	}

	public ExpressionComponent left() {
		return left;
	}

	/** Return the right child. */
	public ExpressionComponent right() {
		return this.right;
	}
}
