package org.qqq175.textparser.composite.text;

import java.util.List;

import org.qqq175.textparser.visitor.TextVisitor;

public class WordComposite extends AbstractTextComposite<TextLeaf> {

	public WordComposite() {
	}

	public WordComposite(List<TextLeaf> children) {
		super(children);
	}

	@Override
	public void accept(TextVisitor<?> visitor) {
		visitor.visit(this);
	}
}
