package com.pumaray.lib.utils.xml.adapters;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class PumLongAdapter extends XmlAdapter<String, Long> {

	@Override
	public Long unmarshal(String v) throws Exception {
		return Long.parseLong(v);
	}

	@Override
	public String marshal(Long v) throws Exception {
		return Long.toString(v);
	}

}
