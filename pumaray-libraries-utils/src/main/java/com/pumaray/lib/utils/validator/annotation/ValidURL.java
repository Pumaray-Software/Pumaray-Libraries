package com.pumaray.lib.utils.validator.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.pumaray.lib.utils.validator.impl.URLValidator;
import com.pumaray.lib.utils.validator.impl.helper.URLType;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Retention(RUNTIME)
@Target({TYPE, FIELD, METHOD})
@Constraint(validatedBy = URLValidator.class)
public @interface ValidURL {
	String message() default "Web URL constraint has been violated";
	 
    Class<?>[] groups() default {};
 
    Class<? extends Payload>[] payload() default {};
    
    URLType value();
}
