package org.qqq175.xml.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.qqq175.xml.data.Flower;
import org.qqq175.xml.data.Flowers;
import org.qqq175.xml.data.GrowingTips;
import org.qqq175.xml.data.ObjectFactory;
import org.qqq175.xml.data.VisualParameters;

/**
 * StAX Flowers parser
 * 
 * @author qqq175
 */
public class StAXParser implements FlowerParser {
	private XMLStreamReader reader;
	private String path;
	private Boolean isDone = false;
	private XMLInputFactory factory;

	/**
	 * construct parser by xml path
	 * 
	 * @param path
	 */
	StAXParser(String path) {
		this.path = path;
		factory = XMLInputFactory.newFactory();
		inicializeParser();

	}

	@Override
	public Flowers parseFlowers() {
		// check if Flower already parsed reinitialize parser
		if (isDone) {
			inicializeParser();
		}
		ObjectFactory factory = new ObjectFactory();
		Flowers flowers = factory.createFlowers();
		List<Flower> flowersList = flowers.getFlower();
		String lastElemName = null;
		Flower flower = null;
		// iterate all elements
		try {
			while (reader.hasNext()) {
				int res = reader.next();
				if (res == XMLStreamConstants.START_ELEMENT) {
					lastElemName = reader.getLocalName();
					switch (lastElemName) {
					case "flower":
						flower = factory.createFlower();
						flower.setId(reader.getAttributeValue(null, "id"));
						flower.setName(reader.getAttributeValue(null, "name"));
						flower.setOrigin(reader.getAttributeValue(null, "origin"));
						break;
					case "visualParameters":
						VisualParameters vp = factory.createVisualParameters();
						vp.setStemColor(reader.getAttributeValue(null, "stemColor"));
						vp.setLeafColor(reader.getAttributeValue(null, "leafColor"));
						vp.setFlowerColor(reader.getAttributeValue(null, "flowerColor"));
						vp.setSize(Integer.parseInt(reader.getAttributeValue(null, "size")));
						flower.setVisualParameters(vp);
						break;
					case "growingTips":
						GrowingTips gt = factory.createGrowingTips();
						gt.setWatering(Integer.parseInt(reader.getAttributeValue(null, "watering")));
						gt.setTemperature(Integer.parseInt(reader.getAttributeValue(null, "temperature")));
						gt.setHeliophilous(Boolean.parseBoolean(reader.getAttributeValue(null, "heliophilous")));
						flower.setGrowingTips(gt);
						break;
					}
				} else if (res == XMLStreamConstants.CHARACTERS) {
					if (lastElemName != null) {
						System.out.println(lastElemName);
						switch (lastElemName) {
						case "soil":
							flower.setSoil(reader.getText());
							break;
						case "multiplying":
							flower.setMultiplying(reader.getText());
							break;
						}
					}
				} else if (res == XMLStreamConstants.END_ELEMENT) {
					// when reach </flower> - save the flower
					if (reader.getLocalName().equals("flower")) {
						flowersList.add(flower);
						flower = null;
					}
					lastElemName = null;
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		isDone = true;
		return flowers;
	}

	private void inicializeParser() {
		// create XMLStreamReader instance
		try {
			reader = factory.createXMLStreamReader(new FileInputStream(path));
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}
	}
}
