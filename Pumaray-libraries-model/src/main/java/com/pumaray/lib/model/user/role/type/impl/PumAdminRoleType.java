package com.pumaray.lib.model.user.role.type.impl;

import com.pumaray.lib.model.user.impl.PumDefaultRoleType;

public class PumAdminRoleType extends PumDefaultRoleType {

	private static final long serialVersionUID = -4093922410192832567L;

	public static PumAdminRoleType getSimpleInstance() {
		PumAdminRoleType type = new PumAdminRoleType();
		// for later add default things
		return type;
	}

}
