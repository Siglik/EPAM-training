package org.qqq175.textparser.composite.text;

import org.qqq175.textparser.visitor.TextVisitor;

public class TextLeaf extends TextComponent {
	private char item;
	private final NodeType type;

	public enum NodeType {
		LETTER, PUNCTUATION, SPACE
	}

	/**
	 * @param item
	 */
	public TextLeaf(NodeType type, char item) {
		this.item = item;
		this.type = type;
	}

	public char item() {
		return item;
	}

	@Override
	public void accept(TextVisitor<?> visitor) {
		visitor.visit(this);
	}

	public NodeType getType() {
		return type;
	}
}