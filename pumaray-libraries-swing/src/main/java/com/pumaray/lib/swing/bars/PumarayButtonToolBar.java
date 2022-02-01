package com.pumaray.lib.swing.bars;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.JToolBar;

/**
 * 
 * @author Pumaray Software
 * 
 * Create a simple Button JToolbar with {@link AbstractButton} with or without AbstractActions
 *
 */
public class PumarayButtonToolBar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5800804603858203836L;
	/**
	 * The vector of buttons to be add to this JToolBar
	 */
	public Vector<AbstractButton> buttons = new Vector<AbstractButton>();
	
	public PumarayButtonToolBar() {
		init();
	}
	
	/**
	 * Create a Pumaray ToolBar with the the vector of AbstractButton to be added.
	 * @param buttons 	The array of buttons to be added to this JToolBar
	 */
	public PumarayButtonToolBar(Vector<AbstractButton> buttons) {
		this.buttons = buttons;
		init();
	}
	
	/**
	 * Create a Pumaray ToolBar with the the Vector of AbstractButton and there AstractAction to be added.
	 * @param buttonsActions An hashtable of buttons and theirs actions.
	 */
	public PumarayButtonToolBar(Hashtable<AbstractButton, AbstractAction> buttonsActions) {
		initButtons(buttonsActions);
		init();
	}
	
	/**
	 * Inner method to add the AbstractButtons and theirs AbstractAction to the buttons vector
	 * @param buttonsActions The Hashtable of the AbstractButton and theirs actions
	 */
	private void initButtons(Hashtable<AbstractButton, AbstractAction> buttonsActions) {
		AbstractButton button = null;
		Enumeration<AbstractButton> abstractButtons = buttonsActions.keys();
		while(abstractButtons.hasMoreElements()) {
			button = abstractButtons.nextElement();
			button.setAction(buttonsActions.get(button));
			button.setText("");
			buttons.add(button);
		}
	}
	
	/**
	 * Inner method to add the AbstractButtons to this JToolbar and set the Floatable parameter to false
	 * so the JToolbar will not be floatable and will be fixed at the top.
	 */
	private void init() {
		setFloatable(false);
		for(AbstractButton b : buttons) {
			add(b);
		}
	}
	
	/**
	 * Add a new AbstractButton to this Pumaray ToolBar
	 * @param button The AbstractButton to be added to this Pumaray ToolBar.
	 */
	public void addAbstractButton(AbstractButton button) {
		buttons.add(button);
		add(button);
	}
	
	/**
	 * Remove this AbstractAction from this Pumaray ToolBar.
	 * @param button The button to be remove from this Pumaray ToolBar.
	 */
	public void removeAbstractButton(AbstractButton button) {
		buttons.remove(buttons);
		remove(button);
	}

}
