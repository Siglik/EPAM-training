package org.qqq175.epam.airline.airplane.comparator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.qqq175.epam.airline.airplane.Airliner;
import org.qqq175.epam.airline.airplane.Airplane;
import org.qqq175.epam.airline.airplane.CargoAircraft;

public class FlightRangeComparatorTest {
	FlightRangeComparator comparator;

	@Before
	public void setUp() throws Exception {
		comparator = new FlightRangeComparator();
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
	}

	@Test
	public void compareTestRightOrder() {
		Airplane lesserAirliner = new Airliner("model", 0, 100, 0);
		Airplane biggerCargo = new CargoAircraft("model", 0, 500, 0, 0);
		Assert.assertTrue(comparator.compare(lesserAirliner, biggerCargo) < 0);
	}

	@Test
	public void compareTestWrongOrder() {
		Airplane lesserCargo = new CargoAircraft("model", 0, 0, 0, 0);
		Airplane biggerCargo = new CargoAircraft("model", 0, 500, 0, 0);
		Assert.assertTrue(comparator.compare(biggerCargo, lesserCargo) > 0);
	}

	@Test
	public void compareTestEquals() {
		Airplane lesserCargo = new CargoAircraft("model", 0, 100, 0, 0);
		Airplane lesserAirliner = new Airliner("model", 0, 100, 0);
		Assert.assertEquals(comparator.compare(lesserAirliner, lesserCargo), 0);
	}

}
