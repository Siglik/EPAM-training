package org.qqq175.xml.parser;

import java.util.List;

import org.qqq175.xml.data.Flower;
import org.qqq175.xml.data.Flowers;
import org.qqq175.xml.data.GrowingTips;
import org.qqq175.xml.data.ObjectFactory;
import org.qqq175.xml.data.VisualParameters;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * DOM parser for Flowers xml
 * 
 * @author qqq175
 */
public class DOMParser implements FlowerParser {
	private final Element root;

	/**
	 * @param doc
	 */
	DOMParser(Document doc) {
		// save doc root
		root = doc.getDocumentElement();
	}

	@Override
	public Flowers parseFlowers() {
		ObjectFactory factory = new ObjectFactory();
		Flowers flowers = factory.createFlowers();
		List<Flower> flowersList = flowers.getFlower();
		NodeList nList = root.getChildNodes();

		// iterate FlowerList child nodes
		for (int i = 0; i < nList.getLength(); i++) {

			// if found an elemennt
			if (nList.item(i) instanceof Element) {
				// get Flower child nodes
				Element curBaseElem = (Element) nList.item(i);
				Flower flower = factory.createFlower();
				flower.setId(curBaseElem.getAttribute("id"));
				flower.setName(curBaseElem.getAttribute("name"));
				flower.setOrigin(curBaseElem.getAttribute("origin"));
				// iterate Flowers child nodes
				NodeList nListFlower = curBaseElem.getChildNodes();
				for (int j = 0; j < nListFlower.getLength(); j++) {
					if (nListFlower.item(j) instanceof Element) {
						Element curElem = (Element) nListFlower.item(j);

						// determine elemnt by name and get it value
						switch (curElem.getTagName()) {
						case "soil":
							flower.setSoil(curElem.getTextContent());
							break;
						case "multiplying":
							flower.setMultiplying(curElem.getTextContent());
							break;
						case "visualParameters":
							VisualParameters vp = factory.createVisualParameters();
							vp.setStemColor(curElem.getAttribute("stemColor"));
							vp.setLeafColor(curElem.getAttribute("leafColor").isEmpty() ? null : curElem.getAttribute("leafColor"));
							vp.setFlowerColor(curElem.getAttribute("flowerColor").isEmpty() ? null : curElem.getAttribute("flowerColor"));
							vp.setSize(Integer.parseInt(curElem.getAttribute("size")));
							flower.setVisualParameters(vp);
							break;
						case "growingTips":
							GrowingTips gt = factory.createGrowingTips();
							gt.setWatering(Integer.parseInt(curElem.getAttribute("watering")));
							gt.setTemperature(Integer.parseInt(curElem.getAttribute("temperature")));
							gt.setHeliophilous(Boolean.parseBoolean(curElem.getAttribute("heliophilous")));
							flower.setGrowingTips(gt);
							break;
						}
					}
				}

				// save current Flower
				flowersList.add(flower);
				flower = null;
			}
		}
		return flowers;
	}
}
