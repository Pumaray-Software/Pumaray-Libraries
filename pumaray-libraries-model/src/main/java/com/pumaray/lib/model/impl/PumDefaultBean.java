package com.pumaray.lib.model.impl;

import com.pumaray.lib.model.PumBean;
import com.pumaray.lib.model.app.PumVersion;

public class PumDefaultBean implements PumBean {

	private static final long serialVersionUID = -6731743363705277374L;
	public static final String BEAN_NAME = "beanName";
	public static final String BEAN_VERSION = "beanVersion";

	private String beanName;
	private PumVersion beanVersion;

	public PumDefaultBean() {
		beanName = this.getClass().getSimpleName();
	}

	@Override
	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public void setBeanVersion(PumVersion beanVersion) {
		this.beanVersion = beanVersion;
	}

	@Override
	public PumVersion getBeanVersion() {
		return beanVersion;
	}

	@Override
	public String toString() {
		return "PumDefaultBean [beanName=" + beanName + ", beanVersion=" + beanVersion + "]";
	}

	/*
	 * TODO
	this must be implememted correctly bo mester pone ku e ta wak ku tur e kosnan ta jena prome
	bo declare komo valido
	
	*/
	@Override
	public boolean isValid() {
		return (true);

	}
	
	@Override
	public boolean isEqualsTo(PumBean other) {
		return true;
	}
}
