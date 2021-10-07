package com.spring.cloud.productcatalog.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CatalogException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errorCode;

	public CatalogException() {

	}

	public CatalogException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
