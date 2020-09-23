package com.pumaray.lib.model.user.impl;

import java.util.Arrays;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.pumaray.lib.model.impl.PumDefaultEntity;
import com.pumaray.lib.model.user.PumAuthUser;

@Entity(name = "PUM_ENTITY_AUTH_USER")
@AttributeOverride(name = PumDefaultEntity.ID, column = @Column(name = PumEntityAuthUser.USER_ID))
@XmlAccessorType(XmlAccessType.FIELD)
public class PumEntityAuthUser extends PumEntityUser implements PumAuthUser<Long> {

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
