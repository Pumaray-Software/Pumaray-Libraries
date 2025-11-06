package com.pumaray.lib.model.user;

import java.util.Date;

import com.pumaray.lib.model.PumBean;

public interface PumUser extends PumBean {

	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String ALIAS = "alias";
	public static final String LAST_MODIFIED="lastModified";

	String getName();

	void setName(String name);

	String getAlias();

	void setAlias(String alias);

	Date getLastModified();

	void setLastModified(Date date);

}
