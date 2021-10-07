package com.spring.cloud.productcatalog.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
@SuppressWarnings("deprecation")
public class InterceptorAppConfig extends WebMvcConfigurerAdapter {
	
	@Autowired
	ExecutionTimeInterceptor exTimeInterceptor;
	
	 @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(exTimeInterceptor);
	   }

}
