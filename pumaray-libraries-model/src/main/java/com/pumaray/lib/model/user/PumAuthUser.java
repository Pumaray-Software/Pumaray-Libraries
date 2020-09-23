package com.pumaray.lib.model.user;

public interface PumAuthUser<K> extends PumUser<K> {

	public static final String PASSWORD = "password";
	public static final String QUESTION = "question";
	public static final String ANSWER = "answer";

	char[] getPassword();
	void setPassword(char[] password);

	String getQuestion();
	void setQuestion(String question);

	char[] getAnswer();
	void setAnswer(char[] answer);

}
