package com.github.juanargandona.exceptions.impl;

import com.github.juanargandona.exceptions.RestException;
import com.github.juanargandona.exceptions.model.ExceptionDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RestException {

	private static final long serialVersionUID = 2527808074583211325L;

	public NotFoundException(ExceptionDetail detail) {
		super(detail);
	}

	public NotFoundException(List<ExceptionDetail> details) {
		super(details);
	}

	public NotFoundException(String errorCode, String errorMessage, Optional<Object> errorDetail) {
		super(errorCode, errorMessage, errorDetail);
	}

	public NotFoundException(ExceptionDetail detail, Exception e) {
		super(detail, e);
	}

	public NotFoundException(List<ExceptionDetail> details, Exception e) {
		super(details, e);
	}

	public NotFoundException(String errorCode, String errorMessage, Optional<Object> errorDetail, Exception e) {
		super(errorCode, errorMessage, errorDetail, e);
	}

	public NotFoundException(String errorCode, String errorMessage, Object... messageArgs) {
		super(errorCode, errorMessage, messageArgs);
	}

	public NotFoundException(String errorCode, Optional<Object> errorDetail, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, errorMessage, messageArgs);
	}

	public NotFoundException(String errorCode, Optional<Object> errorDetail, Exception e, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, e, errorMessage, messageArgs);
	}

}
