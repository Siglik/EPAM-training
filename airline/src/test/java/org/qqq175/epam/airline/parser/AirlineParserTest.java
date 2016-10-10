package org.qqq175.epam.airline.parser;

import org.junit.Test;
import org.qqq175.epam.airline.exception.unchecked.InputFileIsMissingException;

public class AirlineParserTest {

	@Test(expected = InputFileIsMissingException.class)
	public void parseTestBadPathException() {
		String badPath = "..";
		AirplaneParser parser = new AirplaneParser();
		parser.parse(badPath);
	}

}
