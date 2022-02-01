package com.pumaray.lib.swing.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.pumaray.lib.swing.dialog.tools.Range;

public class FontDialog extends JDialog implements ActionListener,ListSelectionListener  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8914357608241539209L;

	public enum Type { SYSTEM, JAVA};
	public enum FontStyle {ITALIC, BOLD, NORMAL};
	
	private Type type = Type.SYSTEM;
	public static FontDialog fontDialog = null;
	private Font[] fonts;
	private Range range;
	private JList<String> nameList = new JList<String>();
	private JList<Integer> sizeList = new JList<Integer>();
	private JList<FontStyle> styleList = new JList<FontStyle>();
	private JLabel fontLabel = new JLabel("Selected Font");
	
	public void FontDialog(Type type, Range range){
		setSize(600,450);
		setLayout(new BorderLayout());
		init();
		populateLists();
		
		layoutManager();
	}
	
	private void layoutManager() {
		JPanel listPanel = new JPanel();
		JPanel fontDisplayPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.X_AXIS));
		fontDisplayPanel.setLayout(new BorderLayout());
		buttonPanel.setLayout(new FlowLayout());
		
		listPanel.add(nameList);
		listPanel.add(styleList);
		listPanel.add(sizeList);
		
		//fontDisplayPanel
	}
	
	private void init() {
		switch(type) {
		case SYSTEM: createSystemFonts(); break;
		case JAVA: 	createJavaFonts(); break;
		}
	}
	
	private void createSystemFonts() {
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    fonts = e.getAllFonts();
	}
	
	private void createJavaFonts() {
		fonts = new Font[5];
		fonts[0] = new Font("Dialog", Font.PLAIN, 12);
		fonts[1] = new Font("DialogInput", Font.PLAIN, 12);
		fonts[2] = new Font("Monospaced", Font.PLAIN, 12);
		fonts[3] = new Font("Serif", Font.PLAIN, 12);
		fonts[4] = new Font("SansSerif", Font.PLAIN, 12);	
	}
	
	private void populateLists() {
		int [] sizes = range.getNumbers();
		FontStyle[] styles = FontStyle.values();
		for(Font f : fonts) {
			((DefaultListModel<String>) nameList.getModel()).addElement(f.getName());
		}
		for(int s : sizes) {
			((DefaultListModel<Integer>) sizeList.getModel()).addElement(s);
		}
		for(FontStyle st : styles) {
			((DefaultListModel<FontStyle>) styleList.getModel()).addElement(st);
		}
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
