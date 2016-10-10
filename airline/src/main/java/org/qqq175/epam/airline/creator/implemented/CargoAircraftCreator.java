package org.qqq175.epam.airline.creator.implemented;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.epam.airline.airplane.CargoAircraft;
import org.qqq175.epam.airline.creator.AirplaneCreator;
import org.qqq175.epam.airline.exception.checked.InputDataCorruptedException;

public class CargoAircraftCreator extends AirplaneCreator {

	private static Logger logger = LogManager.getLogger(CargoAircraftCreator.class.getName());

	@Override
	public CargoAircraft create(List<String> params) throws InputDataCorruptedException {
		CargoAircraft cargoAircraft;
		if (params.size() == 6) {
			cargoAircraft = new CargoAircraft();
			try {
				setUpAirplaneFields(cargoAircraft, params);
				cargoAircraft.setCargoCapacity(Integer.parseInt(params.get(4)));
				cargoAircraft.setPayLoad(Integer.parseInt(params.get(5)));
			} catch (NumberFormatException e) {
				logger.log(Level.WARN, "Wrong number format");
				throw new InputDataCorruptedException();
			}
		} else {
			throw new InputDataCorruptedException();
		}
		return cargoAircraft;
	}

}
