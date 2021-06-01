package com.yuzee.common.lib.exception;

import com.yuzee.common.lib.exception.BaseRuntimeException;

public class IncorrectPermissionSetup extends BaseRuntimeException {

	private static final long serialVersionUID = 6656549226555223105L;

	public IncorrectPermissionSetup(String message) {
		super(message);
	}

}
