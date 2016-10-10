package org.qqq175.epam.airline.creator;

import java.util.List;

import org.qqq175.epam.airline.airplane.Airplane;
import org.qqq175.epam.airline.exception.checked.InputDataCorruptedException;

public abstract class AirplaneCreator {

	public abstract Airplane create(List<String> params) throws InputDataCorruptedException;

	protected void setUpAirplaneFields(Airplane airplane, List<String> params) {
		airplane.setModelName(params.get(1));
		airplane.setFuelCompsumtion(Double.parseDouble(params.get(2)));
		airplane.setRangeOfFlight(Integer.parseInt(params.get(3)));
	}
}