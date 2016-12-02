package org.qqq175.textparser.visitor;

import org.qqq175.textparser.composite.expression.AddComposite;
import org.qqq175.textparser.composite.expression.DecrementComposite;
import org.qqq175.textparser.composite.expression.DivideComposite;
import org.qqq175.textparser.composite.expression.ExpressionLeaf;
import org.qqq175.textparser.composite.expression.IncrementComposite;
import org.qqq175.textparser.composite.expression.MultiplyComposite;
import org.qqq175.textparser.composite.expression.NegateComposite;
import org.qqq175.textparser.composite.expression.SubstractComposite;

public interface ExpressionVisitor extends Visitor<String> {
	void visit(ExpressionLeaf component);

	void visit(IncrementComposite component);

	void visit(DecrementComposite component);

	void visit(NegateComposite component);

	void visit(AddComposite component);

	void visit(SubstractComposite component);

	void visit(MultiplyComposite component);

	void visit(DivideComposite component);
}
