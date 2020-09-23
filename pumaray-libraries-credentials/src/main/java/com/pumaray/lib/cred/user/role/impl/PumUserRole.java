package com.pumaray.lib.cred.user.role.impl;

import com.pumaray.lib.cred.user.PumRole;
import com.pumaray.lib.cred.user.role.type.impl.PumUserRoleType;
import com.pumaray.lib.model.impl.PumDefaultBean;

public class PumUserRole extends PumDefaultBean implements PumRole<PumUserRoleType> {

	private static final long serialVersionUID = -205178976990702935L;

	private PumUserRoleType type;

	@Override
	public PumUserRoleType getType() {
		return type;
	}

	@Override
	public void setType(PumUserRoleType type) {
		this.type = type;
	}

}
