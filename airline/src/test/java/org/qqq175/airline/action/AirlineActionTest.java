package org.qqq175.airline.action;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.qqq175.airline.airline.Airline;
import org.qqq175.airline.airplane.Airliner;
import org.qqq175.airline.airplane.CargoAircraft;
import org.qqq175.airline.airplane.Plane;

public class AirlineActionTest {
	private Airline airline;
	private CargoAircraft tinyPlane;
	private Airliner smallPlane;
	private CargoAircraft mediumPlane;
	private Airliner bigPlane;
	private AirlineAction action;

	@Before
	public void setUp() throws Exception {
		airline = new Airline("Mihalkov's airline");
		action = new AirlineAction();

		tinyPlane = new CargoAircraft();
		tinyPlane.setModelName("tiny_plane");
		tinyPlane.setFuelCompsumtion(300);
		tinyPlane.setRangeOfFlight(2000);
		tinyPlane.setCargoCapacity(300);
		tinyPlane.setPayLoad(30);

		smallPlane = new Airliner();
		smallPlane.setModelName("small_plane");
		smallPlane.setFuelCompsumtion(500);
		smallPlane.setRangeOfFlight(2500);
		smallPlane.setSeatCapacity(50);

		mediumPlane = new CargoAircraft();
		mediumPlane.setModelName("medium_plane");
		mediumPlane.setFuelCompsumtion(900);
		mediumPlane.setRangeOfFlight(8000);
		mediumPlane.setCargoCapacity(800);
		mediumPlane.setPayLoad(100);

		bigPlane = new Airliner();
		bigPlane.setModelName("big_plane");
		bigPlane.setFuelCompsumtion(1500);
		bigPlane.setRangeOfFlight(12500);
		bigPlane.setSeatCapacity(250);

		airline.addAirplane(smallPlane);
		airline.addAirplane(mediumPlane);
		airline.addAirplane(bigPlane);
		airline.addAirplane(tinyPlane);
	}

	@After
	public void tearDown() throws Exception {
		airline = null;
		tinyPlane = null;
		smallPlane = null;
		mediumPlane = null;
		bigPlane = null;
		action = null;
	}

	@Test
	public void calcTotalPayLoadTest() {
		int expected = tinyPlane.getPayLoad() + mediumPlane.getPayLoad();
		Assert.assertEquals(expected, action.calcTotalPayLoad(airline));
	}

	@Test
	public void calcTotalSeatCapacityTest() {
		int expected = smallPlane.getSeatCapacity() + bigPlane.getSeatCapacity();
		Assert.assertEquals(expected, action.calcTotalSeatCapacity(airline));
	}

	@Test
	public void calcTotalCargoCapacityTest() {
		int expected = tinyPlane.getCargoCapacity() + mediumPlane.getCargoCapacity();
		Assert.assertEquals(expected, action.calcTotalCargoCapacity(airline));
	}

	@Test
	public void filterByFueldComsumptionTest() {
		List<Plane> filtred = action.filterByFueldComsumption(airline, smallPlane.getFuelCompsumtion(), mediumPlane.getFuelCompsumtion());
		Assert.assertEquals(2, filtred.size());
		Assert.assertSame(smallPlane, filtred.get(0));
		Assert.assertSame(mediumPlane, filtred.get(1));
	}

}
