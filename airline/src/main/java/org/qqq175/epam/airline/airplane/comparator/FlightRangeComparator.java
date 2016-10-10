package org.qqq175.epam.airline.airplane.comparator;

import java.util.Comparator;

import org.qqq175.epam.airline.airplane.Airplane;

/**
 * airplane comparator by flight range range
 * 
 * @author qqq175
 *
 */
public class FlightRangeComparator implements Comparator<Airplane> {

	@Override
	public int compare(Airplane right, Airplane left) {
		if (right.getRangeOfFlight() > left.getRangeOfFlight()) {
			return 1;
		} else if (right.getRangeOfFlight() < left.getRangeOfFlight()) {
			return -1;
		}
		return 0;
	}
}
