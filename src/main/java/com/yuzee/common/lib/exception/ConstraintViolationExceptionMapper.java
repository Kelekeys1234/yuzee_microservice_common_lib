package com.yuzee.common.lib.exception;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.yuzee.common.lib.dto.ErrorWrapper;
import com.yuzee.local.config.MessageTranslator;

import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
@Component
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Autowired
	private MessageTranslator messageTranslator;
	
    @Override
    public Response toResponse(final ConstraintViolationException exception) {
    	StringBuilder message = new StringBuilder();
         for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
             message.append(messageTranslator.toLocale(cv.getMessage().replace("{", "").replace("}", "")));
         }
    	ErrorWrapper errorWrapper = new ErrorWrapper();
    	log.error("Exception occured {}",exception);
		errorWrapper.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorWrapper.setErrorMessage(message.toString());
		return Response.status(HttpStatus.BAD_REQUEST.value()).entity(errorWrapper).build();
    }
}
