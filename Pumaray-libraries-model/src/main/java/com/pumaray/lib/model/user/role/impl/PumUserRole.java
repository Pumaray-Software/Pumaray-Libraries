package com.pumaray.lib.model.user.role.impl;

import com.pumaray.lib.model.impl.PumDefaultBean;
import com.pumaray.lib.model.user.PumRole;
import com.pumaray.lib.model.user.role.type.impl.PumUserRoleType;

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
