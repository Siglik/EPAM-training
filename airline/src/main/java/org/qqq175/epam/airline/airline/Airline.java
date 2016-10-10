/**
 * 
 */
package org.qqq175.epam.airline.airline;

import java.util.List;

import org.qqq175.epam.airline.airplane.Airplane;

/**
 * @author qqq175
 *
 */
public class Airline {
	List<Airplane> airplanes;

	/**
	 * @return the airplanes
	 */
	public List<Airplane> getAirplanes() {
		return airplanes;
	}

	/**
	 * @param airplanes
	 *            the airplanes to set
	 */
	public void setAirplanes(List<Airplane> airplanes) {
		this.airplanes = airplanes;
	}

	public void addAirplane(Airplane airplane) {
		airplanes.add(airplane);
	}
}
