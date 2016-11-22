package org.qqq175.xmlparce.parser;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.qqq175.xml.data.Flowers;
import org.qqq175.xml.exception.UnableBuildParserException;
import org.qqq175.xml.marshaler.GreenhouseMarshaller;
import org.qqq175.xml.parser.FlowerParser;
import org.qqq175.xml.parser.ParserFactory;

public class FlowerParserTest {
	private static String XML_PATH = "resources/flowers.xml";
	private static GreenhouseMarshaller plantMarch;
	private static Flowers flowers;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		plantMarch = new GreenhouseMarshaller();
		flowers = plantMarch.parseFlowers(XML_PATH);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		flowers = null;
		plantMarch = null;
	}

	@Test
	public void testDOM() {
		ParserFactory pFactory = new ParserFactory();
		FlowerParser parser;
		Flowers curFlowers = null;
		try {
			parser = pFactory.getParser(XML_PATH, ParserFactory.Type.DOM);
			curFlowers = parser.parseFlowers();
		} catch (UnableBuildParserException e) {
		}
		Assert.assertEquals(flowers, curFlowers);
	}

	@Test
	public void testStAX() {
		ParserFactory pFactory = new ParserFactory();
		FlowerParser parser;
		Flowers curFlowers = null;
		try {
			parser = pFactory.getParser(XML_PATH, ParserFactory.Type.STAX);
			curFlowers = parser.parseFlowers();
		} catch (UnableBuildParserException e) {
		}
		Assert.assertEquals(flowers, curFlowers);
	}

	@Test
	public void testSAX() {
		ParserFactory pFactory = new ParserFactory();
		FlowerParser parser;
		Flowers curFlowers = null;
		try {
			parser = pFactory.getParser(XML_PATH, ParserFactory.Type.SAX);
			curFlowers = parser.parseFlowers();
		} catch (UnableBuildParserException e) {
		}
		Assert.assertEquals(flowers, curFlowers);
	}

}
