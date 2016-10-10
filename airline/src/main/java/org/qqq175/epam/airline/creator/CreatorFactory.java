package org.qqq175.epam.airline.creator;

import org.qqq175.epam.airline.exception.checked.InputDataCorruptedException;

public class CreatorFactory {

	public static AirplaneCreator getCreator(String airplane) throws InputDataCorruptedException {
		AirplaneCreator creator;
		try {
			SupportedAirplanes airplaneType = SupportedAirplanes.valueOf(airplane.toUpperCase());
			creator = airplaneType.getCreator();
		} catch (IllegalArgumentException e) {
			throw new InputDataCorruptedException();
		}
		return creator;
	}
}
