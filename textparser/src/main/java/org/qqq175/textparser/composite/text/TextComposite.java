package org.qqq175.textparser.composite.text;

import java.util.List;

import org.qqq175.textparser.visitor.TextVisitor;

public class TextComposite extends AbstractTextComposite<ParagraphComposite> {
	public TextComposite() {
	}

	public TextComposite(List<ParagraphComposite> children) {
		super(children);
	}

	@Override
	public void accept(TextVisitor<?> visitor) {
		visitor.visit(this);
	}
}
