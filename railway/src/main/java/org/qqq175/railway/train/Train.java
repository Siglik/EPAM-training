package org.qqq175.railway.train;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.railway.dispatcher.RailwayDispatcher;
import org.qqq175.railway.tonnel.Direction;
import org.qqq175.railway.tonnel.Tonnel;
import org.qqq175.railway.util.Settings;

public class Train extends Thread {
	private static Logger logger = LogManager.getLogger(Train.class);

	private Direction direction;
	private int number;
	private Semaphore semaphore;
	Tonnel tonnel;

	private Train previousInTonnel;

	/**
	 * @param direction
	 * @param number
	 */
	public Train(Direction direction, int number) {
		this.direction = direction;
		this.number = number;
		this.semaphore = new Semaphore(0);
	}

	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	@Override
	public void run() {
		askPassAndWait();
		try {
			TimeUnit.MILLISECONDS.sleep(Settings.TONNEL_TRANSIT_TIME_MILLIS);
		} catch (InterruptedException e) {
			logger.log(Level.WARN, "Unexpected interupt!", e);
		}
		try {
			if (previousInTonnel != null) {
				previousInTonnel.join();
			}
		} catch (InterruptedException e) {
			logger.log(Level.WARN, "Unexpected interupt!", e);
		}
		tonnel.leave();
		logger.log(Level.INFO, "TRAIN " + getNumber() + " (" + getDirection() + ") leaved <<<<<<<<<<<<< tonnel " + tonnel.getName() + " ("
				+ tonnel.getCurrentDirection() + ")");
	}

	private void askPassAndWait() {
		RailwayDispatcher.getInstance().askPass(this);
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			logger.log(Level.WARN, "Unexpected interupt!", e);
		}
	}

	public void grantPass(Tonnel tonnel, Train previous) {
		this.tonnel = tonnel;
		this.previousInTonnel = previous;
		logger.log(Level.INFO, "TRAIN " + getNumber() + " (" + getDirection() + ") entered >>>>>>>>>>>>> tonnel " + tonnel.getName() + " ("
				+ tonnel.getCurrentDirection() + ")");
		semaphore.release();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Train [direction=").append(direction).append(", number=").append(number).append("]");
		return builder.toString();
	}
}