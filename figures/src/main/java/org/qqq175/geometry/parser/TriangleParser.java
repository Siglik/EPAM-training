/**
 * 
 */
package org.qqq175.geometry.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.geometry.creator.TriangleCreator;
import org.qqq175.geometry.exception.InputDataCorruptedException;
import org.qqq175.geometry.exception.NotATriangleException;
import org.qqq175.geometry.figure.Triangle;

/**
 * @author qqq175
 *
 */
public class TriangleParser {

	private static Logger logger = LogManager.getLogger(TriangleParser.class.getName());

	private Scanner initScanner(String filePath) {
		Scanner fileScanner = null;

		try {
			File file = new File(filePath);
			fileScanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			logger.log(Level.FATAL, "File " + filePath + " isn't exist.", e);
			throw new RuntimeException();
		}
		return fileScanner;
	}

	public List<Triangle> parse(String filePath) {
		List<Triangle> triangles = new ArrayList<>();
		Scanner fileScanner = initScanner(filePath);
		TriangleCreator creator = new TriangleCreator();

		int lineNumber = 0;

		while (fileScanner.hasNext()) {
			lineNumber++;
			String currentLine = fileScanner.nextLine();

			try {
				List<Double> coordinates = parseString(currentLine);

				if (coordinates.size() == 6) {
					triangles.add(creator.create(coordinates));
				} else {
					logger.log(Level.ERROR,
							"Wrong coordinates count at line " + lineNumber + " (" + filePath + ") - 6 is expected, actual is " + coordinates.size());
				}
			} catch (InputDataCorruptedException e) {
				logger.log(Level.ERROR, "Unable to parse line " + lineNumber + " (" + filePath + ")", e);
			} catch (NotATriangleException e) {
				logger.log(Level.ERROR, e.getMessage(), e);
			}
		}

		fileScanner.close();
		return triangles;
	}

	private List<Double> parseString(String doubles) throws InputDataCorruptedException {
		List<Double> coordinates = new ArrayList<>();
		try (Scanner stringScanner = new Scanner(doubles)) {
			while (stringScanner.hasNext()) {
				if (stringScanner.hasNextDouble()) {
					coordinates.add(stringScanner.nextDouble());
				} else {
					throw new InputDataCorruptedException("Unable to parse - wrong double format!");
				}
			}
		}

		return coordinates;
	}
}
