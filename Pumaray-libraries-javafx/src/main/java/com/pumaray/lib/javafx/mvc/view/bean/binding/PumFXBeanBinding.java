package com.pumaray.lib.javafx.mvc.view.bean.binding;

import java.text.Format;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pumaray.lib.model.PumBean;

import javafx.beans.property.Property;
import javafx.beans.value.ObservableValue;
import javafx.util.StringConverter;

public class PumFXBeanBinding<T extends PumBean> implements PumBeanBinding<T> {

	private static final Logger logger = LoggerFactory.getLogger(PumFXBeanBinding.class);

	private T pumBean;
	private Map<ObservableValue, PumFXObjectBinding> bindings = new HashMap<ObservableValue, PumFXObjectBinding>();

	public PumFXBeanBinding(T pumBean) {
		this.pumBean = pumBean;
	}

	public void bind(String fieldName, Property guiProperty) {
		PumFXObjectBinding binding = new PumFXObjectBinding(pumBean, fieldName, guiProperty);
		bindings.put(guiProperty, binding);
		guiProperty.addListener(this);
		binding.getBeanProperty().addListener(this);

	}

	public void bind(String fieldName, Property guiProperty, Format formatter) {
		PumFXObjectBinding<T> binding = new PumFXObjectBinding<T>(pumBean, fieldName, guiProperty, formatter);
		bindings.put(guiProperty, binding);
		guiProperty.addListener(this);
		binding.getBeanProperty().addListener(this);

	}
	
	public void bind(String fieldName, Property guiProperty, StringConverter converter) {
		PumFXObjectBinding<T> binding = new PumFXObjectBinding<T>(pumBean, fieldName, guiProperty, converter);
		bindings.put(guiProperty, binding);
		guiProperty.addListener(this);
		binding.getBeanProperty().addListener(this);

	}
	
	public void update() {
		bindings.values().stream().forEach(b -> b.setBean(pumBean));
	}
	
	public void setPumBean(T bean) {
		this.pumBean = bean;
		update();
		// .forEach(b -> b.createBeanProperty(b.getFieldName()));

	}

	public T getPumBean() {
		return pumBean;
	}

	public Map<ObservableValue, PumFXObjectBinding> getBindings() {
		return bindings;
	}
	
	/*public void addListener(ChangeListener<? super T> listener) {
		bindings.values().stream().peek(binding -> binding.getBeanProperty().addListener(listener))
				.forEach(binding -> binding.getGuiProperty().addListener(listener));
	}

	public void removeListener(ChangeListener<? super T> listener) {
		bindings.values().stream().peek(binding -> binding.getBeanProperty().removeListener(listener))
				.forEach(binding -> binding.getGuiProperty().removeListener(listener));
	}*/

	@Override
	public void changed(ObservableValue observable, Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		
	}

}
