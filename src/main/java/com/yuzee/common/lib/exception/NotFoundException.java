package com.yuzee.common.lib.exception;
/**
 * @author seeka.org
 */
import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseRuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 8569404917204068340L;
	private static final HttpStatus status = HttpStatus.NOT_FOUND;

	/**
	 *
	 */
	public NotFoundException() {
	}

	/**
	 *
	 * @param status
	 * @param message
	 * @param cause
	 */
	public NotFoundException(final String message, final Throwable cause) {
		super(status, message, cause);
	}

	/**
	 *
	 * @param status
	 * @param message
	 */
	public NotFoundException(final String message) {
		super(status, message);
	}

	/**
	 *
	 * @param status
	 * @param cause
	 */
	public NotFoundException(final Throwable cause) {
		super(status, cause);
	}

}
