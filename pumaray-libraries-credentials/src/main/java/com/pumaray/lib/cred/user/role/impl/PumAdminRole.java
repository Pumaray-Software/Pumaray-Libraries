package com.pumaray.lib.cred.user.role.impl;

import com.pumaray.lib.cred.user.PumRole;
import com.pumaray.lib.cred.user.role.type.impl.PumAdminRoleType;
import com.pumaray.lib.model.impl.PumDefaultBean;

public class PumAdminRole<T extends PumAdminRoleType> extends PumDefaultBean implements PumRole<T> {

	private static final long serialVersionUID = -6257239201417679506L;
	
	public PumAdminRole() {}

	@Override
	public T getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(T type) {
		// TODO Auto-generated method stub
		
	}

}
