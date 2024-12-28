package com.github.juanargandona.exceptions.impl;

import com.github.juanargandona.exceptions.RestException;
import com.github.juanargandona.exceptions.model.ExceptionDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ConflictException extends RestException {

	private static final long serialVersionUID = 3193488927248995976L;

	public ConflictException(ExceptionDetail detail) {
		super(detail);
	}

	public ConflictException(List<ExceptionDetail> details) {
		super(details);
	}

	public ConflictException(String errorCode, String errorMessage, Optional<Object> errorDetail) {
		super(errorCode, errorMessage, errorDetail);
	}

	public ConflictException(ExceptionDetail detail, Exception e) {
		super(detail, e);
	}

	public ConflictException(List<ExceptionDetail> details, Exception e) {
		super(details, e);
	}

	public ConflictException(String errorCode, String errorMessage, Optional<Object> errorDetail, Exception e) {
		super(errorCode, errorMessage, errorDetail, e);
	}

	public ConflictException(String errorCode, String errorMessage, Object... messageArgs) {
		super(errorCode, errorMessage, messageArgs);
	}

	public ConflictException(String errorCode, Optional<Object> errorDetail, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, errorMessage, messageArgs);
	}

	public ConflictException(String errorCode, Optional<Object> errorDetail, Exception e, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, e, errorMessage, messageArgs);
	}

}
