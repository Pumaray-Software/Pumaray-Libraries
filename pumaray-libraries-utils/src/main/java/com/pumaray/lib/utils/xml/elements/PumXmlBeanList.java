package com.pumaray.lib.utils.xml.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAnyElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PumXmlBeanList implements Serializable {

	private static final long serialVersionUID = 7098267003954484191L;

	@XmlElementWrapper
	@XmlAnyElement(lax=true)
	private List models = new ArrayList();

	public PumXmlBeanList() {
	}

	public PumXmlBeanList(List models) {
		this.models = models;
	}

	public List getModels() {
		return models;
	}

	public void setModels(List models) {
		this.models = models;
	}
}
