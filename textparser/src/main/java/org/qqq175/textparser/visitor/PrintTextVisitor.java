package org.qqq175.textparser.visitor;

import org.qqq175.textparser.composite.expression.ExpressionComponent;
import org.qqq175.textparser.composite.text.ParagraphComposite;
import org.qqq175.textparser.composite.text.SentenseComposite;
import org.qqq175.textparser.composite.text.TextComposite;
import org.qqq175.textparser.composite.text.TextLeaf;
import org.qqq175.textparser.composite.text.WordComposite;

public class PrintTextVisitor implements TextVisitor<String> {
	ExpressionVisitor expressionVisitor;
	StringBuilder result;

	/**
	 * @param expressionVisitor
	 */
	public PrintTextVisitor() {
		this.expressionVisitor = new EvalExpressionVisitor();
		result = new StringBuilder();
	}

	/**
	 * @param expressionVisitor
	 */
	public PrintTextVisitor(ExpressionVisitor expressionVisitor) {
		this.expressionVisitor = expressionVisitor;
		expressionVisitor.reset();
		result = new StringBuilder();
	}

	@Override
	public void visit(TextComposite component) {
		component.getChildrenAsSteam().forEach(el -> el.accept(this));
	}

	@Override
	public void visit(ParagraphComposite component) {
		component.getChildrenList().forEach(el -> el.accept(this));
		result.append("\n");
	}

	@Override
	public void visit(SentenseComposite component) {
		
		component.getChildrenList().forEach(el -> el.accept(this));
	}

	@Override
	public void visit(WordComposite component) {
		component.getChildrenList().forEach(el -> el.accept(this));
	}

	@Override
	public void visit(TextLeaf component) {
		result.append(component.item());
	}

	@Override
	public void visit(ExpressionComponent component) {
		component.accept(expressionVisitor);
		result.append(expressionVisitor.result());
		expressionVisitor.reset();
	}

	@Override
	public String result() {
		return result.toString();
	}

	@Override
	public void reset() {
		result = new StringBuilder();
	}

}
