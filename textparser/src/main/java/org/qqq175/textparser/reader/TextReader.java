package org.qqq175.textparser.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextReader {
	private static Logger logger = LogManager.getLogger(TextReader.class);

	public String readAll(String path) {
		StringBuilder text = new StringBuilder();
		File file = new File(path);

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNextLine()) {
				text.append(sc.nextLine()).append("\n");
			}
		} catch (FileNotFoundException e) {
			logger.log(Level.FATAL, "File isn't found", e);
			throw new RuntimeException();
		}
		return text.toString();
	}
}
