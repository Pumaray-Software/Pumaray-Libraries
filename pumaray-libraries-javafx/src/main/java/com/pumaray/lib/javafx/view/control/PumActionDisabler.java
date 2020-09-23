package com.pumaray.lib.javafx.view.control;

import com.pumaray.lib.javafx.view.control.action.PumAction;
import com.pumaray.lib.tools.validator.PumValidator;

public interface PumActionDisabler extends PumValidator {
	
	<T extends PumAction> void addAction(T action);
	
	void enableActions();
	
	void disableActions();
	
	void validate();

}
