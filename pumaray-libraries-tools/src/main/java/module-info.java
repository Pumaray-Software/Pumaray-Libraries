module com.pumaray.lib.tools {
	exports com.pumaray.lib.tools.comparator.impl;
	exports com.pumaray.lib.model.tools.generators.country.model;
	exports com.pumaray.lib.model.tools.adapter.json;
	exports com.pumaray.lib.tools.comparator;
	exports com.pumaray.lib.model.tools.entity.builder;
	exports com.pumaray.lib.tools.validator;
	exports com.pumaray.lib.tools.generators.validator;
	exports com.pumaray.lib.tools.generators.properties.tools;
	exports com.pumaray.lib.tools.validator.impl;
	exports com.pumaray.lib.tools.generators.country;
	exports com.pumaray.lib.tools.generators.properties;
	exports com.pumaray.lib.tools.adapter.json;
	exports com.pumaray.lib.tools.generators.country.model;

	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires com.google.gson;
	requires com.pumaray.lib.model;
	requires com.pumaray.lib.utils;
	requires jakarta.xml.bind;
	requires java.desktop;
	requires mapdb;
	requires org.slf4j;
}