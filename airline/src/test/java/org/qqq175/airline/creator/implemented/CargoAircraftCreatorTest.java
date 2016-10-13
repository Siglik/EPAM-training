package org.qqq175.airline.creator.implemented;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.qqq175.airline.airplane.CargoAircraft;
import org.qqq175.airline.airplane.Plane;
import org.qqq175.airline.creator.CreatorFactory;
import org.qqq175.airline.creator.PlaneCreator;
import org.qqq175.airline.exception.InputDataCorruptedException;

public class CargoAircraftCreatorTest {
	private CargoAircraft plane;
	private List<String> input;

	@Before
	public void setUp() throws Exception {
		input = new ArrayList<>();
		input.add("CARGO_AIRCRAFT");
		input.add("cargo_plane");
		input.add("1000");
		input.add("5000");
		input.add("500");
		input.add("50");

		plane = new CargoAircraft();
		plane.setModelName("cargo_plane");
		plane.setFuelCompsumtion(1000);
		plane.setRangeOfFlight(5000);
		plane.setCargoCapacity(500);
		plane.setPayLoad(50);
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
		input.set(2, "maksim");
		PlaneCreator creator = CreatorFactory.getCreator(input.get(0));
		@SuppressWarnings("unused")
		Plane createdPlane = creator.create(input);
	}

	@Test(expected = InputDataCorruptedException.class)
	public void createTestIllegalArgumetsCount() throws InputDataCorruptedException {
		input.remove(5);
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
