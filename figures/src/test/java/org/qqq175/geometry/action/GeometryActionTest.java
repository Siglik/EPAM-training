package org.qqq175.geometry.action;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.qqq175.geometry.figure.Point;
import org.qqq175.geometry.figure.Triangle;

@RunWith(value = Parameterized.class)
public class GeometryActionTest {

	private Triangle triangle;

	private double perimeter;

	private double area;

	private boolean isTriangle;

	private boolean isSquare;

	private GeometryAction action;

	/**
	 * @param triangle
	 * @param perimeter
	 * @param area
	 * @param isSquare
	 */
	public GeometryActionTest(Triangle triangle, double perimeter, double area, boolean isTriangle, boolean isSquare) {
		this.triangle = triangle;
		this.perimeter = perimeter;
		this.area = area;
		this.isTriangle = isTriangle;
		this.isSquare = isSquare;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { new Triangle(new Point(1, 2), new Point(2, 3), new Point(3, 1)), 5.886, 1.5, true, false },
				{ new Triangle(new Point(.5, 5), new Point(.5, 3), new Point(3, 5)), 7.702, 2.5, true, true },
				{ new Triangle(new Point(1, 2), new Point(2, 3), new Point(3, 4)), 5.657, 0, false, false },
				{ new Triangle(new Point(7, 1), new Point(3, 5), new Point(0, -1)), 19.645, 18, true, false } };

		return Arrays.asList(data);
	}

	@Before
	public void setUp() throws Exception {
		action = new GeometryAction();
	}

	@After
	public void tearDown() throws Exception {
		action = null;
	}

	@Test
	public void calcPerimeterTest() {
		Assert.assertEquals(action.calcPerimeter(triangle), perimeter, 0.003);
	}

	@Test
	public void calcAreaTest() {
		Assert.assertEquals(action.calcArea(triangle), area, 0.003);
	}

	@Test
	public void isTriangleTest() {
		Assert.assertEquals(action.isTriangle(triangle), isTriangle);
	}

	@Test
	public void isSquareTest() {
		Assert.assertEquals(action.isSquare(triangle), isSquare);
	}

}
