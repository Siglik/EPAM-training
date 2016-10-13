package org.qqq175.airline.main;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.airline.action.AirlineAction;
import org.qqq175.airline.airline.Airline;
import org.qqq175.airline.airplane.Plane;
import org.qqq175.airline.parser.AirplaneParser;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger logger = LogManager.getLogger(App.class.getName());
	private static final String DATAFILE_PATH = "data/airline.dat";

	public static void main(String[] args) {
		AirlineAction arplaneAction = new AirlineAction();
		AirplaneParser parser = new AirplaneParser();
		Airline airline = new Airline("Mihalkov's airline");

		airline.setAirplanes(parser.parse(DATAFILE_PATH));

		airline.getAirplanes().forEach(a -> logger.log(Level.INFO, a));

		logger.log(Level.INFO, "Calculating total capacity..\n");
		logger.log(Level.INFO, "Total seat capacity is " + arplaneAction.calcTotalSeatCapacity(airline));
		logger.log(Level.INFO, "Total cargo capacity is " + arplaneAction.calcTotalCargoCapacity(airline));
		logger.log(Level.INFO, "Total payload is " + arplaneAction.calcTotalPayLoad(airline) + "\n");

		logger.log(Level.INFO, "Sorting..\n");

		arplaneAction.sortByFlightRange(airline);
		airline.getAirplanes().forEach(a -> logger.log(Level.INFO, a));

		logger.log(Level.INFO, "Searching airplanes with fuel consumption from 2000 to 10000..\n");

		List<Plane> filtred = arplaneAction.filterByFueldComsumption(airline, 2000, 10000);
		filtred.forEach(a -> logger.log(Level.INFO, a));
	}
}
