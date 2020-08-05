package com.pumaray.lib.cred.user.impl;

import java.time.LocalDateTime;

import com.pumaray.lib.cred.user.PumUser;
import com.pumaray.lib.model.impl.PumDefaultBean;

public class PumDefaultUser<K> extends PumDefaultBean implements PumUser<K> {

	private static final long serialVersionUID = 363784280522170680L;
	
	private K id;
	private String name;
	private String alias;
	private LocalDateTime lastModified;

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

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
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
