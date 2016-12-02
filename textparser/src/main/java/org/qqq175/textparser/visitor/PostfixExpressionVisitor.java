package org.qqq175.textparser.visitor;

import org.qqq175.textparser.composite.expression.AddComposite;
import org.qqq175.textparser.composite.expression.DecrementComposite;
import org.qqq175.textparser.composite.expression.DivideComposite;
import org.qqq175.textparser.composite.expression.ExpressionLeaf;
import org.qqq175.textparser.composite.expression.IncrementComposite;
import org.qqq175.textparser.composite.expression.MultiplyComposite;
import org.qqq175.textparser.composite.expression.NegateComposite;
import org.qqq175.textparser.composite.expression.SubstractComposite;

public class PostfixExpressionVisitor implements ExpressionVisitor {
	StringBuilder result;

	public PostfixExpressionVisitor() {
		result = new StringBuilder();
	}

	@Override
	public void visit(ExpressionLeaf component) {
		result.append(component.item() + " ");
	}

	@Override
	public void visit(IncrementComposite component) {
		component.right().accept(this);
		result.append("++ ");
	}

	@Override
	public void visit(DecrementComposite component) {
		component.right().accept(this);
		result.append("-- ");
	}

	@Override
	public void visit(NegateComposite component) {
		component.right().accept(this);
		result.append("(-) ");
	}

	@Override
	public void visit(AddComposite component) {
		component.left().accept(this);
		component.right().accept(this);
		result.append("+ ");

	}

	@Override
	public void visit(SubstractComposite component) {
		component.left().accept(this);
		component.right().accept(this);
		result.append("- ");
	}

	@Override
	public void visit(MultiplyComposite component) {
		component.left().accept(this);
		component.right().accept(this);
		result.append("* ");
	}

	@Override
	public void visit(DivideComposite component) {
		component.left().accept(this);
		component.right().accept(this);
		result.append("/ ");
	}

	@Override
	public String result() {
		return result.toString();
	}

	@Override
	public void reset() {
		result.setLength(0);
	}
}
