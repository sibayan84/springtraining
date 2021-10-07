package com.spring.cloud.productcatalog.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.spring.cloud.productcatalog.exception.CatalogException;
import com.spring.cloud.productcatalog.pojo.APIErrorResponse;;

public class BaseController {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(CatalogException.class)
	public @ResponseBody APIErrorResponse handleCatalogException(CatalogException ex) {
		return new APIErrorResponse(ex.getErrorCode(), ex.getLocalizedMessage());
	}

}
