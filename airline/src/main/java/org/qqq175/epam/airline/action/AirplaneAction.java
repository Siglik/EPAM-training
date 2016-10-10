package org.qqq175.epam.airline.action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.qqq175.epam.airline.airplane.Airliner;
import org.qqq175.epam.airline.airplane.Airplane;
import org.qqq175.epam.airline.airplane.CargoAircraft;
import org.qqq175.epam.airline.airplane.comparator.FlightRangeComparator;

public class AirplaneAction {

	/**
	 * Sort list using comparator and return sorted list
	 * 
	 * @param airplanes
	 * @param comparator
	 * @return
	 */
	public void sortByFlightRange(List<Airplane> airplanes) {
		Comparator<Airplane> comparator = new FlightRangeComparator();
		airplanes.sort(comparator);

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
	public List<Airplane> filterByFueldComsumption(List<Airplane> airplanes, double min, double max) {
		List<Airplane> filtred = airplanes.stream().filter(a -> a.getFuelCompsumtion() >= min && a.getFuelCompsumtion() <= max)
				.collect(Collectors.toCollection(ArrayList::new));
		return filtred;
	}

	public int calcTotalSeatCapacity(List<Airplane> airplanes) {
		int total = 0;
		for (Airplane airplane : airplanes) {
			if (airplane.getClass() == Airliner.class) {
				total += ((Airliner) airplane).getSeatCapacity();
			}
		}

		return total;
	}

	public int calcTotalCargoCapacity(List<Airplane> airplanes) {
		int total = 0;
		for (Airplane airplane : airplanes) {
			if (airplane.getClass() == CargoAircraft.class) {
				total += ((CargoAircraft) airplane).getCargoCapacity();
			}
		}

		return total;
	}

	public int calcTotalPayLoad(List<Airplane> airplanes) {
		int total = 0;
		for (Airplane airplane : airplanes) {
			if (airplane.getClass() == CargoAircraft.class) {
				total += ((CargoAircraft) airplane).getPayLoad();
			}
		}

		return total;
	}
}
