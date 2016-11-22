/**
 * 
 */
package org.qqq175.xml.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.xml.exception.UnableBuildParserException;

/**
 * @author qqq175
 *
 */
public class ParserFactory {
	private static Logger logger = LogManager.getLogger(ParserFactory.class);

	/**
	 * supported parser types
	 * 
	 * @author qqq175
	 *
	 */
	public enum Type {
		DOM, SAX, STAX;
	}

	/**
	 * return concrete parser
	 * 
	 * @param path
	 * @param type
	 * @return
	 * @throws UnableBuildParserException
	 */
	public FlowerParser getParser(String path, Type type) throws UnableBuildParserException {
		ParserBuilder builder;

		switch (type) {
		case DOM:
			builder = new DOMBuilder();
			break;
		case SAX:
			builder = new SAXBuilder();
			break;
		case STAX:
			builder = new StAXBuilder();
			break;
		default:
			logger.log(Level.FATAL, "Unknown element " + type.toString() + " of enum " + type.getClass().toString());
			throw new RuntimeException("Unknown element " + type.toString() + " of enum " + type.getClass().toString());
		}

		builder.setPath(path);
		builder.buildParser();

		return builder.getParser();
	}
}
