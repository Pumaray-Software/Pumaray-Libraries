package com.pumaray.lib.model;

import java.io.Serializable;

import com.pumaray.lib.model.app.PumVersion;

public interface PumBean extends Serializable{
	
	String getBeanName();
	void setBeanName(String beanName);
	
	PumVersion getBeanVersion();
	void setBeanVersion(PumVersion version);
	
	
	boolean isValid();

}
