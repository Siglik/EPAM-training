/**
 * 
 */
package org.qqq175.geometry.creator;

import java.util.List;

import org.qqq175.geometry.action.GeometryAction;
import org.qqq175.geometry.exception.NotATriangleException;
import org.qqq175.geometry.figure.Point;
import org.qqq175.geometry.figure.Triangle;

/**
 * @author qqq175
 *
 */
public class TriangleCreator {

	public Triangle create(List<Double> coordinates) throws NotATriangleException {
		Triangle triangle = new Triangle();

		triangle.setA(new Point(coordinates.get(0), (coordinates.get(1))));
		triangle.setB(new Point(coordinates.get(2), (coordinates.get(3))));
		triangle.setC(new Point(coordinates.get(4), (coordinates.get(5))));

		GeometryAction action = new GeometryAction();
		if (!action.isTriangle(triangle)) {
			throw new NotATriangleException("Points belong to the same line. - " + triangle);
		}

		return triangle;
	}
}