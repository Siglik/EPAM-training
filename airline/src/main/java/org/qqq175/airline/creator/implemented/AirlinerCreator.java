/**
 * 
 */
package org.qqq175.airline.creator.implemented;

import java.util.List;

import org.qqq175.airline.airplane.Airliner;
import org.qqq175.airline.creator.PlaneCreator;
import org.qqq175.airline.exception.InputDataCorruptedException;

/**
 * @author qqq175
 *
 */
public class AirlinerCreator extends PlaneCreator {
	private static final String PLANE_TYPE = "AIRLINER";

	@Override
	public Airliner create(List<String> params) throws InputDataCorruptedException {
		Airliner airliner;
		if (params.size() == 5) {
			if (params.get(0).equalsIgnoreCase(PLANE_TYPE)) {
				airliner = new Airliner();
				try {
					setUpAirplaneFields(airliner, params);
					airliner.setSeatCapacity(Integer.parseInt(params.get(4)));
				} catch (NumberFormatException e) {
					throw new InputDataCorruptedException("Wrong number format", e);
				}
			} else {
				throw new InputDataCorruptedException("Wrong input data: plane type expected - " + PLANE_TYPE + ", actual - " + params.get(0));
			}
		} else {
			throw new InputDataCorruptedException("Wrong arguments count: expected - " + 5 + " actual - " + params.size());
		}
		return airliner;
	}

}
