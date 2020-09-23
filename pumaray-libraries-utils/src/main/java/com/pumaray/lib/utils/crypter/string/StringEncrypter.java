package com.pumaray.lib.utils.crypter.string;

import java.util.UUID;

public class StringEncrypter {
	
	private static StringEncrypter encrypter = null;
	
	public StringEncrypter() {
		
	}
	
	private static void init() {
		if(encrypter == null) {
			encrypter = new StringEncrypter();
		}
	}
	
	//***********************--Static Methods --*************************************

	public static StringEncrypter getInstance() {
		init();
		return encrypter;
	}
	
	public static String generateRandomHash() {
		init();
		return UUID.randomUUID().toString();
	}
	
	//*********************** Object Methods --*************************************
}
