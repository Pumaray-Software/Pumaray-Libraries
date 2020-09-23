package com.pumaray.lib.javafx.view.components;


import com.pumaray.lib.utils.format.ChatArrayStringConverter;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.PasswordField;

public class PumPasswordField extends PasswordField {

	private ObjectProperty<char[]> charArrayProperty;
	
	public PumPasswordField() {
		
		charArrayProperty = new SimpleObjectProperty<char[]>() {
			
			@Override
			public char[] get() {
				return textProperty().getValue().toCharArray();
			}
			
			@Override
			public void set(char[] value) {
				if(value == null || value.length==0) {
					value = "".toCharArray();
				}
				textProperty().set(new String(value));
			}
			
			@Override
			public String toString() {
				return "CharArrayProperty [bean: value: " + new String(get()) + "]";
			}
		};
		
		textProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				charArrayProperty.set(newValue.toCharArray());
			}
			
		});
	}
	
	public ObjectProperty<char[]> charArrayProperty() {
		return charArrayProperty;
	}
	
}
