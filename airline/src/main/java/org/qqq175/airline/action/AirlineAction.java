package org.qqq175.airline.action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.qqq175.airline.airline.Airline;
import org.qqq175.airline.airplane.Airliner;
import org.qqq175.airline.airplane.CargoAircraft;
import org.qqq175.airline.airplane.Plane;
import org.qqq175.airline.airplane.comparator.FlightRangeComparator;

public class AirlineAction {

	/**
	 * Sort list using comparator and return sorted list
	 * 
	 * @param airplanes
	 * @param comparator
	 * @return
	 */
	public void sortByFlightRange(Airline airline) {
		Comparator<Plane> comparator = new FlightRangeComparator();
		airline.getAirplanes().sort(comparator);

	}

	/**
	 * Filter airplanes list by fuel consumption level (from min to max)
	 * 
	 * @param airplanes
	 * @param min
	 *            - min fuel consumption level
	 * @param max
	 *            - max fuel consumption level
	 * @return filtred list
	 */
	public List<Plane> filterByFueldComsumption(Airline airline, double min, double max) {
		List<Plane> filtred = airline.getAirplanes().stream().filter(a -> a.getFuelCompsumtion() >= min && a.getFuelCompsumtion() <= max)
				.collect(Collectors.toCollection(ArrayList::new));
		return filtred;
	}

	public int calcTotalSeatCapacity(Airline airline) {
		int total = 0;
		for (Plane airplane : airline.getAirplanes()) {
			if (airplane.getClass() == Airliner.class) {
				total += ((Airliner) airplane).getSeatCapacity();
			}
		}

		return total;
	}

	public int calcTotalCargoCapacity(Airline airline) {
		int total = 0;
		for (Plane airplane : airline.getAirplanes()) {
			if (airplane.getClass() == CargoAircraft.class) {
				total += ((CargoAircraft) airplane).getCargoCapacity();
			}
		}

		return total;
	}

	public int calcTotalPayLoad(Airline airline) {
		int total = 0;
		for (Plane airplane : airline.getAirplanes()) {
			if (airplane.getClass() == CargoAircraft.class) {
				total += ((CargoAircraft) airplane).getPayLoad();
			}
		}

		return total;
	}
}