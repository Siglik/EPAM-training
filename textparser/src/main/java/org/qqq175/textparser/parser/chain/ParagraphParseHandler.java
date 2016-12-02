package org.qqq175.textparser.parser.chain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.qqq175.textparser.composite.text.ParagraphComposite;
import org.qqq175.textparser.composite.text.SentenseComposite;

public class ParagraphParseHandler extends ParseHandler<ParagraphComposite> {
	private final String SENTENSE_REGEX = "[^\\.^\\?^!]+([\\.\\?!]+|$)";

	@SuppressWarnings("rawtypes")
	public ParagraphParseHandler(ParseHandler successor) {
		super(successor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleRequest(String text, ParagraphComposite parrent) {
		Pattern pattern = Pattern.compile(SENTENSE_REGEX);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			SentenseComposite sentence = new SentenseComposite();
			parrent.add(sentence);
			successor.chain(matcher.group(), sentence);
		}
	}
}
