package com.spring.cloud.productcatalog.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@WebFilter("/product/*")
public class XSSFilter implements Filter{
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Entered doFilter....");
		HttpServletRequest httpreq=(HttpServletRequest)request;
		chain.doFilter(new XSSRequestWrapper(httpreq), response);
	}

}
