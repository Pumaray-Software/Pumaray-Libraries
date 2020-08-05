package com.pumaray.lib.javafx.view.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.pumaray.lib.javafx.view.control.action.PumAction;

public abstract class PumAbstractActionDisabler implements PumActionDisabler {

	List<PumAction> actions = new ArrayList<PumAction>();

	protected PumAbstractActionDisabler(PumAction... actionsArray) {
		actions = Arrays.asList(actionsArray);
	}

	@Override
	public <T extends PumAction> void addAction(T action) {
		actions.add(action);
	}

	@Override
	public void enableActions() {
		actions.stream().forEach(PumAction::enable);
	}

	@Override
	public void disableActions() {
		actions.stream().forEach(PumAction::disable);
	}
}
