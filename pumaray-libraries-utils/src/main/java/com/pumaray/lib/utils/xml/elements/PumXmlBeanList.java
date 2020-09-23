package com.pumaray.lib.utils.xml.elements;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

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
