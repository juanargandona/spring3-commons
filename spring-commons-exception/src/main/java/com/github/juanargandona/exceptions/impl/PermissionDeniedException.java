package com.github.juanargandona.exceptions.impl;

import com.github.juanargandona.exceptions.model.ExceptionDetail;

import java.util.List;
import java.util.Optional;

public class PermissionDeniedException extends ForbiddenException {

	private static final long serialVersionUID = -261986049061018183L;

	public PermissionDeniedException(ExceptionDetail detail) {
		super(detail);
	}

	public PermissionDeniedException(List<ExceptionDetail> details) {
		super(details);
	}

	public PermissionDeniedException(String errorCode, String errorMessage, Optional<Object> errorDetail) {
		super(errorCode, errorMessage, errorDetail);
	}

	public PermissionDeniedException(ExceptionDetail detail, Exception e) {
		super(detail, e);
	}

	public PermissionDeniedException(List<ExceptionDetail> details, Exception e) {
		super(details, e);
	}

	public PermissionDeniedException(String errorCode, String errorMessage, Optional<Object> errorDetail, Exception e) {
		super(errorCode, errorMessage, errorDetail, e);
	}

	public PermissionDeniedException(String errorCode, String errorMessage, Object... messageArgs) {
		super(errorCode, errorMessage, messageArgs);
	}

	public PermissionDeniedException(String errorCode, Optional<Object> errorDetail, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, errorMessage, messageArgs);
	}

	public PermissionDeniedException(String errorCode, Optional<Object> errorDetail, Exception e, String errorMessage, Object... messageArgs) {
		super(errorCode, errorDetail, e, errorMessage, messageArgs);
	}
}