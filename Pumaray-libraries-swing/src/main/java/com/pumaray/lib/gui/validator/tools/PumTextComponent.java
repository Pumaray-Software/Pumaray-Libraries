package com.pumaray.lib.gui.validator.tools;

import java.awt.Color;

import javax.swing.text.JTextComponent;

import com.pumaray.lib.gui.exceptions.NoNameException;

public class PumTextComponent  {
	
	public final static Color NOT_VALID_COLOR = new Color(255,219,228);
	public final static Color VALID_COLOR = new Color(255,255,255);
	
	private final String tooltip;
	private Integer minLength;
	private Integer maxLength;
	private String validString;
	private JTextComponent textComponent;
	
	public PumTextComponent(JTextComponent textComponent) throws NoNameException {
		this.textComponent = textComponent;
		tooltip = toolTipManager(textComponent.getToolTipText());
		textComponent.setBackground(NOT_VALID_COLOR);
		if(textComponent.getName() == null) {
			throw new NoNameException(textComponent);
		}
	}
	
	public JTextComponent getTextComponent() {
		return textComponent;
	}

	public String toolTipManager(String toolTip) {
		String result = "";
		if(toolTip == null) {
			result = textComponent.getName();
		}
		else {
			result = toolTip;
		}
		return result;
	}
	
	public void isValid() {
		textComponent.setBackground(VALID_COLOR);
		textComponent.setToolTipText(tooltip);
	}
	
	public void isNotValid(){
		//if(textComponent instanceof JEditorPane) {
			//((JEditorPane) textComponent).get
		//}
		textComponent.setBackground(NOT_VALID_COLOR);
		textComponent.setToolTipText(tooltip + " (Invalid input)");
	}
	
	public Integer getMinLength() {
		return minLength;
	}

	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}

	public Integer getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}

	public String getValidString() {
		return validString;
	}

	public void setValidString(String validString) {
		this.validString = validString;
	}
	
	public String getTooltip() {
		return tooltip;
	}

	@Override
	public String toString() {
		return "JTextComponent " + textComponent.getName();
	} 
}
