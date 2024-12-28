package com.github.juanargandona.exceptions.impl;

import com.github.juanargandona.exceptions.RestException;
import com.github.juanargandona.exceptions.model.ExceptionDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends RestException {

	private static final long serialVersionUID = 6446879707729573118L;

	public UnprocessableEntityException(ExceptionDetail detail) {
		super(detail);
	}

	public UnprocessableEntityException(List<ExceptionDetail> details) {
		super(details);
	}

	public UnprocessableEntityException(String errorCode, String errorMessage, Optional<Object> errorDetail) {
		super(errorCode, errorMessage, errorDetail);
	}

	public UnprocessableEntityException(ExceptionDetail detail, Exception e) {
		super(detail, e);
	}

	public UnprocessableEntityException(List<ExceptionDetail> details, Exception e) {
		super(details, e);
	}

	public UnprocessableEntityException(String errorCode, String errorMessage, Optional<Object> errorDetail, Exception e) {
		super(errorCode, errorMessage, errorDetail, e);
	}

	public UnprocessableEntityException(String errorCode, String errorMessage, Object... messageArgs) {
		super(errorCode, errorMessage, messageArgs);
	}

	public UnprocessableEntityException(String errorCode, Optional<Object> errorDetail, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, errorMessage, messageArgs);
	}

	public UnprocessableEntityException(String errorCode, Optional<Object> errorDetail, Exception e, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, e, errorMessage, messageArgs);
	}

}
