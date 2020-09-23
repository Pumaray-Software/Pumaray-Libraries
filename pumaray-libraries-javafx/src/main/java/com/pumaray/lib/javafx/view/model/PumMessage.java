package com.pumaray.lib.javafx.view.model;

import java.awt.Color;

import com.pumaray.lib.model.impl.PumDefaultBean;

public class PumMessage extends PumDefaultBean {

	public final static String MESSAGE = "message";
	public final static String TYPE= "type";
	
	private String message;
	private Type type;

	public PumMessage(String message, Type type) {
		this.message = message;
		this.type = type;
	}

	public PumMessage() {
		this.message ="";
		this.type = Type.INFO;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}


	public enum Type {

		ERROR("ERROR", Color.RED),
		SUCCES("SUCCES", Color.green),
		WARNING("WARNING", Color.orange),
		INFO("INFORMATION", Color.blue);

		public static final String ERROR_MESSAGE = "ERROR";
		public static final String SUCCESS_MESSAGE = "SUCCES";
		public static final String WARNING_MESSAGE = "WARNING";

		private String messageType;
		private Color color;

		Type(String messageType, Color color) {
			this.setMessageType(messageType);
		}

		public String getMessageType() {
			return messageType;
		}

		public void setMessageType(String messageType) {
			this.messageType = messageType;
		}

		public Color getColor() {
			return color;
		}

		public void setColor(Color color) {
			this.color = color;
		}
	}
}
