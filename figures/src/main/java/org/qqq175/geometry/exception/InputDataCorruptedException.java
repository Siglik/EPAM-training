package org.qqq175.geometry.exception;

public class InputDataCorruptedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public InputDataCorruptedException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public InputDataCorruptedException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public InputDataCorruptedException(Throwable cause) {
		super(cause);
	}

}
