package com.github.juanargandona.exceptions.impl;

import com.github.juanargandona.exceptions.RestException;
import com.github.juanargandona.exceptions.model.ExceptionDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowedException extends RestException {

	private static final long serialVersionUID = -5646311440590405753L;

	public MethodNotAllowedException(ExceptionDetail detail) {
		super(detail);
	}

	public MethodNotAllowedException(List<ExceptionDetail> details) {
		super(details);
	}

	public MethodNotAllowedException(String errorCode, String errorMessage, Optional<Object> errorDetail) {
		super(errorCode, errorMessage, errorDetail);
	}

	public MethodNotAllowedException(ExceptionDetail detail, Exception e) {
		super(detail, e);
	}

	public MethodNotAllowedException(List<ExceptionDetail> details, Exception e) {
		super(details, e);
	}

	public MethodNotAllowedException(String errorCode, String errorMessage, Optional<Object> errorDetail, Exception e) {
		super(errorCode, errorMessage, errorDetail, e);
	}

	public MethodNotAllowedException(String errorCode, String errorMessage, Object... messageArgs) {
		super(errorCode, errorMessage, messageArgs);
	}

	public MethodNotAllowedException(String errorCode, Optional<Object> errorDetail, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, errorMessage, messageArgs);
	}

	public MethodNotAllowedException(String errorCode, Optional<Object> errorDetail, Exception e, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, e, errorMessage, messageArgs);
	}

}
