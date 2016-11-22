/**
 * 
 */
package org.qqq175.xml.parser;

import java.util.List;

import org.qqq175.xml.data.Flower;
import org.qqq175.xml.data.Flowers;
import org.qqq175.xml.data.GrowingTips;
import org.qqq175.xml.data.ObjectFactory;
import org.qqq175.xml.data.VisualParameters;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author qqq175
 *
 */
public class SAXHandler extends DefaultHandler {
	private String element;
	private Flower flower;
	private Flowers flowers;
	private List<Flower> flowersList;
	private String rootName = null;
	private ObjectFactory factory;

	/**
	 * Constructor
	 */
	public SAXHandler() {
		factory = new ObjectFactory();
		flowers = factory.createFlowers();
		flowersList = flowers.getFlower();
	}

	@Override
	public void startDocument() {
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) {
		// if first element didnt found current is first
		// save it
		if (rootName == null) {
			rootName = qName;
		}

		element = localName;

		switch (element) {
		case "flower":
			flower = factory.createFlower();
			flower.setId(attrs.getValue("id"));
			flower.setName(attrs.getValue("name"));
			flower.setOrigin(attrs.getValue("origin"));
			break;
		case "visualParameters":
			VisualParameters vp = factory.createVisualParameters();
			vp.setStemColor(attrs.getValue("stemColor"));
			vp.setLeafColor(attrs.getValue("leafColor"));
			vp.setFlowerColor(attrs.getValue("flowerColor"));
			vp.setSize(Integer.parseInt(attrs.getValue("size")));
			flower.setVisualParameters(vp);
			break;
		case "growingTips":
			GrowingTips gt = factory.createGrowingTips();
			gt.setWatering(Integer.parseInt(attrs.getValue("watering")));
			gt.setTemperature(Integer.parseInt(attrs.getValue("temperature")));
			gt.setHeliophilous(Boolean.parseBoolean(attrs.getValue("heliophilous")));
			flower.setGrowingTips(gt);
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {
		// fill currentFlower fields
		switch (element) {
		case "soil":
			flower.setSoil(new String(ch, start, length).trim());
			break;
		case "multiplying":
			flower.setMultiplying(new String(ch, start, length).trim());
			break;
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName) {
		// save current Flower if reached </Flower> tag
		if (localName.equals("flower")) {
			flowersList.add(flower);
		}
		element = "";
	}

	@Override
	public void endDocument() {
	}

	public Flowers getFlowers() {
		return flowers;
	}
}
