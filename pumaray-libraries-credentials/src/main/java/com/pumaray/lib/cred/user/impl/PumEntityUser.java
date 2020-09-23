package com.pumaray.lib.cred.user.impl;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.pumaray.lib.cred.user.PumUser;
import com.pumaray.lib.model.impl.PumDefaultEntity;

@MappedSuperclass
public class PumEntityUser extends PumDefaultEntity implements PumUser<Long> {

	private static final long serialVersionUID = -1807596501048051969L;

	private LocalDateTime lastModified;
	private String name;
	private String alias;

	public PumEntityUser() {
	}

	protected PumEntityUser(LocalDateTime lastModified, String name, String alias) {
		this.lastModified = lastModified;
		this.name = name;
		this.alias = alias;
	}

	@Override
	public String getBeanName() {
		return getClass().getSimpleName();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	@Override
	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public LocalDateTime getLastModified() {
		return lastModified;
	}

	@Override
	public String toString() {
		return "PumEntityUser [lastModified=" + lastModified + ", name=" + name + ", alias=" + alias + "]";
	}
}
