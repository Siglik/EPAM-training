/**
 * 
 */
package org.qqq175.xml.parser;

import java.io.IOException;

import org.qqq175.xml.data.Flowers;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * @author qqq175
 *
 */
public class SAXParser implements FlowerParser {
	private String path;
	private XMLReader reader;
	private SAXHandler handler;
	private Boolean isParsed = false;

	SAXParser(String path, XMLReader reader, SAXHandler handler) {
		this.path = path;
		this.reader = reader;
		this.handler = handler;
	}

	/**
	 * parse file when first executed
	 */
	private void checkAndParce() {
		if (!isParsed) {
			try {
				reader.parse(path);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
			isParsed = true;
		}
	}

	/**
	 * @see org.qqq175.it_academy.jd1.classworks.parsers.factory.FlowerParser#getFlowers()
	 */
	@Override
	public Flowers parseFlowers() {
		checkAndParce(); // parse only one

		return handler.getFlowers();
	}

}
