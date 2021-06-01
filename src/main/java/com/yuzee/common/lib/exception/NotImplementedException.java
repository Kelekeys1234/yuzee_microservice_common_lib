package com.yuzee.common.lib.exception;
/**
 * @author seeka.org
 */
import org.springframework.http.HttpStatus;

public class NotImplementedException extends BaseException {

	/**
	 *
	 */
	private static final long serialVersionUID = 8569404917204068340L;
	private static final HttpStatus status = HttpStatus.NOT_FOUND;

	/**
	 *
	 */
	public NotImplementedException() {
	}

	/**
	 *
	 * @param status
	 * @param message
	 * @param cause
	 */
	public NotImplementedException(final String message, final Throwable cause) {
		super(status, message, cause);
	}

	/**
	 *
	 * @param status
	 * @param message
	 */
	public NotImplementedException(final String message) {
		super(status, message);
	}

	/**
	 *
	 * @param status
	 * @param cause
	 */
	public NotImplementedException(final Throwable cause) {
		super(status, cause);
	}

}
