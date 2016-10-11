/**
 * 
 */
package org.qqq175.geometry.figure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qqq175
 *
 */
public class Triangle implements Polygon {
	Point a;
	Point b;
	Point c;

	public Triangle() {
	}

	/**
	 * @param a
	 * @param b
	 * @param c
	 */
	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * @return the A angle point
	 */
	public Point getA() {
		return a;
	}

	/**
	 * @param a
	 *            the A angle point to set
	 */
	public void setA(Point a) {
		this.a = a;
	}

	/**
	 * @return the B angle point
	 */
	public Point getB() {
		return b;
	}

	/**
	 * @param b
	 *            the B angle point to set
	 */
	public void setB(Point b) {
		this.b = b;
	}

	/**
	 * @return the C angle point
	 */
	public Point getC() {
		return c;
	}

	/**
	 * @param c
	 *            the C angle point to set
	 */
	public void setC(Point c) {
		this.c = c;
	}

	@Override
	public List<Point> getCorners() {
		List<Point> points = new ArrayList<>();
		points.add(a);
		points.add(b);
		points.add(c);

		return points;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Triangle [a=").append(a).append(", b=").append(b).append(", c=").append(c).append("]");
		return builder.toString();
	}

}
