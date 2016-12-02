package org.qqq175.textparser.composite.text;

import java.util.List;

import org.qqq175.textparser.visitor.TextVisitor;

public class ParagraphComposite extends AbstractTextComposite<SentenseComposite> {

	/**
	 * 
	 */
	public ParagraphComposite() {
	}

	/**
	 * @param children
	 */
	public ParagraphComposite(List<SentenseComposite> children) {
		super(children);
	}

	@Override
	public void accept(TextVisitor<?> visitor) {
		visitor.visit(this);
	}

}
