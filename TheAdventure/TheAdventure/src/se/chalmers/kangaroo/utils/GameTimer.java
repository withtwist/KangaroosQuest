package se.chalmers.kangaroo.utils;

import se.chalmers.kangaroo.constants.Constants;

/**
 * A class used to keep track of the elapsed time in a game level.
 * 
 * @author pavlov
 * 
 */
public class GameTimer {
	private long startTime, endTime, pausStartTime, totalPausTime;
	private boolean isPaused;

	/**
	 * A constructor that initiate all the values.
	 */
	public GameTimer() {
		startTime = 0;
		endTime = 0;
		pausStartTime = 0;
		totalPausTime = 0;
		isPaused = false;
	}

	/**
	 * Starting the GameTimer. This will check the current time in nanoseconds
	 * and initiate it to a variable startTime.
	 */
	public void start() {
		startTime = System.nanoTime();
	}

	/**
	 * Stops the GameTimer. This will take the current time in nanoseconds and
	 * subtract the start time and the total time that the player has paused the
	 * game. This will be initiated to a variable endTime.
	 */
	public void stop() {
		endTime = System.nanoTime() - (startTime + totalPausTime);

	}

	/**
	 * Pause the GameTimer. This will save the current time to a variable
	 * pausStartTime and set isPaused to true.
	 */
	public void pause() {
		pausStartTime = System.nanoTime();
		isPaused = true;

	}

	/**
	 * Unpause the game. This will take the current time and subtract it with
	 * the time when the pause occurred. This value will be added to a variable
	 * totalPausTime that will be used to calculate the end time. It will also
	 * set isPaused to false.
	 */
	public void unpause() {
		totalPausTime = totalPausTime + (System.nanoTime() - pausStartTime);
		isPaused = false;
	}

	/**
	 * This method will return the elapsed time in seconds and two decimals. The
	 * method will call the method getElapsedNanoTime to get the elapsed time in
	 * nanoseconds and the convert it to seconds.
	 * 
	 * @return the elapsed time in seconds and two decimals will be returned.
	 */
	public double getElapsedTime() {
		return ((int) (getElapsedNanoTime() * Constants.NANO_TO_SECOND * 100)) / 100.0;
	}

	/**
	 * This method will return the elapsed time in nanoseconds. The first thing
	 * it will do is to check if the game is paused, if the game is paused, it
	 * will return the time from when the pause was occurred. if the game is not
	 * paused, it will return the elapsed time.
	 * 
	 * @return
	 */
	public long getElapsedNanoTime() {
		if (isPaused == true) {
			return pausStartTime - (startTime + totalPausTime);
		} else {
			return System.nanoTime() - (startTime + totalPausTime);
		}
	}

	/**
	 * Return the total time from start to stop. This will use the variable
	 * endTime and convert it into seconds with two decimals.
	 * 
	 * @return the total time from start to stop in seconds and two decimals.
	 */
	public double getResult() {
		return ((int) (endTime * Constants.NANO_TO_SECOND * 100)) / 100.0;
	}

	public String toString() {
		return "Your time is: " + getResult();
	}
}
