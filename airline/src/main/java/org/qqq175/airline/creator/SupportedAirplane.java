package org.qqq175.airline.creator;

public enum SupportedAirplane {
	AIRLINER(new AirlinerCreator()), CARGO_AIRCRAFT(new CargoAircraftCreator());

	/**
	 * @param creator
	 */
	private SupportedAirplane(PlaneCreator creator) {
		this.creator = creator;
	}

	private PlaneCreator creator;

	public PlaneCreator getCreator() {
		return creator;
	}
}
