package com.pumaray.lib.utils.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pumaray.lib.utils.constants.PumPattern;
import com.pumaray.lib.utils.validator.annotation.ValidEmail;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
	
	private Pattern pattern;
	
	public EmailValidator() {
		pattern = Pattern.compile(PumPattern.EMAIL_PATTERN);
	}

	@Override
	public void initialize(ValidEmail arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext cv) {
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

}
