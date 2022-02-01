package com.pumaray.lib.swing.labels;

import java.awt.Color;

import javax.swing.JLabel;

/**
 * 
 * @author Pumaray
 *	Message Label is a class that extends JLabel and is designed to display error and warning
 *	in different colors
 *
 */
public class MessageLabel extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -933925106176339870L;

	/**
	 * The warning color default is orange
	 */
	private Color warning;
	
	/**
	 * The error color default is red
	 */
	private Color error;
	
	/**
	 * The succeed color default is green
	 */
	private Color succeed;
	
	/**
	 * The Info color default is blue
	 */
	private Color info;

	/**
	 * Create a message label with the default colors
	 */
	public MessageLabel() {
		init();
	}
	
	/**
	 * Create a message label with the following parameters de message will be display as if
	 *  it was a info with the color you specified for info.
	 * @param message 	The message to start displaying in the info format.
	 * @param warning	The color for a warning message.
	 * @param error		The color for a error message.
	 * @param succeed	The color for a succeed message.
	 * @param info		THe color for a info message.
	 */
	public MessageLabel(String message, Color warning, Color error, Color succeed, Color info) {
		this.warning = warning;
		this.succeed  = succeed;
		this.error = error;
		displayInfo(message.toUpperCase());
	}
	
	/**
	 * Create a message label with the default color parameters the message will be display as if
	 *  it was a info with the color you specified for info.
	 * @param message	The start message that will be displayed.
	 */
	public MessageLabel(String message) {
		init();
		displayInfo(message.toUpperCase());
		//setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	/**
	 * The inner class init specified the default color for the message Label.
	 */
	private void init() {
		warning = Color.orange;
		succeed = Color.green;
		info = Color.blue;
		error = Color.red;
	}
	
	/**
	 * This will display the given message as a error with the foreground color specified by the error
	 * color parameter default is red.
	 * @param message The error message to be display
	 */
	public void displayError(String message) {
		setForeground(error);
		setText(message.toUpperCase());
	}
	
	/**
	 * This will display the given message as a warning with the foreground color specified by the warning
	 * color parameter default is orange.
	 * @param message The warning message to be display
	 */
	public void displayWarning(String message) {
		setForeground(warning);
		setText(message.toUpperCase());
	}
	
	/**
	 * This will display the given message as a info with the foreground color specified by the info
	 * color parameter default is blue.
	 * @param message The info message to be display
	 */
	public void displayInfo(String message) {
		setForeground(info);
		setText(message.toUpperCase());
	}
	
	/**
	 * This will display the given message as a succeed with the foreground color specified by the succeed
	 * color parameter default is green.
	 * @param message The succeed message to be display
	 */
	public void displaySucceed(String message) {
		setForeground(succeed);
		setText(message.toUpperCase());
	}

}
