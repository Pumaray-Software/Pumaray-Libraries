package com.pumaray.lib.swing.validator.text;

import java.awt.Container;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;

import com.pumaray.lib.swing.labels.MessageLabel;
import com.pumaray.lib.swing.validator.tools.PumTextComponent;

public class ActionControlledTextInputValidator extends SimpleTextInputValidator implements DocumentListener {

	private AbstractAction[] actions;
	private MessageLabel messageLabel;
	private Hashtable<Document, JTextComponent> documentHash = new Hashtable<Document, JTextComponent>();
	
	public ActionControlledTextInputValidator(Container container, AbstractAction[] actions, MessageLabel messageLabel) {
		super(container);
		init(actions, messageLabel);
	}
	
	public ActionControlledTextInputValidator(Container[] containers, AbstractAction[] actions, MessageLabel messageLabel) {
		super(containers);
		init(actions, messageLabel);
	}	
	
	public ActionControlledTextInputValidator(AbstractAction[] actions, MessageLabel message) {
		init(actions, messageLabel);
	}
	
	public ActionControlledTextInputValidator(Vector<JTextComponent> textComponents,AbstractAction[] actions, MessageLabel message) {
		super(textComponents);
		init(actions, messageLabel);
	}
	
	public void init(AbstractAction[] actions, MessageLabel messageLabel) {
		this.actions = actions;
		if(messageLabel == null) {
			messageLabel = new MessageLabel();
		}
		else {
			this.messageLabel = messageLabel;
		}
		Enumeration<PumTextComponent> pumTextComponents = super.table.keys();
		PumTextComponent pumTextComponent;
		while(pumTextComponents.hasMoreElements()) {
			pumTextComponent = pumTextComponents.nextElement();
			Document doc = pumTextComponent.getTextComponent().getDocument();
			doc.addDocumentListener(this);
			documentHash.put(doc, pumTextComponent.getTextComponent());
		}
	}
	
	public void checkButton() {
		setActionsEnabled(!super.table.contains(false));
	}
	
	public void setActionsEnabled(boolean enabled) {
		for(AbstractAction action : actions) {
			action.setEnabled(enabled);
		}
	}
	
	public void validateMe(DocumentEvent e) {
		super.validate(documentHash.get(e.getDocument()));
		checkButton();
		
	}
	
	@Override
	public boolean validateAll() {
		boolean result = super.validateAll();
		setActionsEnabled(result);
		return result;
	}
	
	@Override
	public void addJTextComponent(JTextComponent textComponent) {
		textComponent.getDocument().addDocumentListener(this);
		super.addJTextComponent(textComponent);
	}

	public void insertUpdate(DocumentEvent e) {
		validateMe(e);
	}

	public void removeUpdate(DocumentEvent e) {
		validateMe(e);
	}

	public void changedUpdate(DocumentEvent e) {
		validateMe(e);
	}
}
