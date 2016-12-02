package org.qqq175.textparser.visitor;

import java.util.List;

import org.qqq175.textparser.composite.expression.ExpressionComponent;
import org.qqq175.textparser.composite.text.ParagraphComposite;
import org.qqq175.textparser.composite.text.SentenseComposite;
import org.qqq175.textparser.composite.text.TextComponent;
import org.qqq175.textparser.composite.text.TextComposite;
import org.qqq175.textparser.composite.text.TextLeaf;
import org.qqq175.textparser.composite.text.WordComposite;

public class SwapFirstLastVisitor implements TextVisitor<Integer> {
	Integer swappedCount;

	/**
	 * 
	 */
	public SwapFirstLastVisitor() {
		swappedCount = 0;
	}

	@Override
	public Integer result() {
		return swappedCount;
	}

	@Override
	public void reset() {
		swappedCount = 0;
	}

	private <T extends TextComponent> void swap(List<T> list) {
		T first = list.get(0);
		T last = list.get(list.size() - 1);
		list.set(0, last);
		list.set(list.size() - 1, first);
	}

	@Override
	public void visit(TextComposite component) {
		swap(component.getChildrenList());
		swappedCount++;
	}

	@Override
	public void visit(ParagraphComposite component) {
		swap(component.getChildrenList());
		swappedCount++;
	}

	@Override
	public void visit(SentenseComposite component) {
		List<TextComponent> children = component.getChildrenList();
		int firstIdx = -1;
		int lastIdx = -1;
		for (int i = 0; i < children.size(); i++) {
			if (children.get(i) instanceof WordComposite) {
				if (firstIdx == -1) {
					firstIdx = i;
				}
				lastIdx = i;
			}
		}
		if (firstIdx != -1 && lastIdx != -1) {
			TextComponent first = children.get(firstIdx);
			TextComponent last = children.get(lastIdx);
			children.set(firstIdx, last);
			children.set(lastIdx, first);
		}
	}

	@Override
	public void visit(WordComposite component) {
		swap(component.getChildrenList());
		swappedCount++;
	}

	@Override
	public void visit(TextLeaf component) {

	}

	@Override
	public void visit(ExpressionComponent component) {

	}

}
