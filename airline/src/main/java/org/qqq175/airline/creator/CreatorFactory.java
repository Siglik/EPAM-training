package org.qqq175.airline.creator;

import org.qqq175.airline.exception.InputDataCorruptedException;

public class CreatorFactory {

	public static PlaneCreator getCreator(String airplane) throws InputDataCorruptedException {
		PlaneCreator creator;
		try {
			SupportedAirplane airplaneType = SupportedAirplane.valueOf(airplane.toUpperCase());
			creator = airplaneType.getCreator();
		} catch (IllegalArgumentException e) {
			throw new InputDataCorruptedException(e);
		}
		return creator;
	}
}
