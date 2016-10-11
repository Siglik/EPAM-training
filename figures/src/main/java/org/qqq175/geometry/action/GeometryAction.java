/**
 * 
 */
package org.qqq175.geometry.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.qqq175.geometry.figure.Point;
import org.qqq175.geometry.figure.Polygon;
import org.qqq175.geometry.figure.Triangle;

/**
 * @author qqq175
 *
 */
public class GeometryAction {

	/**
	 * Calculates non-self-intersecting polygon area (work for convex and
	 * non-convex polygons)
	 * 
	 * @param polygon
	 * @return area of polygon
	 */
	public double calcArea(Polygon polygon) {
		double doubleArea = 0;
		List<Point> corners = polygon.getCorners();
		int cornersCount = corners.size();

		for (int i = 0; i < cornersCount; i++) {
			int next = (i + 1) % cornersCount;
			doubleArea += corners.get(i).getX() * corners.get(next).getY() - corners.get(next).getX() * corners.get(i).getY();
		}

		return Math.abs(doubleArea / 2.0);
	}

	/**
	 * Calculates a polygon perimeter
	 * 
	 * @param polygon
	 * @return perimeter of polygon
	 */
	public double calcPerimeter(Polygon polygon) {
		List<Double> sides = calcSidesLength(polygon);

		return sides.stream().reduce(0.0, (a, b) -> a + b);
	}

	/**
	 * Check if three points are triangle
	 * 
	 * @param triangle
	 * @return true points are triangle, else - false
	 */
	public boolean isTriangle(Triangle triangle) {
		return calcArea(triangle) > 0;
	}

	/**
	 * Check if triangle is square
	 * 
	 * @param triangle
	 * @return true if triangle is square, else - false
	 */
	public boolean isSquare(Triangle triangle) {
		List<Double> sides = calcSidesLength(triangle);
		double sumOfSidesSquares = sides.stream().reduce(0.0, (a, b) -> a + b * b);
		double maxSide = Collections.max(sides);
		/*
		 * because the double isn't accurate use less operator with the accuracy
		 * correction value instead equals operator
		 */
		return Math.abs(maxSide * maxSide * 2 - sumOfSidesSquares) < 0x1p-40;
	}

	/**
	 * calc polygon sides lengths
	 * 
	 * @param polygon
	 * @return
	 */
	private List<Double> calcSidesLength(Polygon polygon) {
		List<Point> corners = polygon.getCorners();

		List<Double> sides = new ArrayList<>(corners.size());

		for (int i = 0; i < corners.size(); i++) {
			int next = (i + 1) % corners.size();
			sides.add(calcLineSegmentLength(corners.get(i), corners.get(next)));
		}

		return sides;
	}

	/**
	 * calculates line segment length (distance between 2 points - top and end)
	 * 
	 * @param top
	 * @param end
	 * @return
	 */
	private double calcLineSegmentLength(Point top, Point end) {
		double xLength = Math.abs(top.getX() - end.getX());
		double yLength = Math.abs(top.getY() - end.getY());
		return Math.sqrt(xLength * xLength + yLength * yLength);
	}
}
