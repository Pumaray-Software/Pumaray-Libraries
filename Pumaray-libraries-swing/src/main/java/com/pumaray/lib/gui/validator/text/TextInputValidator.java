package com.pumaray.lib.gui.validator.text;

import javax.swing.text.JTextComponent;

import com.pumaray.lib.gui.validator.InputValidator;
import com.pumaray.lib.gui.validator.tools.PumTextComponent;

public interface TextInputValidator extends InputValidator {

	public void setMinLength(JTextComponent textComponent, int minLength);
	public void setMaxLength(JTextComponent textComponent, int maxLength);
	public void setMatcherText(JTextComponent textComponent, String matcher);
	public PumTextComponent getPumTextComponent(JTextComponent component);
	public void addJTextComponent(JTextComponent textComponent);
	public boolean emptyPassed(PumTextComponent pumTextComponent);
	public boolean minLengthPassed(PumTextComponent pumTextComponent);
	public boolean maxLengthPassed(PumTextComponent pumTextComponent);
	public boolean textMatchPassed(PumTextComponent pumTextComponent);
	public boolean validate(PumTextComponent pumTextComponent);
	public boolean validateAll();
	public boolean isAllTextComponentEmpty();

}
