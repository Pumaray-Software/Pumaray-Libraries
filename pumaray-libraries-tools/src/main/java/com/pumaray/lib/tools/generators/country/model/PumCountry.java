package com.pumaray.lib.tools.generators.country.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
public class PumCountry implements Serializable {

	private static final long serialVersionUID = 7003276192352449441L;

	@XmlAttribute(name = "name")
	private String name;

	@XmlAttribute(name = "code")
	private String code;

	@XmlElementWrapper(name = "cities")
	@XmlElement(name = "city")
	private Set<PumCity> cities = new HashSet<PumCity>();

	public PumCountry() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set<PumCity> getCities() {
		return cities;
	}

	public void setCities(Set<PumCity> cities) {
		this.cities = cities;
	}
}
