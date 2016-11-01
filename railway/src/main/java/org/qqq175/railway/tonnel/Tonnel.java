package org.qqq175.railway.tonnel;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.railway.train.Train;
import org.qqq175.railway.util.Settings;

public class Tonnel implements Runnable {
	private static Logger logger = LogManager.getLogger(Tonnel.class);

	private Direction currentDirection;
	private String name;
	private Queue<Train> trainsQueue;
	private AtomicInteger switchDirectionCounter;
	private AtomicInteger trainsInsideNumber;
	private ReentrantLock lock;
	private ReentrantLock stateLock;
	private Semaphore semaphore;

	private State state;

	public enum State {
		EMPTY, NOTEMPTY, LIMIT, LIMITEMPTY
	}

	/**
	 * @param name
	 */
	public Tonnel(String name) {
		this.name = name;
		lock = new ReentrantLock();
		stateLock = new ReentrantLock();
		semaphore = new Semaphore(0);
		trainsInsideNumber = new AtomicInteger(0);
		switchDirectionCounter = new AtomicInteger(0);
		trainsQueue = new ArrayDeque<>();
		currentDirection = Direction.UP;
		state = State.EMPTY;
	}

	@Override
	public void run() {
		Train currentTrain;
		Train previousTrain = null;
		while (true) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				logger.log(Level.WARN, "Unexpected interupt!", e);
			}
			lock.lock();
			try {
				currentTrain = trainsQueue.remove();
			} finally {
				lock.unlock();
			}
			currentTrain.grantPass(this, previousTrain);
			previousTrain = currentTrain;
		}
	}

	public void admitTrain(Train train) {
		if (state != State.LIMIT && state != State.LIMITEMPTY) {
			switchDirectionCounter.incrementAndGet();
			trainsInsideNumber.incrementAndGet();
			updateState();
			lock.lock();
			try {
				trainsQueue.add(train);
			} finally {
				lock.unlock();
				semaphore.release();
			}
			if (!train.getDirection().equals(currentDirection)) {
				logger.log(Level.WARN, "Collision threat in the " + name + " tonel");
			}
		}
	}

	public void leave() {
		trainsInsideNumber.decrementAndGet();
		updateState();
	}

	public boolean switchDirection(Direction newDirection) {
		boolean isSwitched = true;
		lock.lock();
		try {
			if (trainsInsideNumber.get() != 0) {
				isSwitched = false;
			} else {
				logger.log(Level.INFO, "Tonnel " + name + " swithced from " + currentDirection + " to " + newDirection);
				setCurrentDirection(newDirection);
				switchDirectionCounter.set(0);
				updateState();
			}
		} finally {
			lock.unlock();
		}

		return isSwitched;
	}

	private void updateState() {
		stateLock.lock();
		int trains = trainsInsideNumber.get();
		int trainsTotal = switchDirectionCounter.get();
		State newState;
		if (trainsTotal < Settings.MAX_TRAINS_PER_DIRECTION) {
			if (trainsTotal > 0) {
				if (trains > 0) {
					newState = State.NOTEMPTY;
				} else {
					newState = State.EMPTY;
				}
			} else {
				newState = State.EMPTY;
			}
		} else {
			if (trains > 0) {
				newState = State.LIMIT;
			} else {
				newState = State.LIMITEMPTY;
			}
		}

		setState(newState);
		stateLock.unlock();
	}

	/**
	 * @return the currentDirection
	 */
	public Direction getCurrentDirection() {
		return currentDirection;
	}

	/**
	 * @param currentDirection
	 *            the currentDirection to set
	 */
	private void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the state
	 */
	public State getState() {
		stateLock.lock();
		try {
			return state;
		} finally {
			stateLock.unlock();
		}
	}

	/**
	 * @param state
	 *            the state to set
	 */
	private void setState(State state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tonnel other = (Tonnel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
