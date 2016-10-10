package org.qqq175.epam.airline.creator;

import org.junit.Test;
import org.qqq175.epam.airline.exception.checked.InputDataCorruptedException;

public class CreatorFactoryTest {

	@Test(expected = InputDataCorruptedException.class)
	public void GetCreatorTestUnsupported() throws InputDataCorruptedException {
		CreatorFactory.getCreator("AIR");
	}

}
