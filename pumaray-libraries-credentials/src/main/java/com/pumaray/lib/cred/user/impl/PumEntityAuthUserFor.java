package com.pumaray.lib.cred.user.impl;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.OneToMany;

public class PumEntityAuthUserFor<E> extends PumEntityAuthUser {

	private static final long serialVersionUID = -8861271424501453846L;

	@OneToMany
	private List<E> children = new ArrayList<E>();

	protected PumEntityAuthUserFor() {
	}

	public PumEntityAuthUserFor(String name, String alias, char[] password, String question, char[] answer,
			char[] token, List<E> children) {
		super(name, alias, password, question, answer, token);

	}

	public List<E> getChildren() {
		return children;
	}

	public void setChildren(List<E> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "PumEntityAuthUserFor [children=" + children + "]";
	}

}
