package org.qqq175.airline.creator;

import org.qqq175.airline.creator.implemented.AirlinerCreator;
import org.qqq175.airline.creator.implemented.CargoAircraftCreator;

public enum SupportedAirplane {
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

	PlaneCreator creator;

	public PlaneCreator getCreator() {
		return creator;
	}
}
