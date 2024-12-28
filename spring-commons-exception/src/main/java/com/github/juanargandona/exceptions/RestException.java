package com.github.juanargandona.exceptions;

import com.github.juanargandona.exceptions.model.ErrorMessage;
import com.github.juanargandona.exceptions.model.ExceptionDetail;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class RestException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -5157622261482152458L;

	protected final List<ExceptionDetail> details;

	protected RestException(List<ExceptionDetail> details, Exception e) {
		super(details != null ? details.toString() : "", e);
		this.details = details;
	}

	protected RestException(List<ExceptionDetail> details) {
		this(details, null);
	}

	protected RestException(ExceptionDetail detail, Exception e) {
		this(Arrays.asList(detail), e);
	}

	protected RestException(ExceptionDetail detail) {
		this(detail, null);
	}

	protected RestException(String errorCode, String errorMessage, Optional<Object> errorDetail) {
		this(errorCode, errorMessage, errorDetail, null);
	}

	protected RestException(String errorCode, String errorMessage, Optional<Object> errorDetail, Exception e) {
		this(new ExceptionDetail(errorCode, errorMessage, errorDetail), e);
	}

	protected RestException(String errorCode, String errorMessage, Object... messageArgs) {
		this(errorCode, Optional.empty(), errorMessage, messageArgs);
	}

	protected RestException(String errorCode, Optional<Object> errorDetail, String errorMessage, Object... messageArgs) {
		this(errorCode, errorDetail, null, errorMessage, messageArgs);
	}

	protected RestException(String errorCode, Optional<Object> errorDetail, Exception e, String errorMessage, Object... messageArgs) {
		this(new ExceptionDetail(errorCode, errorDetail, errorMessage, messageArgs), e);
	}

	public List<ExceptionDetail> getDetails() {
		return details;
	}

	public ErrorMessage getErrorMessage(HttpServletRequest request) {
		return new ErrorMessage(this.getDetails(), request);
	}

	public HttpStatus getHttpCode() {
		return this.getHttpCode(this.getClass());
	}

	public HttpStatus getHttpCode(Class<? extends RestException> ex) {
		ResponseStatus rs = ex.getAnnotation(ResponseStatus.class);
		if (rs != null) {
			return rs.code();
		} else {
			return getHttpCode((Class<? extends RestException>) ex.getSuperclass());
		}
	}

	private void readObject(ObjectInputStream aInputStream)
			throws ClassNotFoundException, IOException {
		// always perform the default deserialization first
		aInputStream.defaultReadObject();
	}

	private void writeObject(ObjectOutputStream aOutputStream)
			throws IOException {
		// perform the default serialization for all non-transient, non-static
		// fields
		aOutputStream.defaultWriteObject();
	}
}
