package org.qqq175.railway.main;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.qqq175.railway.dispatcher.RailwayDispatcher;
import org.qqq175.railway.exception.IllegalTonnelNameException;
import org.qqq175.railway.tonnel.Direction;
import org.qqq175.railway.tonnel.Tonnel;
import org.qqq175.railway.train.Train;
import org.qqq175.railway.util.Randomizer;
import org.qqq175.railway.util.Settings;

/**
 * Hello world!
 *
 */
public class App {

	private static Logger logger = LogManager.getLogger(App.class);

	private RailwayDispatcher dispatcher;
	private Randomizer randomizer;
	private ScheduledExecutorService executor;

	public void init() {
		randomizer = Randomizer.getInstance();
		dispatcher = RailwayDispatcher.getInstance();
		try {
			dispatcher.registerTonnel(new Tonnel("East"));
			dispatcher.registerTonnel(new Tonnel("West"));
		} catch (IllegalTonnelNameException e) {
			logger.log(Level.ERROR, e.getMessage(), e);
		}

		executor = Executors.newScheduledThreadPool(Settings.TRAINS_COUNT);
	}

	public void start() {
		dispatcher.start();

		for (int i = 1; i <= Settings.TRAINS_COUNT; i++) {
			Direction[] directions = Direction.values();
			Train train = new Train(directions[randomizer.nextInt(directions.length)], i);
			executor.schedule(train, randomizer.nextInt(Settings.TRAINS_COUNT), TimeUnit.MILLISECONDS);
		}

		executor.shutdown();
		try {
			while (!executor.awaitTermination(1l, TimeUnit.SECONDS)) {
			}
		} catch (InterruptedException e) {
			logger.log(Level.WARN, "Unexpected interupt!", e);
		} finally {
			dispatcher.stop();
		}
	}
}
