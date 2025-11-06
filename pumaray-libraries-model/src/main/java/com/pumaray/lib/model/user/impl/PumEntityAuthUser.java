package com.pumaray.lib.model.user.impl;

import java.util.Arrays;

import com.pumaray.lib.model.PumEntity;
import com.pumaray.lib.model.impl.PumDefaultEntity;
import com.pumaray.lib.model.user.PumAuthUser;

import jakarta.persistence.Column;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

@jakarta.persistence.Entity(name = "PUM_ENTITY_AUTH_USER")
@jakarta.persistence.AttributeOverride(name = PumDefaultEntity.ID, column = @Column(name = PumEntityAuthUser.USER_ID))
@XmlAccessorType(XmlAccessType.FIELD)
public class PumEntityAuthUser extends PumEntityUser implements PumAuthUser{

	private static final long serialVersionUID = -5220576337776137380L;
	public static final String USER_ID = "userId";

	@Column(name = PASSWORD)
	@XmlTransient
	private char[] password;

	@Column(name = QUESTION)
	private String question;

	@Column(name = ANSWER)
	@XmlTransient
	private char[] answer;

	public PumEntityAuthUser() {
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "PumEntityAuthUser [password=" + Arrays.toString(password) + ", question=" + question + ", answer="
				+ Arrays.toString(answer) + "]";
	}
}
