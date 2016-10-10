package org.qqq175.epam.airline.creator;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.qqq175.epam.airline.creator.implemented.AirlinerCreator;
import org.qqq175.epam.airline.creator.implemented.CargoAircraftCreator;
import org.qqq175.epam.airline.exception.checked.InputDataCorruptedException;

@RunWith(value = Parameterized.class)
public class CreatorFactoryParameterizedTest {

	private String airplaneType;

	private Class<?> creatorClass;

	public CreatorFactoryParameterizedTest(String airplaneType, Class<?> creatorClass) {
		this.airplaneType = airplaneType;
		this.creatorClass = creatorClass;
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { "AIRLINER", AirlinerCreator.class }, { "airliner", AirlinerCreator.class },
				{ "AirLineR", AirlinerCreator.class }, { "Cargo_aircraft", CargoAircraftCreator.class },
				{ "CARGO_AIRCRAFT", CargoAircraftCreator.class }, { "cargo_aircraft", CargoAircraftCreator.class } };

		return Arrays.asList(data);
	}

	@Test
	public void GetCreatorTest() throws InputDataCorruptedException {
		Assert.assertThat(CreatorFactory.getCreator(airplaneType), CoreMatchers.instanceOf(creatorClass));
	}
}
