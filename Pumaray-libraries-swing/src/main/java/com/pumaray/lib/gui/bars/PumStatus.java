package com.pumaray.lib.gui.bars;

import java.awt.Color;


public class PumStatus {
	
	private static PumStatus status = null;

	private Operation operation;
	private PumStatusBar view;
	
	public PumStatus(PumStatusBar view) {
		this.view = view;
		operation = Operation.getStartedInstance();
		
		view.update(operation);
	}
	
	public PumStatus(PumStatusBar view, Operation operation) {
		this.view = view;
		this.operation = operation;
		
		view.update(operation);

	}
	
	public static void init(PumStatusBar view) {
		if(status == null) {
			status = new PumStatus(view);
		}
	}
	
	public static void init(PumStatusBar view, Operation operation) {
		if(status == null) {
			status = new PumStatus(view, operation);
		}
	}
	
	public static void setStatusOperation(Operation operation) {
		status.setOperation(operation);
	}
	
	public static void setStatusOperation(String name, String message, Color color, Operation.Urgency urgency) {
		Operation operation = new Operation(name,message,color, urgency);
		status.setOperation(operation);
	}
	
	public static void setStatusOperation(String name, String message, Color color) {
		Operation operation = new Operation(name,message,color);
		status.setOperation(operation);
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
		view.update(operation);
		
	}

	public PumStatusBar getView() {
		return view;
	}

}