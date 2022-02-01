package com.pumaray.lib.utils.xml.adapters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Formatter for dateTime using the default ISO_DATE_TIME parameter
 * 
 * @author PumaSoft
 * 
 */
public class PumLocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

	private static final Logger log = LoggerFactory.getLogger(PumLocalDateTimeAdapter.class);

	private DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;

	@Override
	public LocalDateTime unmarshal(String asString) throws Exception {
		LocalDateTime date = null;
		try {
			date = LocalDateTime.parse(asString, formatter);
		}
		catch (Exception ex) {
			log.error("Error formatting " + asString, ex);
		}
		return date;
	}

	@Override
	public String marshal(LocalDateTime date) throws Exception {
		String asString = null;
		try {
			asString = formatter.format(date);
		}
		catch (Exception ex) {
			log.error("Error formatting " + asString, ex);
		}
		return asString;
	}

}
