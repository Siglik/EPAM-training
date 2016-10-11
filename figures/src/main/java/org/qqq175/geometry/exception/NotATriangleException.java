package org.qqq175.geometry.exception;

public class NotATriangleException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public NotATriangleException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public NotATriangleException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public NotATriangleException(Throwable cause) {
		super(cause);
	}
}
