package org.qqq175.epam.airline;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.qqq175.epam.airline.airplane.comparator.FlightRangeComparatorTest;
import org.qqq175.epam.airline.creator.CreatorFactoryParameterizedTest;
import org.qqq175.epam.airline.creator.CreatorFactoryTest;
import org.qqq175.epam.airline.parser.AirlineParserTest;

@RunWith(Suite.class)
@SuiteClasses({ FlightRangeComparatorTest.class, CreatorFactoryTest.class, CreatorFactoryParameterizedTest.class, AirlineParserTest.class })
public class AllTests {

}
