package org.qqq175.textparser.composite.expression;

import org.qqq175.textparser.visitor.ExpressionVisitor;

public class IncrementComposite extends CompositeUnaryNode {

	public IncrementComposite(ExpressionComponent right) {
		super(right);
	}

	/*
	 * Define the @a accept() operation used for the Visitor pattern.
	 */
	@Override
	public void accept(ExpressionVisitor visitor) {
		visitor.visit(this);
	}
}
