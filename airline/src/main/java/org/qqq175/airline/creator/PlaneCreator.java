package org.qqq175.airline.creator;

import java.util.List;

import org.qqq175.airline.airplane.Plane;
import org.qqq175.airline.exception.InputDataCorruptedException;

public abstract class PlaneCreator {

	public abstract Plane create(List<String> params) throws InputDataCorruptedException;

	protected void setUpAirplaneFields(Plane airplane, List<String> params) {
		airplane.setModelName(params.get(1));
		airplane.setFuelCompsumtion(Double.parseDouble(params.get(2)));
		airplane.setRangeOfFlight(Integer.parseInt(params.get(3)));
	}
}