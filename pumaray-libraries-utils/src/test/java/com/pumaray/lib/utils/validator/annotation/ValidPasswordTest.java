package com.pumaray.lib.utils.validator.annotation;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.pumaray.lib.utils.constants.PumPattern;

public class ValidPasswordTest {

	@Test
	public void testValidPassword() {
		String password = "pasSword1A@1";
		assertTrue(password.matches(PumPattern.PASSWORD_PATTERN));
	}

}
