package com.pumaray.lib.cred.user;

public interface PumAuthUser<K> extends PumUser<K> {

	public static final String PASSWORD = "password";
	public static final String QUESTION = "question";
	public static final String ANSWER = "answer";
	public static final String TOKEN = "token";

	char[] getPassword();

	void setPassword(char[] password);

	String getQuestion();

	void setQuestion(String question);

	char[] getAnswer();

	void setAnswer(char[] answer);

	char[] getToken();

	void setToken(char[] token);

}
