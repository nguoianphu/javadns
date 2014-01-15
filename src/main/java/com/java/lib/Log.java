package com.java.lib;

public class Log {

	/**
	 * display log message either to stderr or GUI.
	 * 
	 * @param msg
	 *            message to display
	 */
	public synchronized void log(String msg) {

		System.err.println(msg);

	}

}
