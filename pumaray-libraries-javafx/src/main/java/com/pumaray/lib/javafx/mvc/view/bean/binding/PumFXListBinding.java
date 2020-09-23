package com.pumaray.lib.javafx.mvc.view.bean.binding;

import java.lang.reflect.Method;
import java.text.Format;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.adapter.JavaBeanObjectProperty;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.scene.Node;

public class PumFXListBinding<T> implements PumBinding<T> {

	private final static Logger logger = LoggerFactory.getLogger(PumFXListBinding.class);

	private List<PumFXBeanBinding> beanBindings;
	private T bean;
	private Format formatter = null;
	private String fieldName;
	private JavaBeanObjectProperty<T> beanProperty;
	private SimpleListProperty<? extends Node> guiListProperty;
	private Class type;

	public PumFXListBinding(T bean, String fieldName, Format formatter, Class type) {
		this.bean = bean;
		this.fieldName = fieldName;
		this.formatter = formatter;
		this.type = type;

		createBeanProperty();

	}

	private void createBeanProperty() {
		try {
			if (beanProperty != null) {
				Bindings.unbindBidirectional(guiListProperty, beanProperty);
			}
			beanProperty = JavaBeanObjectPropertyBuilder.create().bean(bean).name(fieldName).build();
			if (formatter == null) {
				String methodName = "get" + (fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
				Method method = bean.getClass().getDeclaredMethod(methodName);
				Collection coll = (Collection) method.invoke(bean);
				
			}
		}
		catch (Exception ex) {
			logger.error("Error in beanbinding", ex);
		}
	}

	@Override
	public void setValue(T v) {
		// TODO Auto-generated method stub

	}

	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
