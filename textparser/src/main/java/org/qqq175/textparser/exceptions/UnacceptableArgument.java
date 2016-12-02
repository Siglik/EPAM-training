package org.qqq175.textparser.exceptions;

public class UnacceptableArgument extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public UnacceptableArgument(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UnacceptableArgument(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UnacceptableArgument(Throwable cause) {
		super(cause);
	}
}
