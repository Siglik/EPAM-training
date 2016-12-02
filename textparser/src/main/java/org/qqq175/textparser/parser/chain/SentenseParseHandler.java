package org.qqq175.textparser.parser.chain;

import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.qqq175.textparser.composite.ComponentOrderWrapper;
import org.qqq175.textparser.composite.expression.ExpressionComponent;
import org.qqq175.textparser.composite.text.SentenseComposite;
import org.qqq175.textparser.composite.text.TextLeaf;
import org.qqq175.textparser.composite.text.WordComposite;
import org.qqq175.textparser.parser.ExpressionTreeBuilder;

public class SentenseParseHandler extends ParseHandler<SentenseComposite> {
	private final String WORD_REGEX = "[[\\w]&&[\\D]]+([-']?\\w+)*";
	private final String PUNCTUATION_REGEX = "([!.?,:;\"`])|\\s(-)\\s|\\W(')|(')([!.?,:;\"`])|(')\\W";
	private final String SPACE_REGEX = "\\s";
	private final String EXPRESSION_REGEX = "[ ]([\\d(+\\-/)*]*[\\d]+[\\d(+\\-/)*]*)[.,:; !?]{1}";

	private ExpressionTreeBuilder builder = new ExpressionTreeBuilder();

	public SentenseParseHandler(ParseHandler successor, ExpressionTreeBuilder builder) {
		super(successor);
		this.builder = builder;
	}

	public SentenseParseHandler(ParseHandler<?> successor) {
		super(successor);
		builder = new ExpressionTreeBuilder();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleRequest(String text, SentenseComposite parrent) {
		PriorityQueue<ComponentOrderWrapper> children = new PriorityQueue<ComponentOrderWrapper>();
		text = prepare(text);
		Pattern pattern = Pattern.compile(WORD_REGEX);
		Matcher matcher = pattern.matcher(text);
		while (matcher.find()) {
			WordComposite word = new WordComposite();
			successor.chain(matcher.group(), word);
			children.add(new ComponentOrderWrapper(word, matcher.start()));
		}

		pattern = Pattern.compile(EXPRESSION_REGEX);
		matcher = pattern.matcher(text);
		while (matcher.find()) {
			ExpressionComponent root = builder.build(matcher.group(1));
			children.add(new ComponentOrderWrapper(root, matcher.start(1)));
		}

		pattern = Pattern.compile(SPACE_REGEX);
		matcher = pattern.matcher(text);
		while (matcher.find()) {
			TextLeaf punct = new TextLeaf(TextLeaf.NodeType.SPACE, matcher.group().charAt(0));
			children.add(new ComponentOrderWrapper(punct, matcher.start()));
		}

		pattern = Pattern.compile(PUNCTUATION_REGEX);
		matcher = pattern.matcher(text);
		while (matcher.find()) {
			int i;
			for (i = 1; i <= matcher.groupCount(); i++) {
				if (matcher.group(i) != null) {
					TextLeaf punct = new TextLeaf(TextLeaf.NodeType.PUNCTUATION, matcher.group(i).charAt(0));
					children.add(new ComponentOrderWrapper(punct, matcher.start(i)));
				}
			}
		}
		while (!children.isEmpty()) {
			parrent.add(children.poll().getItem());
		}
	}

	private String prepare(String text) {
		return " " + text + " ";
	}

}
