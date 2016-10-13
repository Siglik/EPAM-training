package org.qqq175.airline.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.airline.airplane.Plane;
import org.qqq175.airline.creator.PlaneCreator;
import org.qqq175.airline.creator.CreatorFactory;
import org.qqq175.airline.exception.InputDataCorruptedException;

public class AirplaneParser {

	private static Logger logger = LogManager.getLogger(AirplaneParser.class.getName());
	private static final String DELIMITER = "\\s*,\\s*";

	private Scanner initScanner(String filePath) {
		Scanner scan;
		try {
			File file = new File(filePath);
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			logger.log(Level.ERROR, "File \'" + filePath + "\' isn't exist.", e);
			throw new RuntimeException(e);
		}
		return scan;
	}

	public List<Plane> parse(String filePath) {
		List<Plane> airplanes = new ArrayList<>();
		Scanner fileScan = initScanner(filePath);
		int currentLine = 0;

		while (fileScan.hasNext()) {
			currentLine++;
			List<String> current = Arrays.asList(fileScan.nextLine().split(DELIMITER));

			if (current.size() > 0) {
				PlaneCreator creator;
				Plane currentPlane;
				try {
					creator = CreatorFactory.getCreator(current.get(0));
					currentPlane = creator.create(current);
					airplanes.add(currentPlane);
				} catch (InputDataCorruptedException e) {
					logger.log(Level.ERROR, "Illegal data at line " + currentLine + " (" + filePath + ")", e);
				} finally {
					currentPlane = null;
				}
			}
		}

		fileScan.close();
		return airplanes;
	}
}
