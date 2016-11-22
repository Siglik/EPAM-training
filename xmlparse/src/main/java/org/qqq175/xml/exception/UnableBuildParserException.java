package org.qqq175.xml.exception;

public class UnableBuildParserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 */
	public UnableBuildParserException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UnableBuildParserException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UnableBuildParserException(Throwable cause) {
		super(cause);
	}

}
