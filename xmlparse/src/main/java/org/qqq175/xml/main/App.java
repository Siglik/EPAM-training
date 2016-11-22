package org.qqq175.xml.main;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.xml.data.Flowers;
import org.qqq175.xml.exception.UnableBuildParserException;
import org.qqq175.xml.marshaler.GreenhouseMarshaller;
import org.qqq175.xml.parser.FlowerParser;
import org.qqq175.xml.parser.ParserFactory;
import org.qqq175.xml.validator.XMLValidator;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger logger = LogManager.getLogger(App.class);
	private static String XML_PATH = "resources/flowers.xml";
	private static String XSD_PATH = "resources/flowers.xsd";

	public void start() {

		XMLValidator validator = new XMLValidator();
		if (validator.validate(XML_PATH, XSD_PATH)) {

			logger.log(Level.INFO, "Xml валиден.");
			GreenhouseMarshaller plantMarch = new GreenhouseMarshaller();
			Flowers greenhouse = plantMarch.parseFlowers(XML_PATH);
			logger.log(Level.INFO, "MARSHALLER: " + greenhouse);

			ParserFactory pFactory = new ParserFactory();
			FlowerParser parser;
			try {
				parser = pFactory.getParser(XML_PATH, ParserFactory.Type.DOM);
				logger.log(Level.INFO, "DOM parser: " + parser.parseFlowers());
			} catch (UnableBuildParserException e) {
				logger.log(Level.ERROR, "Error while building parser:\n", e);
			}
			try {
				parser = pFactory.getParser(XML_PATH, ParserFactory.Type.STAX);
				logger.log(Level.INFO, "StAX parser: " + parser.parseFlowers());
			} catch (UnableBuildParserException e) {
				logger.log(Level.ERROR, "Error while building parser:\n", e);
			}
			try {
				parser = pFactory.getParser(XML_PATH, ParserFactory.Type.SAX);
				logger.log(Level.INFO, "SAX parser: " + parser.parseFlowers());
			} catch (UnableBuildParserException e) {
				logger.log(Level.ERROR, "Error while building parser:\n", e);
			}

		} else {
			logger.log(Level.FATAL, "Xml инвалиден.\n Причина: " + validator.getLastError());
		}
	}
}
