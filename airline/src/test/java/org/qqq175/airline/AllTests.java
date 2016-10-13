package org.qqq175.airline;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.qqq175.airline.action.AirlineActionTest;
import org.qqq175.airline.creator.AirlineCreatorTest;
import org.qqq175.airline.creator.CargoAircraftCreatorTest;
import org.qqq175.airline.creator.CreatorFactoryParameterizedTest;
import org.qqq175.airline.creator.CreatorFactoryTest;
import org.qqq175.airline.parser.AirlineParserTest;

@RunWith(Suite.class)
@SuiteClasses({ CreatorFactoryTest.class, CreatorFactoryParameterizedTest.class, AirlineParserTest.class, AirlineCreatorTest.class,
		CargoAircraftCreatorTest.class, AirlineActionTest.class })
public class AllTests {

}
