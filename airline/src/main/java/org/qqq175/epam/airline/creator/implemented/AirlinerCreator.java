/**
 * 
 */
package org.qqq175.epam.airline.creator.implemented;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.epam.airline.airplane.Airliner;
import org.qqq175.epam.airline.creator.AirplaneCreator;
import org.qqq175.epam.airline.exception.checked.InputDataCorruptedException;

/**
 * @author qqq175
 *
 */
public class AirlinerCreator extends AirplaneCreator {
	private static Logger logger = LogManager.getLogger(AirlinerCreator.class.getName());

	@Override
	public Airliner create(List<String> params) throws InputDataCorruptedException {
		Airliner airliner;
		if (params.size() == 5) {
			airliner = new Airliner();
			try {
				setUpAirplaneFields(airliner, params);
				airliner.setSeatCapacity(Integer.parseInt(params.get(4)));
			} catch (NumberFormatException e) {
				logger.log(Level.WARN, "Wrong number format");
				throw new InputDataCorruptedException();
			}
		} else {
			throw new InputDataCorruptedException();
		}
		return airliner;
	}

}
