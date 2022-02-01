package com.pumaray.lib.swing.validator.text;

import java.awt.Component;
import java.awt.Container;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

import com.pumaray.lib.swing.validator.tools.PumTextComponent;

public class SimpleTextInputValidator implements TextInputValidator{
	
	
	
	//private Color errorColor = new Color(255,219,228);
	//private Color succeedColor = Color.white;
	
	protected Hashtable<PumTextComponent, Boolean> table = new Hashtable<PumTextComponent, Boolean>();
	
	public SimpleTextInputValidator(Vector<JTextComponent> textComponents) {
		init(textComponents);
	}
	
	public SimpleTextInputValidator(Container container) {
		initContainer(container);
	}
	
	public SimpleTextInputValidator(Container[] containers) {
		for(Container c : containers) {
			initContainer(c);
		}
	}
	
	public SimpleTextInputValidator() {
		Vector<JTextComponent> textComponents = new Vector<JTextComponent>();
		init(textComponents);
	}
	
	private void initContainer(Container c) {
		try {
			Vector<JTextComponent> textCompsVector = new Vector<JTextComponent>();
			textCompsVector = populateVector(c, textCompsVector);
			init(textCompsVector);
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private Vector<JTextComponent> populateVector(Container c,
			Vector<JTextComponent> v) {
		Component[] comps = c.getComponents();
		for (Component comp : comps) {
			if (comp instanceof JTextComponent) {
				v.add((JTextComponent) comp);
			} 
			else if (comp instanceof JScrollPane) {
				populateVector(((JScrollPane) comp).getViewport(), v);
			} 
			else if (comp instanceof Container) {
				populateVector((Container) comp, v);
			}
		}
		return v;
	}
	
	private void init(Vector<JTextComponent> textComponents) {
		table = new Hashtable<PumTextComponent, Boolean>();
		for(JTextComponent textComponent : textComponents) {
			addSingleJTextComponent(textComponent);
		}
		
	}
	
	private void addSingleJTextComponent(JTextComponent textComponent) {
		try {
			PumTextComponent pumTextComponent = new PumTextComponent(textComponent);
			table.put(pumTextComponent, validate(pumTextComponent));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private boolean validateJFormattedField(PumTextComponent pumTextComponent) {
		boolean result = false;
		try {
			JFormattedTextField fField =  ((JFormattedTextField) pumTextComponent.getTextComponent());
			commitJFormattedField(pumTextComponent);
			result = fField.isEditValid();
			if(result) {
				pumTextComponent.isValid();
			}
			else {
				pumTextComponent.isNotValid();
			}
		}
		catch(Exception ex) {
			result = false ;
			pumTextComponent.isNotValid();
		}
		return result;
	}
	
	//Unproffesional resolve for a problem need to be reprogrammed
	private void commitJFormattedField(final PumTextComponent field) {
		SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						try {
							((JFormattedTextField) field.getTextComponent()).commitEdit();
						}
						catch(java.text.ParseException ex) {
							field.isNotValid();
						}
					}
				});
	}
	
	private boolean validateOtherJTextComponent(PumTextComponent pumTextComponent) {
		boolean result =  emptyPassed(pumTextComponent) && maxLengthPassed(pumTextComponent) &&
				minLengthPassed(pumTextComponent) && textMatchPassed(pumTextComponent);
		table.put(pumTextComponent, result);
		if(result) {
			pumTextComponent.isValid();
		}
		else {
			pumTextComponent.isNotValid();
			}
			return result;
	}
	
	public PumTextComponent getPumTextComponent(JTextComponent textComponent) {
		Enumeration<PumTextComponent> keys = table.keys();
		PumTextComponent temp;
		PumTextComponent found = null;
		while(keys.hasMoreElements()) {
			if((temp = keys.nextElement()).getTextComponent() == textComponent) {
				found = temp;
				break;
			}
		}
		if(found != null) {
			return found;
		}
		else {
			throw new NullPointerException("TextComponent with name " + textComponent.getName() + " not found");
		}
	}
	
	public void setMinLength(JTextComponent textComponent, int minLength) {
		getPumTextComponent(textComponent).setMinLength(minLength);
	}

	public void setMaxLength(JTextComponent textComponent, int maxLength) {
		getPumTextComponent(textComponent).setMaxLength(maxLength);
	}

	public void setMatcherText(JTextComponent textComponent, String matcher) {
		getPumTextComponent(textComponent).setValidString(matcher);
	}

	public boolean emptyPassed(PumTextComponent pumTextComponent) {
		if (pumTextComponent.getTextComponent().getText().length() != 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean minLengthPassed(PumTextComponent pumTextComponent) {
		boolean result = false;
		if(pumTextComponent.getMinLength() != null) {
			if(pumTextComponent.getTextComponent().getText().length() < pumTextComponent.getMinLength()) {
				result = false;
			}
			else {
				result = true;
			}
		}
		else {
			result = true;
		}
		return result;
	}

	public boolean maxLengthPassed(PumTextComponent pumTextComponent) {
		boolean result = false;
		if(pumTextComponent.getMaxLength() != null) {
			if(pumTextComponent.getTextComponent().getText().length() > pumTextComponent.getMaxLength()) {
				result = false;
			}
			else {
				result = true;
			}
		}
		else {
			result = true;
		}
		return result;
	}

	public boolean textMatchPassed(PumTextComponent pumTextComponent) {
		boolean result = false;
		if (pumTextComponent.getValidString() != null) {
			CharSequence seq = pumTextComponent.getTextComponent().getText();
			Pattern pattern = Pattern.compile(pumTextComponent.getValidString(),
					Pattern.CASE_INSENSITIVE);
			Matcher m = pattern.matcher(seq);
			result = m.matches();
			if(result) {
				return true;
			}
			else {
				return false;
			}
		} 
		else {
			return true;
		}
	}

	public boolean validate(PumTextComponent pumTextComponent) {
		boolean result;
		if(pumTextComponent.getTextComponent() instanceof JFormattedTextField) {
			result = validateJFormattedField(pumTextComponent);
		}
		else {
			result = validateOtherJTextComponent(pumTextComponent);
		}
		table.put(pumTextComponent, result);
		return result;
	}
	
	public void validate(JTextComponent textComponent) {
		validate(getPumTextComponent(textComponent));
	}

	public boolean validateAll() {
		Enumeration<PumTextComponent> allPumTextComponents = table.keys();
		PumTextComponent pumTextComponent;
		boolean result = true;
		while(allPumTextComponents.hasMoreElements()) {
			pumTextComponent = allPumTextComponents.nextElement();
			if(!validate(pumTextComponent)) {
				result = false;
				break;
			}
		}
		return result;
	}

	public boolean validate(){
		return false;
	}

	public void addJTextComponent(JTextComponent textComponent) {
		addSingleJTextComponent(textComponent);
	}
	
	public void removeSingleJTextComponent(JTextComponent textComponent) {
		try {
			PumTextComponent pumTextComponent = getPumTextComponent(textComponent);
			if(table.containsKey(pumTextComponent)) {
				table.remove(pumTextComponent);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean isAllTextComponentEmpty() {
		boolean result = false;
		Enumeration<PumTextComponent> all = table.keys();
		while(all.hasMoreElements()) {
			if(all.nextElement().getTextComponent().getText().trim().equals("")) {
				result = true;
				break;
			}
		}
		return result;
	}
}