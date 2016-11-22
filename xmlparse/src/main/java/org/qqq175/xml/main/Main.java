package org.qqq175.xml.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.xml.validator.XMLValidator;

public class Main {
	static Logger logger = LogManager.getLogger(XMLValidator.class);

	public static void main(String[] args) {
		App app = new App();
		app.start();
	}

}
