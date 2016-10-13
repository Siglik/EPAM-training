package org.qqq175.airline.airplane.comparator;

import java.util.Comparator;

import org.qqq175.airline.airplane.Plane;

/**
 * airplane comparator by flight range range
 * 
 * @author qqq175
 *
 */
public class FlightRangeComparator implements Comparator<Plane> {

	@Override
	public int compare(Plane right, Plane left) {
		return right.getRangeOfFlight() - left.getRangeOfFlight();
	}
}
