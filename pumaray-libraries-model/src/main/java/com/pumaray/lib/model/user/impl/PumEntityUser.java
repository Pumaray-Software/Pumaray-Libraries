package com.pumaray.lib.model.user.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.pumaray.lib.model.impl.PumDefaultEntity;
import com.pumaray.lib.model.user.PumUser;

@MappedSuperclass
public class PumEntityUser extends PumDefaultEntity implements PumUser<Long> {

	private static final long serialVersionUID = -1807596501048051969L;
	
	private Date lastModified;
	private String name;
	private String alias;

	public PumEntityUser() {}

	@Override
	public String getBeanName() {
		return getClass().getSimpleName();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	@Column(name=NAME)
	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	@Override
	@Column(name=ALIAS)
	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	@Temporal(TemporalType.DATE)
	@Column(name=LAST_MODIFIED)
	public Date getLastModified() {
		return lastModified;
	}

	@Override
	public String toString() {
		return "PumEntityUser [lastModified=" + lastModified + ", name=" + name + ", alias=" + alias + "]";
	}
}
