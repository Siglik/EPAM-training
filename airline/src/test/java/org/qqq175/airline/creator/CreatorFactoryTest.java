package org.qqq175.airline.creator;

import org.junit.Test;
import org.qqq175.airline.creator.CreatorFactory;
import org.qqq175.airline.exception.InputDataCorruptedException;

public class CreatorFactoryTest {

	@Test(expected = InputDataCorruptedException.class)
	public void getCreatorTestUnsupported() throws InputDataCorruptedException {
		CreatorFactory.getCreator("AIR");
	}

}
