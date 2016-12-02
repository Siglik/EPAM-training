package org.qqq175.textparser.parser.test;

import java.util.ArrayList;
import java.util.List;

import org.qqq175.textparser.composite.expression.ExpressionComponent;
import org.qqq175.textparser.parser.ExpressionTreeBuilder;

public class TestExpressionThreeBuilder extends ExpressionTreeBuilder {
	private List<String> children = new ArrayList<>();;

	@Override
	public ExpressionComponent build(String expression) {
		children.add(expression);
		return null;
	}

	/**
	 * @return the children
	 */
	public List<String> getChildren() {
		return children;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(List<String> children) {
		this.children = children;
	}
}
