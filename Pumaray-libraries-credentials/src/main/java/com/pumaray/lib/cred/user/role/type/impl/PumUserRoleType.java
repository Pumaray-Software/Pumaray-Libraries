package com.pumaray.lib.cred.user.role.type.impl;

import com.pumaray.lib.cred.user.impl.PumDefaultRoleType;

public class PumUserRoleType extends PumDefaultRoleType {

	private static final long serialVersionUID = 1587449685587278804L;

	public static PumUserRoleType getSimpleInstance() {
		PumUserRoleType type = new PumUserRoleType();
		// for later add default things
		return type;
	}
}
