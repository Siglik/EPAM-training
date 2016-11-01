package org.qqq175.railway.tonnel;

public enum Direction {
	UP, DOWN;

	public Direction getOpposite() {
		if (this == UP) {
			return DOWN;
		} else {
			return UP;
		}
	}
}
