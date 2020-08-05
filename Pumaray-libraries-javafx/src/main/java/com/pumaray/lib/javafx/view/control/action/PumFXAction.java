package com.pumaray.lib.javafx.view.control.action;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.MenuItem;

/**
 * 
 * @author Pumaray Software
 *
 */
public interface PumFXAction extends PumAction, EventHandler<ActionEvent> {
	
	/**
	 * Register the ButtonBase with this action.
	 * 
	 * @param buttonBase	The Button base to register with this action
	 * @param showText		Display the text of this action on this button
	 * @param showImage	Display the Image of this action on this button
	 */
	public void register(ButtonBase buttonBase, boolean showText, boolean showImage);
	
	/**
	 * Register the MenuItem with this action.
	 * 
	 * @param MenuItem	The MenuItem to register with this action
	 * @param showText		Display the text of this action on this MenuItem
	 * @param showImage	Display the Image of this action on this MenuItem
	 */
	public void register(MenuItem menuItem, boolean showText, boolean showImage);
	
	public void fireActionEvent();
	
	public MenuItem generateItem();
	
	public ButtonBase generateButton();
	
	public ButtonBase generateButton( boolean showText, boolean showImage);
	
	public MenuItem generateItem( boolean showText, boolean showImage);
}
