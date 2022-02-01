module com.pumaray.lib.utils {
	exports com.pumaray.lib.utils.resource;
	exports com.pumaray.lib.utils.constants;
	exports com.pumaray.lib.utils.navigation;
	exports com.pumaray.lib.utils.crypter;
	exports com.pumaray.lib.utils.io;
	exports com.pumaray.lib.utils.xml.exporter;
	exports com.pumaray.lib.utils.graphics;
	exports com.pumaray.lib.utils.xml.elements;
	exports com.pumaray.lib.utils.crypter.string;
	exports com.pumaray.lib.utils.validator.impl;
	exports com.pumaray.lib.utils.validator.impl.helper;
	exports com.pumaray.lib.utils.validator.annotation;
	exports com.pumaray.lib.utils.jaxrs.patch;
	exports com.pumaray.lib.utils.format;
	exports com.pumaray.lib.utils.xml.adapters;

	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.databind;
	requires jakarta.validation;
	requires jakarta.ws.rs;
	requires jakarta.xml.bind;
	requires java.xml;
	requires org.slf4j;
}