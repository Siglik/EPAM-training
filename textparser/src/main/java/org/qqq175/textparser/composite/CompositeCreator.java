package org.qqq175.textparser.composite;

import org.qqq175.textparser.composite.text.TextComposite;
import org.qqq175.textparser.parser.chain.ParagraphParseHandler;
import org.qqq175.textparser.parser.chain.SentenseParseHandler;
import org.qqq175.textparser.parser.chain.TextParseHandler;
import org.qqq175.textparser.parser.chain.WordParseHandler;

public class CompositeCreator {

	public TextComposite create(String text) {

		WordParseHandler wordParser = new WordParseHandler(null);
		SentenseParseHandler sentenseParser = new SentenseParseHandler(wordParser);
		ParagraphParseHandler paragraphParser = new ParagraphParseHandler(sentenseParser);
		TextParseHandler textParser = new TextParseHandler(paragraphParser);

		TextComposite root = new TextComposite();
		textParser.handleRequest(text, root);

		return root;
	}

}
