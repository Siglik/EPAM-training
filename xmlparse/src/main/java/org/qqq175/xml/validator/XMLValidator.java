package org.qqq175.xml.validator;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

public class XMLValidator {
	static Logger logger = LogManager.getLogger(XMLValidator.class);
	private String lastError = "";

	public boolean validate(String xmlPath, String xsdPath) {

		Source xmlFile = new StreamSource(new File(xmlPath));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		Schema schema;
		try {
			schema = schemaFactory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);
			return true;
		} catch (SAXException e) {
			logger.log(Level.ERROR, "Error while validating the document:\n", e);
		} catch (IOException e) {
			logger.log(Level.ERROR, "Error while validating the document:\n", e);
		}
		return false;
	}

	/**
	 * @return the lastError
	 */
	public String getLastError() {
		return lastError;
	}
}
