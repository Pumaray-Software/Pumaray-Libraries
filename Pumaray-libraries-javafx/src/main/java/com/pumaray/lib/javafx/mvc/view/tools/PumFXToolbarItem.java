package com.pumaray.lib.javafx.mvc.view.tools;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PumFXToolbarItem extends Button {

	private EventHandler<ActionEvent> action;

	public PumFXToolbarItem(EventHandler<ActionEvent> action, Image image) {
		init(action,image);	
	}
	
	public PumFXToolbarItem(EventHandler<ActionEvent> action, Image image, String tooltip) {
		init(action,image);
		setTooltip(new Tooltip(tooltip));
	}
 

	private void init(EventHandler<ActionEvent> action, Image image) {
		this.action = action;

		ImageView icon = new ImageView(image);
		
		icon.setFitHeight(24);
		icon.setFitWidth(24);
		
		setOnAction(action);
		setGraphic(icon);
	}

	public EventHandler<ActionEvent> getAction() {
		return action;
	}

	public void setAction(EventHandler<ActionEvent> action) {
		this.action = action;
	}
}
