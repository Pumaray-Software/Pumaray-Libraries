package com.pumaray.lib.swing.exceptions;

import javax.swing.text.JTextComponent;

public class NoNameException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4340725415496256632L;

	public NoNameException(JTextComponent component) {
		super(component.toString() + "has no name");
	}

}
