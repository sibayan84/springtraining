package com.demo.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.mvc.model.CategoryAndManufacturer;

@Component
public class CategoryManufacturerFormValidator implements Validator {


	@Override
	public boolean supports(Class<?> clazz) {
		return CategoryAndManufacturer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		CategoryAndManufacturer cm = (CategoryAndManufacturer) target;

		if (StringUtils.isEmpty(cm.getCategory().getCode())) {
			errors.rejectValue("category.code", "NotEmpty.form.code");
		}

		if (StringUtils.isEmpty(cm.getManufacturer().getCode())) {
			errors.rejectValue("manufacturer.code", "NotEmpty.form.code");
		}

	}

}