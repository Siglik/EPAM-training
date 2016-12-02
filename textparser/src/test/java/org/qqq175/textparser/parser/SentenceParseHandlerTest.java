package org.qqq175.textparser.parser;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.qqq175.textparser.composite.text.SentenseComposite;
import org.qqq175.textparser.parser.chain.SentenseParseHandler;
import org.qqq175.textparser.parser.test.TestExpressionThreeBuilder;
import org.qqq175.textparser.parser.test.TestParseHandler;

public class SentenceParseHandlerTest {

	static String text = "Hello -7 my: -(5+2).";

	static List<String> words;
	static List<String> expr;
	static List<String> chars;

	static List<String> result;
	static List<String> resultExpr;

	@Before
	public void setUp() throws Exception {
		words = new ArrayList<>();
		words.add("Hello");
		words.add("my");
		chars = expr = new ArrayList<>();
		chars.add(" ");
		chars.add(" ");
		chars.add(":");
		chars.add(" ");
		chars.add(".");
		expr = new ArrayList<>();
		expr.add("-7");
		expr.add("-(5+2)");
		System.out.println(":" + expr.get(1));
		TestParseHandler testParser = new TestParseHandler(null);
		TestExpressionThreeBuilder expBulilder = new TestExpressionThreeBuilder();
		SentenseParseHandler textParser = new SentenseParseHandler(testParser, expBulilder);
		SentenseComposite root = new SentenseComposite();
		textParser.handleRequest(text, root);
		result = testParser.getChildren();
		resultExpr = expBulilder.getChildren();
		root = null;
	}

	@After
	public void setDown() throws Exception {
		words = null;
		expr = null;
		result = null;
		resultExpr = null;
	}

	@Test
	public void testPasre() {
		Assert.assertEquals(words.get(0), result.get(0));
		Assert.assertEquals(words.get(1), result.get(1));
		Assert.assertEquals(expr.get(0), resultExpr.get(0));
		Assert.assertEquals(expr.get(1), resultExpr.get(1));
		Assert.assertEquals(2, result.size());
		Assert.assertEquals(2, resultExpr.size());
	}
}
