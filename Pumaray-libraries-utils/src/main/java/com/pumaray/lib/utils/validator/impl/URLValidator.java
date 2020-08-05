package com.pumaray.lib.utils.validator.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.pumaray.lib.utils.constants.PumPattern;
import com.pumaray.lib.utils.validator.annotation.ValidURL;
import com.pumaray.lib.utils.validator.impl.helper.URLType;

public class URLValidator implements ConstraintValidator<ValidURL,String>  {
	
	private Pattern pattern;
	private URLType type;
	
	public URLValidator() {
		pattern = Pattern.compile(PumPattern.URL_PATTERN);
	}

	@Override
	public void initialize(ValidURL validURL) {
		 this.type = validURL.value();
	}

	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {
		boolean result = false;
		switch (type) {
			case WEB : result = isValidWeb(input,context); break;
			default : result = false;
		}
		return result;
	}
	
	private boolean isValidWeb(String input, ConstraintValidatorContext context) {
		if(!(input.startsWith("http://") || input.startsWith("https://"))) {
			return false;
		}
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	
	
}
