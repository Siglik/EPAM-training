package org.qqq175.textparser.main;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.textparser.composite.CompositeCreator;
import org.qqq175.textparser.composite.text.TextComposite;
import org.qqq175.textparser.exceptions.UnacceptableArgument;
import org.qqq175.textparser.postprocess.TextUtil;
import org.qqq175.textparser.reader.TextReader;
import org.qqq175.textparser.visitor.ExpressionVisitor;
import org.qqq175.textparser.visitor.InfixExpressionVisitor;
import org.qqq175.textparser.visitor.PostfixExpressionVisitor;
import org.qqq175.textparser.visitor.PrintTextVisitor;
import org.qqq175.textparser.visitor.TextVisitor;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger logger = LogManager.getLogger(App.class);

	private String filePath;

	public App(String filePath) {
		this.filePath = filePath;
	}

	public void start() {
		TextReader reader = new TextReader();

		CompositeCreator creator = new CompositeCreator();

		TextUtil textUtil = new TextUtil();

		TextComposite textRoot = creator.create(reader.readAll(filePath));

		// print the text with calculated expressions
		TextVisitor<?> textVisitor = new PrintTextVisitor();
		textRoot.accept(textVisitor);
		logger.log(Level.INFO, textVisitor.result() + "\n");

		// print the text with expression in postfix notation
		ExpressionVisitor exprVisitor = new PostfixExpressionVisitor();
		textVisitor = new PrintTextVisitor(exprVisitor);

		textRoot.accept(textVisitor);
		logger.log(Level.INFO, textVisitor.result());

		// sort sentenses and print the text with calculated expressions
		try {
			TextComposite sorted = textUtil.sortSenteneceByLexemeCount(textRoot);
			textVisitor = new PrintTextVisitor();
			sorted.accept(textVisitor);
			logger.log(Level.INFO, textVisitor.result() + "\n");
		} catch (UnacceptableArgument e) {
			logger.log(Level.ERROR, e.getMessage(), e);
		}

		// sort words and print
		try {
			TextComposite sorted = textUtil.sortLexemeByAlphabet(textRoot);
			textVisitor.reset();
			sorted.accept(textVisitor);
			logger.log(Level.INFO, textVisitor.result() + "\n");
		} catch (UnacceptableArgument e) {
			logger.log(Level.ERROR, e.getMessage(), e);
		}

		// swap sentence lexemes and print the text with expression in infix
		// notation
		try {
			textUtil.swapSentenceLexemes(textRoot);
			exprVisitor = new InfixExpressionVisitor();
			textVisitor = new PrintTextVisitor(exprVisitor);
			textRoot.accept(textVisitor);
			logger.log(Level.INFO, textVisitor.result() + "\n");
		} catch (UnacceptableArgument e) {
			logger.log(Level.ERROR, e.getMessage(), e);
		}

	}
}
