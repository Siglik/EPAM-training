package org.qqq175.textparser.visitor;

import org.qqq175.textparser.composite.expression.AddComposite;
import org.qqq175.textparser.composite.expression.DecrementComposite;
import org.qqq175.textparser.composite.expression.DivideComposite;
import org.qqq175.textparser.composite.expression.ExpressionLeaf;
import org.qqq175.textparser.composite.expression.IncrementComposite;
import org.qqq175.textparser.composite.expression.MultiplyComposite;
import org.qqq175.textparser.composite.expression.NegateComposite;
import org.qqq175.textparser.composite.expression.SubstractComposite;

public class InfixExpressionVisitor implements ExpressionVisitor {
	StringBuilder result;

	public InfixExpressionVisitor() {
		result = new StringBuilder();
	}

	@Override
	public void visit(ExpressionLeaf component) {
		result.append(component.item());
	}

	@Override
	public void visit(IncrementComposite component) {
		result.append("++");
		component.right().accept(this);
	}

	@Override
	public void visit(DecrementComposite component) {
		result.append("--");
		component.right().accept(this);
	}

	@Override
	public void visit(NegateComposite component) {
		result.append("-");
		component.right().accept(this);
	}

	@Override
	public void visit(AddComposite component) {
		result.append("(");
		component.left().accept(this);
		result.append(" + ");
		component.right().accept(this);
		result.append(")");
	}

	@Override
	public void visit(SubstractComposite component) {
		result.append("(");
		component.left().accept(this);
		result.append(" - ");
		component.right().accept(this);
		result.append(")");
	}

	@Override
	public void visit(MultiplyComposite component) {
		result.append("(");
		component.left().accept(this);
		result.append(" * ");
		component.right().accept(this);
		result.append(")");
	}

	@Override
	public void visit(DivideComposite component) {
		result.append("(");
		component.left().accept(this);
		result.append(" / ");
		component.right().accept(this);
		result.append(")");
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
