package com.yuzee.common.lib.exception;

public class InvokeException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvokeException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvokeException(String message) {
		super(message);
	}

	public InvokeException(Throwable cause) {
		super(cause);
	}
}
