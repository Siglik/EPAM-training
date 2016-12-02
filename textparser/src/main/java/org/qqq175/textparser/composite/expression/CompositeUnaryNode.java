package org.qqq175.textparser.composite.expression;

public abstract class CompositeUnaryNode extends ExpressionComponent {
	private ExpressionComponent right;

	public CompositeUnaryNode(ExpressionComponent right) {
		this.right = right;
	}

	/** Return the right child. */
	public ExpressionComponent right() {
		return this.right;
	}
}