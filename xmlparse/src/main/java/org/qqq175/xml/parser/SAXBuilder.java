/**
 * 
 */
package org.qqq175.xml.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.xml.exception.UnableBuildParserException;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * SAXBuilder
 * 
 * @author qqq175
 */
class SAXBuilder extends ParserBuilder {
	private static Logger logger = LogManager.getLogger(SAXBuilder.class);
	private XMLReader reader;
	private SAXHandler handler;

	@Override
	protected void buildParser() throws UnableBuildParserException {
		buildHandler();

		try {
			// create SAX-parser
			reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(handler);
		} catch (SAXException e) {
			throw new UnableBuildParserException(e);
		}

		this.setParser(new SAXParser(this.getPath(), reader, handler));
	}

	/**
	 * make SAX parser handler
	 */
	private void buildHandler() {
		handler = new SAXHandler();
	}

}
