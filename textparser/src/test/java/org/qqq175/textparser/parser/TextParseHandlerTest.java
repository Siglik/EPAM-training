package org.qqq175.textparser.parser;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.qqq175.textparser.composite.text.TextComposite;
import org.qqq175.textparser.parser.chain.TextParseHandler;
import org.qqq175.textparser.parser.test.TestParseHandler;

public class TextParseHandlerTest {
	static String text = "Par 1.\n Par 2!\n Par 3. Par 3.\n\tPAR 4;";

	static List<String> pars;

	static List<String> result;

	@Before
	public void setUp() throws Exception {
		pars = new ArrayList<>();
		pars.add("Par 1.");
		pars.add(" Par 2!");
		pars.add(" Par 3. Par 3.");
		pars.add("\tPAR 4;");
		TestParseHandler testParser = new TestParseHandler(null);
		TextParseHandler textParser = new TextParseHandler(testParser);
		TextComposite root = new TextComposite();
		textParser.handleRequest(text, root);
		result = testParser.getChildren();
		root = null;
	}

	@After
	public void setDown() throws Exception {
		pars = null;
		result = null;
	}

	@Test
	public void testPasre() {
		Assert.assertEquals(4, result.size());
		Assert.assertEquals(pars.get(0), result.get(0));
		Assert.assertEquals(pars.get(1), result.get(1));
		Assert.assertEquals(pars.get(2), result.get(2));
		Assert.assertEquals(pars.get(3), result.get(3));
	}

}
