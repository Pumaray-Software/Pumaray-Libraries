package com.pumaray.lib.javafx.mvc.view.bean.binding;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pumaray.lib.javafx.view.components.PumPasswordField;
import com.pumaray.lib.model.PumBean;

import javafx.beans.property.Property;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputControl;
import jfxtras.labs.scene.control.BeanPathAdapter;

public class PumFXBeanPathBinding<T extends PumBean> {

	private static final Logger logger = LoggerFactory.getLogger(PumFXBeanPathBinding.class);

	private Map<Property, TextInputControl> controls = new HashMap<Property, TextInputControl>();

	private BeanPathAdapter<T> beanPathAdapter;

	public PumFXBeanPathBinding(T t) {
		beanPathAdapter = new BeanPathAdapter<T>(t);
	}
	
	public void bind(String fieldName, Label label) {
		beanPathAdapter.bindBidirectional(fieldName, label.textProperty());
		//controls.put(label.textProperty(), label);
	}

	public void bind(String fieldName, TextInputControl inputControl) {
		beanPathAdapter.bindBidirectional(fieldName, inputControl.textProperty());
		controls.put(inputControl.textProperty(), inputControl);
	}

	public void listenToChangesFor(TextInputControl control) {
		controls.put(control.textProperty(), null);
	}

	public void bindCharArray(String fieldName, PumPasswordField inputControl) {
		beanPathAdapter.bindBidirectional(fieldName, inputControl.charArrayProperty(), char[].class);
		controls.put(inputControl.textProperty(), inputControl);
		inputControl.textProperty().addListener(new ChangeListener<String>() {
			
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					final String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					PumBean bean = beanPathAdapter.getBean();
					Method method = beanPathAdapter.getBean().getClass().getDeclaredMethod(methodName, char[].class);
					method.invoke(bean, newValue.toCharArray());
					beanPathAdapter.setBean((T) bean);
				}
				catch (Exception ex) {
					logger.error("", ex);
				}
			}
	
		});
	}

	/*public void bindCharArray(String fieldName, PumPasswordField inputControl) {
		controls.put(inputControl.textProperty(), inputControl);
		inputControl.textProperty().addListener(new ChangeListener<String>() {
	
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					final String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					PumBean bean = beanPathAdapter.getBean();
					Method method = beanPathAdapter.getBean().getClass().getDeclaredMethod(methodName, char[].class);
					method.invoke(bean, newValue.toCharArray());
					beanPathAdapter.setBean((T) bean);
				}
				catch (Exception ex) {
					logger.error("", ex);
				}
			}
	
		});
		beanPathAdapter.
	}*/

	public BeanPathAdapter<T> getBeanPathAdapter() {
		return beanPathAdapter;
	}

	public void setBeanPathAdapter(BeanPathAdapter<T> beanPathAdapter) {
		this.beanPathAdapter = beanPathAdapter;
	}

	public Map<Property, TextInputControl> getControls() {
		return controls;
	}

}
