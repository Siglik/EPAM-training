/**
 * 
 */
package org.qqq175.airline.airline;

import java.util.ArrayList;
import java.util.List;

import org.qqq175.airline.airplane.Plane;

/**
 * @author qqq175
 *
 */
public class Airline {
	private String name;
	private List<Plane> airplanes;

	/**
	 * @param name
	 */
	public Airline(String name) {
		this.name = name;
		airplanes = new ArrayList<>();
	}

	/**
	 * @return the airplanes
	 */
	public List<Plane> getAirplanes() {
		return airplanes;
	}

	/**
	 * @param airplanes
	 *            the airplanes to set
	 */
	public void setAirplanes(List<Plane> airplanes) {
		this.airplanes = airplanes;
	}

	public void addAirplane(Plane airplane) {
		airplanes.add(airplane);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}