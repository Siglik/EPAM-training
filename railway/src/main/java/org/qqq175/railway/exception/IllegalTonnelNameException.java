package org.qqq175.railway.exception;

public class IllegalTonnelNameException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public IllegalTonnelNameException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public IllegalTonnelNameException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public IllegalTonnelNameException(Throwable cause) {
		super(cause);
	}
}
