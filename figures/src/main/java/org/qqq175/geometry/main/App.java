package org.qqq175.geometry.main;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.geometry.action.GeometryAction;
import org.qqq175.geometry.figure.Triangle;
import org.qqq175.geometry.parser.TriangleParser;

/**
 * Hello world!
 *
 */
public class App {

	static Logger logger = LogManager.getLogger(App.class.getName());
	private static final String DATAFILE_PATH = "data/triangles.dat";

	public static void main(String[] args) {

		TriangleParser parser = new TriangleParser();

		List<Triangle> triangles = parser.parse(DATAFILE_PATH);

		GeometryAction action = new GeometryAction();

		triangles.forEach(a -> logger.log(Level.INFO,
				a + " Perimeter is " + action.calcPerimeter(a) + ". Area is " + action.calcArea(a) + ". Is square? - " + action.isSquare(a)));
	}
}
