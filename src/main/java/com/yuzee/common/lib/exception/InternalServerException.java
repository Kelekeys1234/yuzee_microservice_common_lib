package com.yuzee.common.lib.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends BaseRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	private static final HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

	/**
	 *
	 */
	public InternalServerException() {
	}

	/**
	 *
	 * @param status
	 * @param message
	 * @param cause
	 */
	public InternalServerException(final String message, final Throwable cause) {
		super(status, message, cause);
	}

	/**
	 *
	 * @param status
	 * @param message
	 */
	public InternalServerException(final String message) {
		super(status, message);
	}

	/**
	 *
	 * @param status
	 * @param cause
	 */
	public InternalServerException(final Throwable cause) {
		super(status, cause);
	}
}
