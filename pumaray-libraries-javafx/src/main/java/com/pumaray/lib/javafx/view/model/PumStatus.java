package com.pumaray.lib.javafx.view.model;

import com.pumaray.lib.model.impl.PumDefaultBean;

public class PumStatus extends PumDefaultBean {
	
	public static final String STATUS ="status";
	public static final String OPERATION="operation";
	public static final String PROGRESS_VALUE = "progressValue";
	
	private String status="status";
	private String operation="operation";
	private Double progressValue=0.0;

	public PumStatus() {
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public Double getProgressValue() {
		return progressValue;
	}

	public void setProgressValue(Double progressValue) {
		this.progressValue = progressValue;
	}
}
