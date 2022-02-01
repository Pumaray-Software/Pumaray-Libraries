module com.pumaray.lib.model {
	exports com.pumaray.lib.model.user;
	exports com.pumaray.lib.model.user.role.impl;
	exports com.pumaray.lib.model.constant;
	exports com.pumaray.lib.model.graphics;
	exports com.pumaray.lib.model.impl;
	exports com.pumaray.lib.model.user.impl;
	exports com.pumaray.lib.model.app;
	exports com.pumaray.lib.model;
	exports com.pumaray.lib.model.user.role.type.impl;

	requires jakarta.persistence;
	requires jakarta.xml.bind;
	requires com.pumaray.lib.utils;
}