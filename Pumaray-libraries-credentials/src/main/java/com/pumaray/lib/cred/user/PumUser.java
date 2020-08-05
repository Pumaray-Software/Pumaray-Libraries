package com.pumaray.lib.cred.user;

import java.time.LocalDateTime;
import java.util.Date;

import com.pumaray.lib.model.PumBean;

public interface PumUser<K> extends PumBean {

	public static final String ID = "id";
	public static final String NAME = "name";
	public static final String ALIAS = "alias";
	public static final String LAST_MODIFIED="lastModified";

	String getName();

	void setName(String name);

	String getAlias();

	void setAlias(String alias);

	LocalDateTime getLastModified();

	void setLastModified(LocalDateTime date);

}
