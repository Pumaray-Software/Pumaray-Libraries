package com.pumaray.lib.cred.user;

import com.pumaray.lib.model.PumBean;

public interface PumRole<T extends PumRoleType> extends PumBean {

	public final static String TYPE = "type";

	T getType();
	void setType(T type);
}
