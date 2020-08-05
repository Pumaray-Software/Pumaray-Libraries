package com.pumaray.lib.model.user.impl;

import java.util.Date;

import com.pumaray.lib.model.impl.PumDefaultBean;
import com.pumaray.lib.model.user.PumUser;

public class PumDefaultUser<K> extends PumDefaultBean implements PumUser<K> {

	private static final long serialVersionUID = 363784280522170680L;
	
	private K id;
	private String name;
	private String alias;
	private Date lastModified;

	public PumDefaultUser() {
	}
	
	public PumDefaultUser(String name, String alias) {
		this.name = name;
		this.alias = alias;
	}

	public K getId() {
		return id;
	}

	public void setId(K id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		return "PumDefaultUser [id=" + id + ", name=" + name + ", alias=" + alias + ", lastModified=" + lastModified
				+ "]";
	}
}
