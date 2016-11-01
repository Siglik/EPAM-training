package org.qqq175.railway.util;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class Randomizer {
	private final Random random;
	private static Randomizer instance;
	private static AtomicBoolean isCreated = new AtomicBoolean(false);
	private static ReentrantLock lock = new ReentrantLock();

	private Randomizer() {
		this.random = new Random();
		random.setSeed(System.currentTimeMillis());
	}

	public static Randomizer getInstance() {

		if (!isCreated.get()) {
			lock.lock();
			if (instance == null) {
				instance = new Randomizer();
				isCreated.set(true);
			}
			lock.unlock();
		}

		return instance;
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.Random#nextInt(int)
	 */
	public int nextInt(int limit) {
		return random.nextInt(limit);
	}
}
