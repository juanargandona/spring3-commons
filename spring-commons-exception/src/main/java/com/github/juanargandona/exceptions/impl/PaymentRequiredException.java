package com.github.juanargandona.exceptions.impl;

import com.github.juanargandona.exceptions.RestException;
import com.github.juanargandona.exceptions.model.ExceptionDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;

@ResponseStatus(code = HttpStatus.PAYMENT_REQUIRED)
public class PaymentRequiredException extends RestException {

	private static final long serialVersionUID = -2336079758604689029L;

	public PaymentRequiredException(ExceptionDetail detail) {
		super(detail);
	}

	public PaymentRequiredException(List<ExceptionDetail> details) {
		super(details);
	}

	public PaymentRequiredException(String errorCode, String errorMessage, Optional<Object> errorDetail) {
		super(errorCode, errorMessage, errorDetail);
	}

	public PaymentRequiredException(ExceptionDetail detail, Exception e) {
		super(detail, e);
	}

	public PaymentRequiredException(List<ExceptionDetail> details, Exception e) {
		super(details, e);
	}

	public PaymentRequiredException(String errorCode, String errorMessage, Optional<Object> errorDetail, Exception e) {
		super(errorCode, errorMessage, errorDetail, e);
	}

	public PaymentRequiredException(String errorCode, String errorMessage, Object... messageArgs) {
		super(errorCode, errorMessage, messageArgs);
	}

	public PaymentRequiredException(String errorCode, Optional<Object> errorDetail, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, errorMessage, messageArgs);
	}

	public PaymentRequiredException(String errorCode, Optional<Object> errorDetail, Exception e, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, e, errorMessage, messageArgs);
	}

}
