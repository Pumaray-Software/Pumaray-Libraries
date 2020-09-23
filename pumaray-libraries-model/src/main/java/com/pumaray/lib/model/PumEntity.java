package com.pumaray.lib.model;

public interface PumEntity<T> extends PumBean {
	
	public static final String ID = "id";

	T getId();
	
	void setId(T id);

}
