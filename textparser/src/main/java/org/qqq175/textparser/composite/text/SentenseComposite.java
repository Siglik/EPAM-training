package org.qqq175.textparser.composite.text;

import java.util.List;

import org.qqq175.textparser.visitor.TextVisitor;

public class SentenseComposite extends AbstractTextComposite<TextComponent> {

	public SentenseComposite() {
	}

	public SentenseComposite(List<TextComponent> children) {
		super(children);
	}

	@Override
	public void accept(TextVisitor<?> visitor) {
		visitor.visit(this);
	}
}
