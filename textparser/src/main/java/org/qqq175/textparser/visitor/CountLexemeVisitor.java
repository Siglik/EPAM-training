package org.qqq175.textparser.visitor;

import org.qqq175.textparser.composite.expression.ExpressionComponent;
import org.qqq175.textparser.composite.text.ParagraphComposite;
import org.qqq175.textparser.composite.text.SentenseComposite;
import org.qqq175.textparser.composite.text.TextComposite;
import org.qqq175.textparser.composite.text.TextLeaf;
import org.qqq175.textparser.composite.text.WordComposite;

public class CountLexemeVisitor implements TextVisitor<Integer> {
	private int lexemeCount;

	public CountLexemeVisitor() {
		this.lexemeCount = 0;
	}

	@Override
	public Integer result() {
		return lexemeCount;
	}

	@Override
	public void reset() {
		lexemeCount = 0;
	}

	@Override
	public void visit(TextComposite component) {
		component.getChildrenAsSteam().forEach(el -> el.accept(this));
	}

	@Override
	public void visit(ParagraphComposite component) {
		component.getChildrenAsSteam().forEach(el -> el.accept(this));
	}

	@Override
	public void visit(SentenseComposite component) {
		component.getChildrenList().forEach(el -> el.accept(this));
	}

	@Override
	public void visit(WordComposite component) {
		lexemeCount++;
	}

	@Override
	public void visit(TextLeaf component) {
		// do nothing
	}

	@Override
	public void visit(ExpressionComponent component) {
		lexemeCount++;
	}

}
