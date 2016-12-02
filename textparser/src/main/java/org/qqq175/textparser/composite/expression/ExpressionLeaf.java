package org.qqq175.textparser.composite.expression;

import org.qqq175.textparser.visitor.ExpressionVisitor;

public class ExpressionLeaf extends ExpressionComponent {
	/** Integer value associated with the operand. */
	private int item;

	public ExpressionLeaf(int item) {
		this.item = item;
	}

	public ExpressionLeaf(String item) {
		this.item = Integer.parseInt(item);
	}

	/* Return the item stored in the node. */
	public int item() {
		return item;
	}

	/*
	 * Define the @a accept() operation used for the Visitor pattern.
	 */
	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
}
