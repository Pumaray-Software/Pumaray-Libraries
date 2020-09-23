package com.pumaray.lib.javafx.mvc.view.bean;

import java.util.Collection;

import com.pumaray.lib.javafx.mvc.view.PumRegisterable;
import com.pumaray.lib.model.PumBean;

public interface PumBeanListener<E extends PumBean> extends PumRegisterable {
	
	void setPumBean(E bean);
	
	E getPumBean();
	
	void setPumBeans(Collection<E> beans);
	
	Collection<E> getPumBeans();
	
	public Class<? extends PumBean> getBeanToListenTo();
	
	public void update();
}
