package org.qqq175.geometry.creator;

import java.util.ArrayList;

import org.junit.Test;
import org.qqq175.geometry.exception.NotATriangleException;

public class TriangleCreatorTest {

	@Test(expected = NotATriangleException.class)
	public void createTestNotATriangleException() throws NotATriangleException {
		new TriangleCreator().create(new ArrayList<Double>() {
			{
				this.add(1.0);
				this.add(2.0);
				this.add(3.0);
				this.add(4.0);
				this.add(5.0);
				this.add(6.0);
			}
		});
	}

}
