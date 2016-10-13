package org.qqq175.airline.creator.implemented;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.qqq175.airline.airplane.Airliner;
import org.qqq175.airline.airplane.Plane;
import org.qqq175.airline.creator.CreatorFactory;
import org.qqq175.airline.creator.PlaneCreator;
import org.qqq175.airline.exception.InputDataCorruptedException;

public class AirlineCreatorTest {
	private Airliner plane;
	private List<String> input;

	@Before
	public void setUp() throws Exception {
		input = new ArrayList<>();
		input.add("AIRLINER");
		input.add("Ан-140");
		input.add("560.0");
		input.add("2320");
		input.add("52");

		plane = new Airliner();
		plane.setModelName("Ан-140");
		plane.setFuelCompsumtion(560);
		plane.setRangeOfFlight(2320);
		plane.setSeatCapacity(52);
	}

	@After
	public void tearDown() throws Exception {
		plane = null;
		input = null;
	}

	@Test
	public void createTestGoodData() throws InputDataCorruptedException {
		PlaneCreator creator = CreatorFactory.getCreator(input.get(0));
		Plane createdPlane = creator.create(input);
		Assert.assertEquals(plane, createdPlane);
	}

	@Test(expected = InputDataCorruptedException.class)
	public void createTestWrongNumberFormat() throws InputDataCorruptedException {
		input.set(2, "560,0");
		PlaneCreator creator = CreatorFactory.getCreator(input.get(0));
		@SuppressWarnings("unused")
		Plane createdPlane = creator.create(input);
	}

	@Test(expected = InputDataCorruptedException.class)
	public void createTestIllegalArgumetsCount() throws InputDataCorruptedException {
		input.add("123");
		PlaneCreator creator = CreatorFactory.getCreator(input.get(0));
		@SuppressWarnings("unused")
		Plane createdPlane = creator.create(input);
	}

	@Test(expected = InputDataCorruptedException.class)
	public void createTestIllegalPlaneType() throws InputDataCorruptedException {
		input.set(0, "JustAPlane");
		PlaneCreator creator = CreatorFactory.getCreator(input.get(0));
		@SuppressWarnings("unused")
		Plane createdPlane = creator.create(input);
	}
}