package org.qqq175.epam.airline.creator;

import org.qqq175.epam.airline.creator.implemented.AirlinerCreator;
import org.qqq175.epam.airline.creator.implemented.CargoAircraftCreator;

public enum SupportedAirplanes {
	AIRLINER {
		{
			this.creator = new AirlinerCreator();
		}
	},
	CARGO_AIRCRAFT {
		{
			this.creator = new CargoAircraftCreator();
		}
	};

	AirplaneCreator creator;

	public AirplaneCreator getCreator() {
		return creator;
	}
}
