package org.qqq175.airline.parser;

import org.junit.Test;
import org.qqq175.airline.parser.AirplaneParser;

public class AirlineParserTest {

	@Test(expected = RuntimeException.class)
	public void parseTestBadPathException() {
		String badPath = "..";
		AirplaneParser parser = new AirplaneParser();
		parser.parse(badPath);
	}

}
