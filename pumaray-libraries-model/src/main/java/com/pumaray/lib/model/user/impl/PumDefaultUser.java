package com.pumaray.lib.model.user.impl;

import java.util.Date;
import java.util.Objects;

import com.pumaray.lib.model.impl.PumDefaultBean;
import com.pumaray.lib.model.user.PumUser;

public class PumDefaultUser extends PumDefaultBean implements PumUser {

	private static final long serialVersionUID = 363784280522170680L;
	
	private String uuid;
	private String name;
	private String alias;
	private Date lastModified;

	public PumDefaultUser() {
	}
	
	public PumDefaultUser(String name, String alias) {
		this.name = name;
		this.alias = alias;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alias, lastModified, name, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PumDefaultUser other = (PumDefaultUser) obj;
		return Objects.equals(alias, other.alias) && Objects.equals(lastModified, other.lastModified)
				&& Objects.equals(name, other.name) && Objects.equals(uuid, other.uuid);
	}

	@Override
	public String toString() {
		return "PumDefaultUser [uuid=" + uuid + ", name=" + name + ", alias=" + alias + ", lastModified=" + lastModified
				+ "]";
	}

	
}