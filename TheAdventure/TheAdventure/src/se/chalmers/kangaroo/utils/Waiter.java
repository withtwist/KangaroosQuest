package se.chalmers.kangaroo.utils;

import se.chalmers.kangaroo.constants.Constants;

/**
 * This class is a utility that let any method that use the method, wait as long
 * as they want to.
 * 
 * @author pavlov
 * 
 */
public class Waiter {
	private long startTime;

	/**
	 * The constructor initiate the startTime so it is ready to be used.
	 */
	public Waiter() {
		startTime = 0;
	}

	/**
	 * This method is called by waitTime() to get the elapsed time.
	 * 
	 * @return Returns the elapsed time in milliseconds since waitTime()-method
	 *         was called.
	 */
	private double getElapsedTime() {
		return (System.nanoTime() - startTime) * Constants.NANO_TO_MILLI;
	}

	/**
	 * This method will wait until the elapsed time has reached the given time
	 * in milliseconds.
	 * 
	 * @param milliseconds
	 *            is the time that the user who called this method wants to wait
	 *            in milliseconds.
	 */
	public void waitTime(int milliseconds) {
		startTime = System.nanoTime();
		boolean isLess = true;
		while (isLess) {
			if (getElapsedTime() >= (double) milliseconds) {
				isLess = !isLess;
			}
		}
	}

}
