package org.qqq175.textparser.parser.chain;

import org.qqq175.textparser.composite.text.TextLeaf;
import org.qqq175.textparser.composite.text.WordComposite;

public class WordParseHandler extends ParseHandler<WordComposite> {

	@SuppressWarnings("rawtypes")
	public WordParseHandler(ParseHandler successor) {
		super(successor);
	}

	@Override
	public void handleRequest(String text, WordComposite parrent) {
		for (char letter : text.toCharArray()) {
			TextLeaf leaf = new TextLeaf(TextLeaf.NodeType.LETTER, letter);
			parrent.add(leaf);
		}
	}
}
