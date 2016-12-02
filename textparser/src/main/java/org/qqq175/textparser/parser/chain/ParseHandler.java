package org.qqq175.textparser.parser.chain;

import org.qqq175.textparser.composite.text.TextComponent;

@SuppressWarnings("rawtypes")
public abstract class ParseHandler<T extends TextComponent> {
	protected ParseHandler successor; // =

	abstract public void handleRequest(String text, T parrent);

	public ParseHandler(ParseHandler successor) {
		this.successor = successor;
	}

	protected void chain(String text, T parrent) {
		handleRequest(text, parrent);
	}
}
