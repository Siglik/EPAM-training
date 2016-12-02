package org.qqq175.textparser.composite.expression;

import org.qqq175.textparser.composite.text.TextComponent;
import org.qqq175.textparser.visitor.ExpressionVisitor;
import org.qqq175.textparser.visitor.TextVisitor;

public abstract class ExpressionComponent extends TextComponent {
	public void accept(TextVisitor<?> visitor){
		visitor.visit(this);
	}
	public abstract void accept(ExpressionVisitor visitor);
}
