package org.qqq175.railway.dispatcher;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.railway.exception.IllegalTonnelNameException;
import org.qqq175.railway.main.App;
import org.qqq175.railway.tonnel.Direction;
import org.qqq175.railway.tonnel.Tonnel;
import org.qqq175.railway.train.Train;

public class RailwayDispatcher implements Runnable {

	private static Logger logger = LogManager.getLogger(App.class);

	private static RailwayDispatcher instance;
	private static AtomicBoolean isCreated = new AtomicBoolean(false);

	private static ReentrantLock lock = new ReentrantLock(true);

	private Map<Direction, Queue<Train>> queues;
	private Set<Tonnel> tonnels;

	private Semaphore semaphore;

	private AtomicBoolean isStopped;
	private AtomicBoolean isStarted;

	private RailwayDispatcher() {
		tonnels = new HashSet<>();
		queues = new HashMap<>();
		queues.put(Direction.UP, new ArrayDeque<Train>());
		queues.put(Direction.DOWN, new ArrayDeque<Train>());
		semaphore = new Semaphore(0);
		isStopped = new AtomicBoolean(false);
		isStarted = new AtomicBoolean(false);
	}

	public static RailwayDispatcher getInstance() {

		if (!isCreated.get()) {
			lock.lock();
			try {
				if (instance == null) {
					instance = new RailwayDispatcher();
					isCreated.set(true);
				}
			} finally {
				lock.unlock();
			}
		}

		return instance;
	}

	public void start() {
		if (!isStarted.get()) {
			(new Thread(instance)).start();
			isStarted.set(true);
		}
	}

	public void stop() {
		isStopped.set(true);
		semaphore.release();
	}

	public void askPass(Train train) {
		addToQuery(train);
	}

	private void addToQuery(Train train) {
		lock.lock();
		try {
			queues.get(train.getDirection()).add(train);
		} finally {
			lock.unlock();
		}
		semaphore.release();
	}

	@Override
	public void run() {
		for (Tonnel tonnel : tonnels) {
			Thread curTonnel = new Thread(tonnel);
			curTonnel.setDaemon(true);
			curTonnel.start();
		}
		while (!isStopped.get()) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				logger.log(Level.WARN, "Unexpected interupt!", e);
			}
			boolean isPassGranted = false;
			for (Queue<Train> queue : queues.values()) {
				if (!queue.isEmpty()) {
					if (tryGrantPass(queue)) {
						isPassGranted = true;
					}
				}
			}
			if (!isPassGranted) {
				semaphore.release();
			}
		}
	}

	/**
	 * Try to add first train in the queue to tonnel queue
	 * 
	 * @param queue
	 * @return true if train is successfully added
	 */
	private boolean tryGrantPass(Queue<Train> queue) {
		boolean result = false;
		Train train = queue.peek();
		Direction direction = train.getDirection();
		for (Tonnel tonnel : tonnels) {
			if (tonnel.getCurrentDirection() == direction) { // direction is
															 // same
				switch (tonnel.getState()) {
				case EMPTY:
				case NOTEMPTY:
					tonnel.admitTrain(train);
					result = true;
					break;
				case LIMITEMPTY:
					/*
					 * if reached limit but no trains in opposite direction is
					 * waiting for the pass - switch direction to same (not
					 * opposite)
					 */
					if (queues.get(direction.getOpposite()).isEmpty()) {
						if (tonnel.switchDirection(direction)) {
							tonnel.admitTrain(train);
							result = true;
						}
					}
					break;
				case LIMIT:
					break;
				default:
					logger.log(Level.FATAL, "Unknown tonnel state");
					throw new RuntimeException("Unknown tonnel state");
				}
			} else { // direction is opposite
				switch (tonnel.getState()) {
				case EMPTY:
				case LIMITEMPTY:
					if (tonnel.switchDirection(direction)) {
						tonnel.admitTrain(train);
						result = true;
					}
					break;
				case NOTEMPTY:
				case LIMIT:
					break;
				default:
					logger.log(Level.FATAL, "Unknown tonnel state");
					throw new RuntimeException("Unknown tonnel state");
				}
			}
			if (result) {
				queue.remove(train);
				return result;
			}
		}
		return result;
	}

	public boolean registerTonnel(Tonnel tonnel) throws IllegalTonnelNameException {
		if (!tonnels.contains(tonnel)) {
			return tonnels.add(tonnel);
		} else {
			throw new IllegalTonnelNameException("Tonnel with name \"" + tonnel.getName() + "\" is already registred.");
		}
	}
}
