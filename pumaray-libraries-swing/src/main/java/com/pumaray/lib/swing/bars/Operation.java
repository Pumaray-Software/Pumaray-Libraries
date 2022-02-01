package com.pumaray.lib.swing.bars;

import java.awt.Color;

public class Operation {
	
	public static enum Urgency {LOW, HIGH} 
	private String name;
	private String message;
	private Color color;
	private Urgency urgency;
	
	public Operation(String name, String message, Color color) {
		this.name = name;
		this.message = message;
		this.color = color;
		this.urgency = Urgency.LOW;
	}
	
	public Operation(String name, String message, Color color, Urgency urgency) {
		this.name = name;
		this.message = message;
		this.color = color;
		this.setUrgency(urgency);
	}
	
	public static Operation getStartedInstance() {
		return new Operation("APPLICATION","STARTED", Color.GREEN.darker().darker() );
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Urgency getUrgency() {
		return urgency;
	}

	public void setUrgency(Urgency urgency) {
		this.urgency = urgency;
	}

}
