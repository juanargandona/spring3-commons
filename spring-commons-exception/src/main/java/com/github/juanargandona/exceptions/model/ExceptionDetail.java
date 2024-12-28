package com.github.juanargandona.exceptions.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ExceptionDetail implements Serializable {

	private static final long serialVersionUID = 1905128741950251207L;

	@JsonAlias({"error_code", "errorCode"})
	private String errorCode;

	@JsonAlias({"error_detail", "errorDetail"})
	private Optional<Object> errorDetail;

	@JsonAlias({"error_message", "errorMessage"})
	private String errorMessage;

	@JsonIgnore
	private Object[] messageArgs;

	@JsonAlias({"meta_data", "metaData", "metadata"})
	private Map<String, Object> metaData;

	public ExceptionDetail() {
	}

	public ExceptionDetail(String errorCode,
						   String errorMessage,
						   Optional<Object> detail) {
		this(errorCode, detail, errorMessage);
	}

	public ExceptionDetail(String errorCode,
						   Optional<Object> detail,
						   String errorMessage,
						   Object... messageArgs) {
		this.errorCode = errorCode;
		this.errorDetail = detail;
		this.errorMessage = errorMessage;
		this.messageArgs = messageArgs;
		this.metaData = new HashMap<>();
	}

	public static ExceptionDetail getDetail(HttpClientErrorException e, String code) throws JsonProcessingException {
		ErrorMessage message = ErrorMessage.getInstance(e);
		return message.getDetails().stream()
				.filter(detail -> detail.getErrorCode().equalsIgnoreCase(code))
				.findAny()
				.orElse(new ExceptionDetail());
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}

	public Object[] getMessageArgs() {
		return messageArgs;
	}

	public void setMetaData(String key, Object value) {
		metaData.put(key, value);
	}

	public Map<String, Object> getMetaData() {
		return this.metaData;
	}

	public Optional<Object> getErrorDetail() {
		return errorDetail;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

	/**
	 * Always treat deserialization as a full-blown constructor, by validating
	 * the final state of the de-serialized object.
	 */
	private void readObject(ObjectInputStream aInputStream)
			throws ClassNotFoundException, IOException {
		// always perform the default deserialization first
		aInputStream.defaultReadObject();
	}

	/**
	 * This is the default implementation of writeObject. Customise if
	 * necessary.
	 */
	private void writeObject(ObjectOutputStream aOutputStream)
			throws IOException {
		// perform the default serialization for all non-transient, non-static
		// fields
		aOutputStream.defaultWriteObject();
	}

}
