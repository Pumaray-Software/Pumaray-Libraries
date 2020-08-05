package com.pumaray.lib.model.user.role.type.impl;

import com.pumaray.lib.model.user.impl.PumDefaultRoleType;

public class PumGuestRoleType extends PumDefaultRoleType {
	
	private static final long serialVersionUID = 480192682054862082L;

	public static PumGuestRoleType getSimpleInstance() {
		PumGuestRoleType type = new PumGuestRoleType();
		// for later add default things
		return type;
	}

}
