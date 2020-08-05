package com.pumaray.lib.javafx.view.control.action;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Pumaray Developer
 * 
 * This class provides default implementations for the Pumaray FX Action.
 * The developer need only subclass this abstract 
 * class and define the canDoAction and the doAction methods. 
 *
 */
public abstract class PumAbstractFXAction implements PumFXAction {
	
	/**
	 * The text to be display on this control
	 */
	protected String title;
	
	/**
	 * The tooltip to be display on this control
	 */
	protected String tooltip;
	
	/**
	 * The image to be display on this control
	 */
	protected Image image;
	
	/**
	 * The value that set if the action Registered componentd will be disable
	 */
	
	protected boolean disable = false;
	
	/**
	 * The List containing the buttonbase registered with this action.
	 */
	protected List<ButtonBase> buttons = new ArrayList<ButtonBase>();
	
	/**
	 * The List containing the MenuItems registered with this action.
	 */
	protected List<MenuItem> items = new ArrayList<MenuItem>();

	/**
	 * Create a specific PumFXAbstractAction
	 * @param title 		The text to ve displayed on this control.
	 * @param tooltip	The tooltip to be displayed on this control.
	 * @param image 	The image to be diplated on this control.
	 */
	public PumAbstractFXAction(String title, String tooltip,  Image image) {
		this.image = image;
		this.title = title;
		this.tooltip = tooltip;
	}
	
	/**
	 * Return the that the condition are met to execute this action.
	 * @return The condition (are met) for this action.
	 */
	public abstract boolean canDoAction();
	
	/**
	 * The action to be performed
	 */
	public abstract void action();
	
	
	public void fireActionEvent() {
		if(canDoAction()) {
			action();
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		fireActionEvent();
	}
	
	@Override
	public void register(ButtonBase buttonBase, boolean showText, boolean showImage) {
		buttonBase.setOnAction(this);
		buttonBase.setTooltip(new Tooltip(tooltip));
		if(showText) {
			buttonBase.setText(title);
		}
		else {
			buttonBase.setText("");
		}
		if(showImage) {
			ImageView tmp = new ImageView(image);
			tmp.setFitHeight(24.0);
			tmp.setFitWidth(24.0);
			buttonBase.setGraphic(tmp);
		}
		buttonBase.setDisable(disable);
		buttons.add(buttonBase);
	}
	
	@Override
	public void register(MenuItem item, boolean showText, boolean showImage) {
		item.setOnAction(this);
		if(showText) {
			item.setText(title);
		}
		if(showImage) {
			ImageView tmp = new ImageView(image);
			tmp.setFitHeight(24.0);
			tmp.setFitWidth(24.0);
			item.setGraphic(tmp);
		}
		item.setDisable(disable);
		items.add(item);
	}

	@Override
	public void enable() {
		buttons.stream().forEach(b -> b.setDisable(false));
		items.stream().forEach(b -> b.setDisable(false));
	}
	
	@Override
	public void disable() {
		buttons.stream().forEach(b -> b.setDisable(true));
		items.stream().forEach(b -> b.setDisable(true));
	}
	
	@Override
	public void setDisable(Boolean disable) {
		if(disable) {
			disable();
		}
		else {
			enable();
		}
	}
	
	@Override
	public MenuItem generateItem() {
		return generateItem(false, true);
	}
	
	@Override
	public ButtonBase generateButton() {
		return generateButton(true, true);
	}
	
	@Override
	public ButtonBase generateButton( boolean showText, boolean showImage) {
		Button button = new Button(title);
		register(button,showText, showImage);
		return button;
	}
	
	@Override
	public MenuItem generateItem( boolean showText, boolean showImage) {
		MenuItem item = new MenuItem(title);
		register(item,showText, showImage);
		return item;
	}
}
