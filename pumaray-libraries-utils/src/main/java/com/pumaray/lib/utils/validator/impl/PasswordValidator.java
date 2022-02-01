package com.pumaray.lib.utils.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pumaray.lib.utils.constants.PumPattern;
import com.pumaray.lib.utils.validator.annotation.ValidPassword;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, char[]> {

	private Pattern pattern;

	public PasswordValidator() {
		pattern = Pattern.compile(PumPattern.PASSWORD_PATTERN);
	}

	@Override
	public void initialize(ValidPassword arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(char[] password, ConstraintValidatorContext arg1) {
		String pass = String.valueOf(password);
		if (pass.trim().equals("")) {
			return false;
		}
		else {
			Matcher matcher = pattern.matcher(String.valueOf(password));
			return matcher.matches();
		}
	}

}
