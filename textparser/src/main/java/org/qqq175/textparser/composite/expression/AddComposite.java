package org.qqq175.textparser.composite.expression;

import org.qqq175.textparser.visitor.ExpressionVisitor;

public class AddComposite extends CompositeBinaryNode {

	public AddComposite(ExpressionComponent left, ExpressionComponent right) {
		super(left, right);
	}

	/*
	 * Define the @a accept() operation used for the Visitor pattern.
	 */
	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
}
