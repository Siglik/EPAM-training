package org.qqq175.textparser.visitor;

import org.qqq175.textparser.composite.expression.ExpressionComponent;
import org.qqq175.textparser.composite.text.ParagraphComposite;
import org.qqq175.textparser.composite.text.SentenseComposite;
import org.qqq175.textparser.composite.text.TextComposite;
import org.qqq175.textparser.composite.text.TextLeaf;
import org.qqq175.textparser.composite.text.WordComposite;

public interface TextVisitor<R> extends Visitor<R> {
	void visit(TextComposite component);

	void visit(ParagraphComposite component);

	void visit(SentenseComposite component);

	void visit(WordComposite component);

	void visit(TextLeaf component);

	void visit(ExpressionComponent component);
}
