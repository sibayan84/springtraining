package com.demo.mvc.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.mvc.model.Manufacturer;


@Component
public class ManufacturerFormValidator implements Validator {

	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;

	@Override
	public boolean supports(Class<?> clazz) {
		return Manufacturer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Manufacturer user = (Manufacturer) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.form.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.form.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.form.address");

		if (!emailValidator.valid(user.getEmail())) {
			errors.rejectValue("email", "Pattern.form.email");
		}

	}

}