package com.pumaray.lib.javafx.view.control;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pumaray.lib.javafx.mvc.view.tools.PumLayout;
import com.pumaray.lib.javafx.view.components.PumMessageView;
import com.pumaray.lib.javafx.view.control.action.PumFXAction;
import com.pumaray.lib.javafx.view.model.PumMessage;
import com.pumaray.lib.javafx.view.model.PumMessage.Type;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextInputControl;

public class PumFXSimpleControlActionDisabler extends PumAbstractActionDisabler implements ChangeListener {

	private static final Logger logger = LoggerFactory.getLogger(PumFXSimpleControlActionDisabler.class);
	
	private final String EVERYTHING = "[0-9a-zA-Z]{5,30}";
	private final String DEFAULT_ERROR_MESSAGE = "Cannot be null";

	private String failStyle = PumLayout.ERROR_STYLE;
	private String successStyle = PumLayout.SUCCESS_STYLE;

	private Map<TextInputControl, String[]> contents = new LinkedHashMap<TextInputControl, String[]>();
	private PumMessageView messageView;

	public PumFXSimpleControlActionDisabler(PumMessageView messageView, PumFXAction... actions) {
		super(actions);
		this.messageView = messageView;
	}

	public PumFXSimpleControlActionDisabler(PumMessageView messageView, Map<TextInputControl, String[]> contents,
			PumFXAction... actions) {
		super(actions);
		this.contents = contents;
		this.messageView = messageView;
		init();
	}

	private void init() {
		contents.keySet().stream().peek(t -> t.getStyleClass().add("error-text-backgroun"))
				.forEach(t -> t.textProperty().addListener(this));
	}

	private void setMessage(String message) {
		if (messageView != null) {
			((PumMessage) messageView.getPumBean()).setMessage(message);
			((PumMessage) messageView.getPumBean()).setType(Type.ERROR);
			messageView.updateView();
		}
	}

	public void addTextInputControl(TextInputControl control) {
		addTextInputControl(control, new String[] { EVERYTHING, DEFAULT_ERROR_MESSAGE });
	}

	public void addTextInputControl(TextInputControl control, String pattern) {
		addTextInputControl(control, new String[] { pattern, DEFAULT_ERROR_MESSAGE });
	}

	public void addTextInputControl(TextInputControl control, String[] params) {
		control.textProperty().addListener(this);
		contents.put(control, params);
		control.setStyle(failStyle);
	}

	@Override
	public void validate() {
		Boolean isvalid = true;
		// todo in lambda expression
		Iterator<TextInputControl> it = contents.keySet().iterator();
		while (it.hasNext()) {
			TextInputControl control = it.next();
			String[] params = contents.get(control);
			Pattern pattern = Pattern.compile(params[0]);
			String text = control.getText();
			if(text == null || text.length()==0) {
				text = "";
			}
			if (!pattern.matcher(text).matches()) {
				isvalid = false;
				setMessage(params[1]);
				if (!control.getStyle().equals(failStyle)) {
					control.setStyle(failStyle);
				}
				break;
			}
			else {
				if (!control.getStyle().equals(successStyle)) {
					control.setStyle(successStyle);
				}
			}
		}
		if (isvalid) {
			enableActions();
		}
		else {
			disableActions();
		}
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getFailStyle() {
		return failStyle;
	}

	public void setFailStyle(String failStyle) {
		this.failStyle = failStyle;
	}

	public String getSuccessStyle() {
		return successStyle;
	}

	public void setSuccessStyle(String successStyle) {
		this.successStyle = successStyle;
	}

	@Override
	public void changed(ObservableValue observable, Object oldValue, Object newValue) {
		validate();
	}

}
