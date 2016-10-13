package org.qqq175.airline.creator;

import java.util.List;

import org.qqq175.airline.airplane.CargoAircraft;
import org.qqq175.airline.exception.InputDataCorruptedException;

public class CargoAircraftCreator extends PlaneCreator {
	private static final String PLANE_TYPE = "CARGO_AIRCRAFT";

	@Override
	public CargoAircraft create(List<String> params) throws InputDataCorruptedException {
		CargoAircraft cargoAircraft;
		if (params.size() == 6) {
			if (params.get(0).equalsIgnoreCase(PLANE_TYPE)) {
				cargoAircraft = new CargoAircraft();
				try {
					setUpAirplaneFields(cargoAircraft, params);
					cargoAircraft.setCargoCapacity(Integer.parseInt(params.get(4)));
					cargoAircraft.setPayLoad(Integer.parseInt(params.get(5)));
				} catch (NumberFormatException e) {
					throw new InputDataCorruptedException("Wrong number format", e);
				}
			} else {
				throw new InputDataCorruptedException("Wrong input data: plane type expected - " + PLANE_TYPE + ", actual - " + params.get(0));
			}
		} else {
			throw new InputDataCorruptedException("Wrong arguments count: expected - " + 6 + " actual - " + params.size());
		}
		return cargoAircraft;
	}

}
