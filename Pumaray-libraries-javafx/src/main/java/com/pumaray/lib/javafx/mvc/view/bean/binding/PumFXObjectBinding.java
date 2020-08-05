package com.pumaray.lib.javafx.mvc.view.bean.binding;

import java.text.Format;

import org.apache.log4j.Logger;

import com.pumaray.lib.model.PumBean;

import javafx.beans.binding.Bindings;
import javafx.beans.property.Property;
import javafx.beans.property.adapter.JavaBeanObjectProperty;
import javafx.beans.property.adapter.JavaBeanObjectPropertyBuilder;
import javafx.util.StringConverter;

public class PumFXObjectBinding<T extends PumBean> {

	private final static Logger logger = Logger.getLogger(PumFXObjectBinding.class);

	private Format formatter = null;
	private StringConverter converter = null;
	private T bean;
	private final String fieldName;
	private Property guiProperty;
	private JavaBeanObjectProperty<T> beanProperty;

	public PumFXObjectBinding(T bean, String fieldName, Property guiProperty) {
		this.guiProperty = guiProperty;
		this.bean = bean;
		this.fieldName = fieldName;

		createBeanProperty();

	}

	public PumFXObjectBinding(T bean, String fieldName, Property guiProperty, Format formatter) {
		this.guiProperty = guiProperty;
		this.bean = bean;
		this.fieldName = fieldName;
		this.formatter = formatter;

		createBeanProperty();
	}

	public PumFXObjectBinding(T bean, String fieldName, Property guiProperty, StringConverter converter) {
		this.guiProperty = guiProperty;
		this.bean = bean;
		this.fieldName = fieldName;
		this.converter = converter;

		createBeanProperty();
	}

	public T getBean() {
		return bean;
	}

	public void setBean(T bean) {
		this.bean = bean;
		createBeanProperty();
	}

	public String getFieldName() {
		return fieldName;
	}

	public Property getGuiProperty() {
		return guiProperty;
	}

	public void setGuiProperty(Property guiProperty) {
		this.guiProperty = guiProperty;
	}

	public Property getBeanProperty() {
		return beanProperty;
	}

	public void setBeanProperty(JavaBeanObjectProperty beanProperty) {
		this.beanProperty = beanProperty;
	}

	public void createBeanProperty() {
		try {
			if (beanProperty != null) {
				Bindings.unbindBidirectional(guiProperty, beanProperty);
			}
			beanProperty = JavaBeanObjectPropertyBuilder.create().bean(bean).name(fieldName).build();
			if (formatter != null) {
				Bindings.bindBidirectional(guiProperty, beanProperty, formatter);
			}
			else if (converter != null) {
				Bindings.bindBidirectional(guiProperty, beanProperty, converter);
			}
			else {
				Bindings.bindBidirectional(guiProperty, beanProperty);

			}
		}
		catch (Exception ex) {
			logger.error("", ex);
		}
	}

}
