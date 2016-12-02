package org.qqq175.textparser.parser;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.qqq175.textparser.composite.text.ParagraphComposite;
import org.qqq175.textparser.parser.chain.ParagraphParseHandler;
import org.qqq175.textparser.parser.test.TestParseHandler;

public class ParagraphParseHandlerTest {

	static String text = "Sent 1. The sentence 2! sent 3 - sent 3. Sent 4; still 4";

	static List<String> sent;

	static List<String> result;

	@Before
	public void setUp() throws Exception {
		sent = new ArrayList<>();
		sent.add("Sent 1.");
		sent.add(" The sentence 2!");
		sent.add(" sent 3 - sent 3.");
		sent.add(" Sent 4; still 4");
		TestParseHandler testParser = new TestParseHandler(null);
		ParagraphParseHandler textParser = new ParagraphParseHandler(testParser);
		ParagraphComposite root = new ParagraphComposite();
		textParser.handleRequest(text, root);
		result = testParser.getChildren();
		root = null;
	}

	@After
	public void setDown() throws Exception {
		sent = null;
		result = null;
	}

	@Test
	public void testPasre() {
		Assert.assertEquals(sent.get(0), result.get(0));
		Assert.assertEquals(sent.get(1), result.get(1));
		Assert.assertEquals(sent.get(2), result.get(2));
		Assert.assertEquals(sent.get(3), result.get(3));
		Assert.assertEquals(4, result.size());
	}

}
