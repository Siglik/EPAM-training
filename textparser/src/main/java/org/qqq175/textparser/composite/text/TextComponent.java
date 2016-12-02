package org.qqq175.textparser.composite.text;

import org.qqq175.textparser.visitor.TextVisitor;

public abstract class TextComponent {
	public abstract void accept(TextVisitor<?> visitor);
}
