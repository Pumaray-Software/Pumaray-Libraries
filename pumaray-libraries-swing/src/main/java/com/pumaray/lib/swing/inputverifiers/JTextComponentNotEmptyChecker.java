package com.pumaray.lib.swing.inputverifiers;

import java.awt.Component;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import com.pumaray.lib.swing.exceptions.NoNameException;

/**
 * Class that create a not empty verfier that will check that every JTextComponent that 
 * register itself with this class does not contain an empty String
 * @author Pumaray Software
 * @version 3.1.2
 *
 */
public class JTextComponentNotEmptyChecker implements DocumentListener{
	
	/**
	 * The Hashtable containing the Document (JTextComponent document) and the boolean which
	 * is if this component has a empty String or not
	 */
	private Hashtable<Document, Boolean> hashtable = new Hashtable<Document, Boolean>();
	
	/**
	 * The Vector of JTextComponents which will be checked if they contain a empty String
	 */
	private Vector<JTextComponent> components;
	
	/**
	 * The Abstract action that will be activated or deactivated if the registered JTextComponent 
	 * contains a empty String or no
	 */
	private AbstractAction[] actions;
	
	/**
	 * Create an JTextComponentNotEmptyChecker with a vector of JTextComponent and an empty
	 * AbstractAction array
	 * @param components The JTextComponent that will be registered with this JTextComponentNotEmptyChecker
	 */
	public JTextComponentNotEmptyChecker(Vector<JTextComponent> components) {
		actions = new AbstractAction[0];
		init(components);
	}
	
	/**
	 * Create an JTextComponentNotEmptyChecker for a JComponent and an array of AbstractActions
	 * @param container The JComponent containing the JTextComponent that will ne register with this JTextComponentNotEmptyChecker
	 * @param actions 	an array of Abstract Action that will be actived or deactivated;
	 */
	public JTextComponentNotEmptyChecker(JComponent container, AbstractAction[] actions) {
		this.actions = actions;
		components =new Vector<JTextComponent>();
		getAllTextComponents(container);
		init(components);
	}
	
	/**
	 * Create an JTextComponentNotEmptyChecker with an Vector of JTextComponent and an array of 
	 * AbstractActions
	 * @param components	The JTextComponent that will be registered with this JTextComponentNotEmptyChecker
	 * @param actions		An array of Abstract Action that will be actived or deactivated
	 */
	public JTextComponentNotEmptyChecker(Vector<JTextComponent> components, AbstractAction[] actions) {
		this.actions = actions;
		init(components);
	}
	
	/**
	 * Private method that will initialize the Hashtable
	 * @param components The JtextComponent that will populate the hashtable
	 */
	private void init(Vector<JTextComponent> components) {
		this.components = components;
		
		populateHashtable();
	}
	
	/**
	 * Update The buttons of this verifier
	 */
	public void update() {
		populateHashtable();
	}
	
	/**
	 * This method will getAll the JTextComponents of a JComponent and store them in the components
	 * vector
	 * @param panel The JComponent containing the to be registered JTextComponents
	 */
	private void getAllTextComponents(JComponent panel) {
		Component[] componentss = panel.getComponents();
		for(Component c : componentss) {
			if(c instanceof JPanel) {
				getAllTextComponents((JPanel) c);
			}
			else if(c instanceof JScrollPane) {
				getTextContentFromScrollPane((JScrollPane) c);
			}
			else if(c instanceof JTextComponent) {
				components.add((JTextComponent) c);
			}
		}
	}
	
	/**
	 * This method will help the getAllTextComponents method if the JComponent is a JScrollPane
	 * @param scroll
	 */
	public void getTextContentFromScrollPane(JScrollPane scroll) {
		Component[] componentss = scroll.getViewport().getComponents();
		for (Component c : componentss) {
			if(c instanceof JPanel) {
				getAllTextComponents((JPanel) c);
			}
			else if(c instanceof JScrollPane) {
				getTextContentFromScrollPane((JScrollPane) c);
			}
			else if(c instanceof JTextComponent) {
				components.add((JTextComponent) c);
			}
		}
	}
	
	/**
	 * private method that will populate the Hashtable with the JTextComponent and the boolean of
	 * if this JTextComponent contains an empty String or not.
	 * This method also add an documentListener to the JTextComponent to check if the content
	 * has been modified
	 */
	private void populateHashtable() {
		hashtable.clear();
		for(JTextComponent component : components) {
			try {
				if(component.getName() != null && !component.getName().equals("")) {
					component.getDocument().addDocumentListener(this);
					String content = component.getDocument().getText(0, component.getDocument().getLength());
					if(!content.trim().equals("")) {
						hashtable.put(component.getDocument(), true);
					}
					else {
						hashtable.put(component.getDocument(), false);
					}
				}
				else {
					throw new NoNameException(component);
				}
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		checkButtons();
	}
	
	/**
	 * This method activate or deactivate the registered abstract actions if the JTextComponent
	 * registered in the JTextComponentNotEmptyChecker contains an empty String
	 */
	private void checkButtons() {
		boolean enabled = false;
		if(hashtable.contains(false)) {
			enabled = false;
		}
		else {
			enabled = true;
		}
		for(AbstractAction a : actions) {
			a.setEnabled(enabled);
		}
	}
	
	/**
	 * This method will check if the JTextComponent registered with this SimpleTextComponent has
	 * been updated and will change the status of the abstract actions accordantly
	 * @param ed The documentListener that will be checked
	 */
	private void controleField(DocumentEvent ed)  {
		try {
			Document document =  ed.getDocument();
			String content = document.getText(0, document.getLength());
			if(content.trim().equals("")) {
				hashtable.put(document, false);
			}
			else {
				hashtable.put(document, true);
			}
			checkButtons();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Standard class of the DocumentListener Interface to check of element has been updated
	 * in e Document
	 */
	public void changedUpdate(DocumentEvent ed) {
		controleField(ed);
	}

	/**
	 *  Standard class of the DocumentListener Interface to check of element has been inserted
	 * in e Document
	 */
	public void insertUpdate(DocumentEvent ed) {
		controleField(ed);
	}

	/**
	 *  Standard class of the DocumentListener Interface to check of element has been removed
	 * in e Document
	 */
	public void removeUpdate(DocumentEvent ed) {
		controleField(ed);
	}

}
