package org.qqq175.textparser.parser.chain;

import java.util.Arrays;

import org.qqq175.textparser.composite.text.ParagraphComposite;
import org.qqq175.textparser.composite.text.TextComposite;

public class TextParseHandler extends ParseHandler<TextComposite> {

	@SuppressWarnings("rawtypes")
	public TextParseHandler(ParseHandler successor) {
		super(successor);
	}

	private final String PARAGRAPH_REGEX_DELIMETER = "\\n";

	@SuppressWarnings("unchecked")
	@Override
	public void handleRequest(String text, TextComposite parrent) {
		String[] paragraphs = text.split(PARAGRAPH_REGEX_DELIMETER);
		Arrays.asList(paragraphs).stream().forEach(p -> {
			ParagraphComposite par = new ParagraphComposite();
			parrent.add(par);
			successor.chain(p, par);
		});
	}
}
