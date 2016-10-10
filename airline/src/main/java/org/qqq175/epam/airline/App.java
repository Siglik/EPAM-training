package org.qqq175.epam.airline;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.epam.airline.action.AirplaneAction;
import org.qqq175.epam.airline.airline.Airline;
import org.qqq175.epam.airline.airplane.Airplane;
import org.qqq175.epam.airline.parser.AirplaneParser;

/**
 * Hello world!
 *
 */
public class App {
	private static Logger logger = LogManager.getLogger(App.class.getName());
	private static final String DATAFILE_PATH = "data/airline.dat";

	public static void main(String[] args) {
		AirplaneAction arplaneAction = new AirplaneAction();
		AirplaneParser parser = new AirplaneParser();
		Airline airline = new Airline();

		airline.setAirplanes(parser.parse(DATAFILE_PATH));

		airline.getAirplanes().forEach(a -> logger.log(Level.INFO, a));

		logger.log(Level.INFO, "Calculating total capacity..\n");
		logger.log(Level.INFO, "Total seat capacity is " + arplaneAction.calcTotalSeatCapacity(airline.getAirplanes()));
		logger.log(Level.INFO, "Total cargo capacity is " + arplaneAction.calcTotalCargoCapacity(airline.getAirplanes()));
		logger.log(Level.INFO, "Total payload is " + arplaneAction.calcTotalPayLoad(airline.getAirplanes()) + "\n");

		logger.log(Level.INFO, "Sorting..\n");

		arplaneAction.sortByFlightRange(airline.getAirplanes());
		airline.getAirplanes().forEach(a -> logger.log(Level.INFO, a));

		logger.log(Level.INFO, "Searching airplanes with fuel consumption from 2000 to 10000..\n");

		List<Airplane> filtred = arplaneAction.filterByFueldComsumption(airline.getAirplanes(), 2000, 10000);
		filtred.forEach(a -> logger.log(Level.INFO, a));
	}
}
