package com.pumaray.lib.gui.bars;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

/**
 * 
 * @author Pumaray Software
 * Standard Pumaray status bar. This status bar will create a status bar that will have 
 * a operation type, operation name, operation bar String
 */
public class PumarayStatusBar extends JPanel  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5201501825590246248L;

	/**
	 * Operation types 
	 */
	public enum OperationType {IDDLE, SAVING, LOADING, UPDATING, DELETING, SELECTING}
	
	/**
	 * Current operationType
	 */
	private OperationType operationType;
	
	/**
	 * Current operation name
	 */
	private String operationName;
	
	/**
	 * String displayed on the progressbar
	 */
	private String operationBarString;
	
	/**
	 * The progressbar displaying the current status of this operation
	 */
	private JProgressBar operationBar;
	
	/**
	 * The label displaying the current operation type
	 */
	private JLabel typeLabel;
	
	/**
	 * The label displaying the current operation name
	 */
	private JLabel nameLabel;
	
	/**
	 * Create a Pumaray status bar given:
	 * @param operationType 		The Type of this operation
	 * @param operationName		The Name of this operation
	 * @param operationBarString	The Text to be displayed on the progressBar
	 * 
	 */
	public PumarayStatusBar(OperationType operationType, String operationName, String operationBarString) {
		setLayout(new GridLayout());
		
		Border componentBorder = BorderFactory.createEtchedBorder();
		
		this.operationType = operationType;
		this.operationName = operationName;
		this.operationBarString = operationBarString;
		
		operationBar = new JProgressBar();
		typeLabel = new JLabel(operationType.toString().toLowerCase());
		nameLabel = new JLabel(operationName); 
		
		operationBar.setBorder(componentBorder);
		typeLabel.setBorder(componentBorder);
		nameLabel.setBorder(componentBorder);
		
		setBorder(componentBorder);
		
		add(typeLabel);
		add(nameLabel);
		add(operationBar);
	}

	/**
	 * return the current operation type
	 */
	public OperationType getOperationType() {
		return operationType;
	}

	/**
	 * Set the current Operation Type
	 * @param operationType
	 */
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
		typeLabel.setText(operationType.toString().toLowerCase());
	}

	/**
	 * 
	 * @return the current operation name
	 */
	public String getOperationName() {
		return operationName;
	}

	/**
	 * Set the current Operation name
	 * @param operationName the current operation name
	 */
	public void setOperationName(String operationName) {
		this.operationName = operationName;
		nameLabel.setText(operationName);
	}

	/**
	 * get the current operation bar string
	 * @return the current bar string
	 */
	public String getOperationBarString() {
		return operationBarString;
	}

	/**
	 * set the current operation bar string
	 * @param operationBarString The current operation progressbar string
	 */
	public void setOperationBarString(String operationBarString) {
		this.operationBarString = operationBarString;
		operationBar.setString(operationBarString);
	}
	
	/**
	 * Start a operation (process) this will activated the progressbar and will
	 * display that a current operation is in progress.
	 */
	public void startProgres() {
		operationBar.setIndeterminate(true);
	}
	
	/**
	 * Stop an activated operation (process), this will stop the progressbar and set the 
	 * Indeterminate value to false.
	 */
	public void stopProcess() {
		operationBar.setIndeterminate(false);
		setOperationBarString("ready");
	}
	
		

}
