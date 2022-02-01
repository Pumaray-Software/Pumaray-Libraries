module com.pumaray.lib.cred {
	exports com.pumaray.lib.cred.user.impl;
	exports com.pumaray.lib.cred.user.role.impl;
	exports com.pumaray.lib.cred.user;
	exports com.pumaray.lib.cred.user.role.type.impl;

	requires com.pumaray.lib.model;
	requires jakarta.persistence;
	requires jakarta.xml.bind;
}