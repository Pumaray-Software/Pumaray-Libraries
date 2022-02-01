package com.pumaray.lib.swing.inputverifiers;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.text.JTextComponent;

import com.pumaray.lib.swing.exceptions.NoNameException;
import com.pumaray.lib.swing.labels.MessageLabel;

/**
 * 
 * @author Pumaray
 * A simple verifier that check if the JTextComponents in the components vector are empty
 */
public class SimpleNotEmptyVerifier extends InputVerifier implements KeyListener{
	
	/**
	 * A messageLabel that will display the errors in a popup dialog
	 */
	private MessageLabel messageLabel;
	
	/**
	 * A vector of component that containt the JTextComponent to be check
	 */
	private Vector<JTextComponent> components;
	
	/**
	 * A Hashtable that will contain the components to be checked and a boolean to specified if they
	 * are empty or not.
	 */
	private Hashtable<JTextComponent, Boolean> hashtable = new Hashtable<JTextComponent, Boolean>();
	
	/**
	 * A poppup dialog that will display the error if a component is has not pass verification.
	 */
	private JDialog popup;
	
	/**
	 * The buttons that must be activated or deactivated if the JTextField did not pass this
	 * verification;
	 */
	private AbstractButton[] buttons;
	
	/**
	 * Create a SimpleNotEmptyVerifier that must check the components in the components vector.
	 * @param components	The vector containing the JTextComponent to be checked.
	 */
	public SimpleNotEmptyVerifier(Vector<JTextComponent> components) {
		init(components);
		buttons = new AbstractButton[0];
		
	}
	
	/**
	 * Create a SimpleNotEmptyVerifier that must check the components in the components vector.
	 * and manage if the {@link} AbstractButton in the buttons array.
	 * @param components	The vector containing the JTextComponent to be checked.
	 * @param buttons		The buttons that must be manage by this verifier.
	 */
	public SimpleNotEmptyVerifier(Vector<JTextComponent> components, AbstractButton[] buttons) {
		this.buttons = buttons;
		init(components);
	}
	
	/**
	 * Inner method to create a messageLabel and initiate the poppup dialog and populate the Hashtable 
	 * with the components from the component vector.
	 * @param components The component containing the JTextComponent to be checked
	 */
	private void init(Vector<JTextComponent> components) {
		this.components = components;
		messageLabel = new MessageLabel();
		
		initDialog();
		populateHashtable();
	}
	
	/**
	 * Inner method the create and specified the decoration for the popup dialog.
	 */
	private void initDialog() {
		popup = new JDialog();
		popup.getContentPane().setLayout(new FlowLayout());
        popup.setUndecorated(true);
        popup.getContentPane().setBackground(Color.yellow);
        //popup.getContentPane().add(image);
        popup.getContentPane().add(messageLabel);
        popup.setFocusableWindowState(false);
        popup.setModalityType(ModalityType.MODELESS);
        popup.add(messageLabel);
	}
	
	/**
	 * Inner method that will set enable of the buttons false if there is any JTextComponent that
	 * did not pass this verification.
	 */
	private void checkButtons() {
		boolean enabled = false;
		if(hashtable.contains(false)) {
			enabled = false;
		}
		else {
			enabled = true;
		}
		for(AbstractButton b : buttons) {
				b.setEnabled(enabled);
		}
	}
	
	/**
	 * Inner method to populate the hashtable with the component of the component vector.
	 */
	private void populateHashtable() {
		try {
			for(JTextComponent component : components) {
				if(component.getName() != null && !component.getName().trim().equals("")) {
					component.setInputVerifier(this);
					hashtable.put(component, false);		
				}
				else {
					System.out.println("NO name is thrown");
					throw new NoNameException(component);
				}
			}
			checkButtons();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Inner method to display the popup dialog in case the specification specify for this JTextcomponent
	 * do not pass.
	 * @param comp		The component that has failed the verification
	 * @param message	The message to be displayed when the verification failed.
	 */
	private void displayPopup(JTextComponent comp, String message) {
		 popup.setSize(0, 0);
         popup.setLocationRelativeTo(comp);
         Point point = popup.getLocation();
         Dimension cDim = comp.getSize();
         popup.setLocation(point.x-(int)cDim.getWidth()/2,
             point.y+(int)cDim.getHeight()/2);
         popup.pack();
         popup.setVisible(true);
	}

	/**
	 * Default overrided method of the class InputVerification. This method test if a JTextComponet
	 * text is empty.
	 */
	public boolean verify(JComponent textField) {
		JTextComponent comp = (JTextComponent) textField;
		comp.addKeyListener(this);
		boolean pass = !comp.getText().trim().equals("");
		if(!pass) {
			messageLabel.displayError("The field " + comp.getName() +  " cannot be empty");
			displayPopup(comp, "Hallo ");
			hashtable.put(comp, false);
		}
		else {
			messageLabel.displayInfo("Succesfully filled field " + comp.getName() + " please continued or press save");
			hashtable.put(comp, true);
		}
		checkButtons();
		return pass;
	}

	public void keyPressed(KeyEvent arg0) {
		popup.setVisible(false);
		
	}
	
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

