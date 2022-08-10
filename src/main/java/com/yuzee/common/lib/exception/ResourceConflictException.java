package com.yuzee.common.lib.exception;

import org.springframework.http.HttpStatus;

import com.yuzee.common.lib.exception.BaseException;


public class ResourceConflictException extends BaseException {

	private static final long serialVersionUID = 8569404917204068340L;
	private static final HttpStatus status = HttpStatus.CONFLICT;

	
	public ResourceConflictException() {
	}

	/**
	 *
	 * @param status
	 * @param message
	 * @param cause
	 */
	public ResourceConflictException(final String message, final Throwable cause) {
		super(status, message, cause);
	}

	/**
	 *
	 * @param status
	 * @param message
	 */
	public ResourceConflictException(final String message) {
		super(status, message);
	}

	/**
	 *
	 * @param status
	 * @param cause
	 */
	public ResourceConflictException(final Throwable cause) {
		super(status, cause);
	}

}
