package org.qqq175.xml.marshaler;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.xml.data.Flowers;

public class GreenhouseMarshaller {
	private static Logger logger = LogManager.getLogger(GreenhouseMarshaller.class);

	public Flowers parseFlowers(String path) {
		Flowers greengouse = null;
		try {
			JAXBContext jaxbc = JAXBContext.newInstance(Flowers.class);
			Unmarshaller unmarsh = jaxbc.createUnmarshaller();

			greengouse = (Flowers) unmarsh.unmarshal(new FileReader(path));
		} catch (JAXBException e) {
			logger.log(Level.ERROR, "Error while marshalling the document:\n", e);
		} catch (FileNotFoundException e) {
			logger.log(Level.ERROR, "Error while marshalling the document:\n", e);
		}

		return greengouse;
	}
}
