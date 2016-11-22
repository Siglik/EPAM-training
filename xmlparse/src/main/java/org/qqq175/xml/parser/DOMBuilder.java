package org.qqq175.xml.parser;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.qqq175.xml.exception.UnableBuildParserException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * 
 * @author qqq175
 */
public class DOMBuilder extends ParserBuilder {

	@Override
	protected void buildParser() throws UnableBuildParserException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder = null;

		Document doc = null;

		// make new document builder
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		File f = new File(this.getPath());

		// make doc from file
		try {
			doc = builder.parse(f);
		} catch (SAXException e) {
			throw new UnableBuildParserException(e);
		} catch (IOException e) {
			throw new UnableBuildParserException(e);
		}

		this.setParser(new DOMParser(doc));
	}
}
