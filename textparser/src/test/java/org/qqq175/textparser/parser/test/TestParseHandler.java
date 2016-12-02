package org.qqq175.textparser.parser.test;

import java.util.ArrayList;
import java.util.List;

import org.qqq175.textparser.composite.text.TextComponent;
import org.qqq175.textparser.parser.chain.ParseHandler;

public class TestParseHandler extends ParseHandler<TextComponent> {
	private List<String> children;

	public TestParseHandler(ParseHandler successor) {
		super(successor);
		children = new ArrayList<>();
	}

	@Override
	public void handleRequest(String text, TextComponent parrent) {
		children.add(text);
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
