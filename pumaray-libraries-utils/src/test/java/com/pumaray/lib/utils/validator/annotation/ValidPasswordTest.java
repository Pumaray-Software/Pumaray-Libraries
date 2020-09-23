package com.pumaray.lib.utils.validator.annotation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.pumaray.lib.utils.constants.PumPattern;

public class ValidPasswordTest {

	@Test
	public void testValidPassword() {
		String password = "pasSword1A@1";
		assertTrue(password.matches(PumPattern.PASSWORD_PATTERN));
	}

}
