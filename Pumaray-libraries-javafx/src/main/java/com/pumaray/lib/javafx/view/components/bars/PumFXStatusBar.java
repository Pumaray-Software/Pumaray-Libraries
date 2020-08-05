package com.pumaray.lib.javafx.view.components.bars;

import java.util.Collection;

import com.pumaray.lib.javafx.mvc.view.bean.PumBeanListener;
import com.pumaray.lib.javafx.view.model.PumStatus;
import com.pumaray.lib.model.PumBean;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class PumFXStatusBar extends GridPane implements PumBeanListener<PumStatus> {
	
	private static PumFXStatusBar statusBar = null;
	
	private Label statusLabel = new Label();
	private Label operationLabel = new Label();
	private ProgressBar progressBar = new ProgressBar(0.0);
		
	public PumFXStatusBar(String id) {		
		setId(id);
			
		 ColumnConstraints column1 = new ColumnConstraints(100,100,Double.MAX_VALUE);
		 ColumnConstraints column2 = new ColumnConstraints(100,100,Double.MAX_VALUE);
		 ColumnConstraints column3 = new ColumnConstraints(100,100,Double.MAX_VALUE);
		 
		 column1.setHgrow(Priority.ALWAYS);
		 column2.setHgrow(Priority.ALWAYS);
		 column3.setHgrow(Priority.ALWAYS);
		 
		 column3.setHalignment(HPos.RIGHT);
		
		GridPane.setConstraints(statusLabel, 0,0);
		GridPane.setConstraints(operationLabel, 1,0);
		GridPane.setConstraints(progressBar, 2,0);
		//FlowPane pane = new FlowPane();
		
		//A/nchorPane.setRightAnchor(progressBar, 5.0);
		//AnchorPane.setLeftAnchor(pane, 5.0);
		//AnchorPane.setTopAnchor(progressBar, 5.0);
		//AnchorPane.setBottomAnchor(progressBar, 5.0);
		
		//pane.getChildren().addAll(statusLabel, operationLabel);
		
		getChildren().addAll(statusLabel,operationLabel, progressBar);
		getColumnConstraints().addAll(column1, column2, column3);
		
	}
	
	private static void init(String id) {
		if(statusBar == null) {
			statusBar = new PumFXStatusBar(id);
		}
	}
	
	public static PumFXStatusBar getInstance(String id) {
		init(id);
		return statusBar;
	}
	
	public static PumFXStatusBar getInstance() {
		if(statusBar == null) {
			throw new IllegalArgumentException("Status bar has not been initialize");
		}
		return statusBar;
	}

	public Label getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(Label statusLabel) {
		this.statusLabel = statusLabel;
	}

	public Label getOperationLabel() {
		return operationLabel;
	}

	public void setOperationLabel(Label operationLabel) {
		this.operationLabel = operationLabel;
	}

	public ProgressBar getProgressBar() {
		return progressBar;
	}

	public void setProgressBar(ProgressBar progressBar) {
		this.progressBar = progressBar;
	}

	@Override
	public String getUniqueKey() {
		return getId();
	}

	@Override
	public void setPumBean(PumStatus bean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PumStatus getPumBean() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPumBeans(Collection<PumStatus> beans) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<PumStatus> getPumBeans() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
