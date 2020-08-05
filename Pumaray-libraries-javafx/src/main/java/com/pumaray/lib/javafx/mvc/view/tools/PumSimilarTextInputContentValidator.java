package com.pumaray.lib.javafx.mvc.view.tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pumaray.lib.tools.validator.PumValidator;

import javafx.beans.value.ChangeListener;
import javafx.scene.control.TextInputControl;

public class PumSimilarTextInputContentValidator implements PumValidator {

	private List<TextInputControl> inputControls = new ArrayList<TextInputControl>();
	private ChangeListener changeListener;

	public PumSimilarTextInputContentValidator(TextInputControl... controls) {
		inputControls = Arrays.asList(controls);
	}

	public PumSimilarTextInputContentValidator() {
	}

	public PumSimilarTextInputContentValidator(ChangeListener changeListener) {
		this.changeListener = changeListener;
	}

	public void add(TextInputControl control) {
		if (!inputControls.contains(control)) {
			if (changeListener != null) {
				control.textProperty().addListener(changeListener);
			}
			inputControls.add(control);
		}
	}

	public void addAll(TextInputControl... controls) {
		for (TextInputControl control : controls) {
			add(control);
		}
	}

	public boolean isValid() {
		final String content;
		boolean result = true;
		if (inputControls.size() > 0) {
			content = inputControls.get(0).getText();
			for (int i = 1; i < inputControls.size(); i++) {
				if (!inputControls.get(i).getText().equals(content)) {
					result = false;
					break;
				}
			}
		}
		return result;
	}

	@Override
	public void validate() {
	
	}
}
