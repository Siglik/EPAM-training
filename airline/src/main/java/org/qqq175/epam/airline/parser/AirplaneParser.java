package org.qqq175.epam.airline.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.epam.airline.airplane.Airplane;
import org.qqq175.epam.airline.creator.AirplaneCreator;
import org.qqq175.epam.airline.creator.CreatorFactory;
import org.qqq175.epam.airline.exception.checked.InputDataCorruptedException;
import org.qqq175.epam.airline.exception.unchecked.InputFileIsMissingException;

public class AirplaneParser {

	private static Logger logger = LogManager.getLogger(AirplaneParser.class.getName());
	private static final String DELIMETER = "\\s*,\\s*";

	private Scanner initScanner(String filePath) {
		Scanner scan;
		try {
			File file = new File(filePath);
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			logger.log(Level.ERROR, "File \'" + filePath + "\' isn't exist.", e);
			throw new InputFileIsMissingException();
		}
		return scan;
	}

	public List<Airplane> parse(String filePath) {
		List<Airplane> airplanes = new ArrayList<>();
		Scanner fileScan = initScanner(filePath);
		int currentLine = 0;

		while (fileScan.hasNext()) {
			currentLine++;
			List<String> current = Arrays.asList(fileScan.nextLine().split(DELIMETER));

			if (current.size() > 0) {
				AirplaneCreator creator;
				try {
					creator = CreatorFactory.getCreator(current.get(0));
					Airplane currentPlane = creator.create(current);
					airplanes.add(currentPlane);
					currentPlane = null;
				} catch (InputDataCorruptedException e) {
					logger.log(Level.WARN, "Illegal data at line " + currentLine + " (" + filePath + ")", e);
				}
			} else {
				logger.log(Level.WARN, "Illegal data at line " + currentLine + " (" + filePath + ")");
			}
		}

		fileScan.close();
		return airplanes;
	}
}
