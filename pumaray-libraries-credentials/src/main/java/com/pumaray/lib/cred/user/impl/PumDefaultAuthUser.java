package com.pumaray.lib.cred.user.impl;

import java.util.Arrays;

import com.pumaray.lib.cred.user.PumAuthUser;

public class PumDefaultAuthUser<K> extends PumDefaultUser<K> implements PumAuthUser<K> {
	
	private static final long serialVersionUID = -9208884254431870905L;
	
	private char[] password;
	private String question;
	private char[] answer;
	private char[] token;

	
	public PumDefaultAuthUser(){}
	
	public PumDefaultAuthUser(String name, String alias, char[] password) {
		super(name, alias);
		this.password = password;
	}

	@Override
	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	@Override
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public char[] getAnswer() {
		return answer;
	}

	public void setAnswer(char[] answer) {
		this.answer = answer;
	}
	
	public char[] getToken() {
		return token;
	}

	public void setToken(char[] token) {
		this.token = token;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PumDefaultAuthUser [password=" + Arrays.toString(password) + ", question=" + question + ", answer="
				+ Arrays.toString(answer) + "]";
	}

}
