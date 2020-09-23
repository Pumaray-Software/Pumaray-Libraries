package com.pumaray.lib.cred.user.impl;

import com.pumaray.lib.cred.user.PumRole;
import com.pumaray.lib.cred.user.PumRoleType;
import com.pumaray.lib.model.impl.PumDefaultBean;

public class PumDefaultRole<T extends PumRoleType> extends PumDefaultBean implements PumRole<T> {

	private static final long serialVersionUID = -514541579124675537L;
	
	private T type;
	
	public PumDefaultRole(){}
	
	@Override
	public T getType() {
		return type;
	}

	@Override
	public void setType(T type) {
		this.type = type;
	}

}
