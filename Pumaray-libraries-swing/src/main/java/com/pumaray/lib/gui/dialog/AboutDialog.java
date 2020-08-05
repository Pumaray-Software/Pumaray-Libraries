package com.pumaray.lib.gui.dialog;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import com.pumaray.lib.gui.panels.ImagePanel;

public class AboutDialog extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3447005545480335412L;
	private static AboutDialog aboutDialog = null;
	private String programTitle;
	private String version;
	private String info;
	private JButton closeButton = new JButton("Close");
	
	private AboutDialog(String dialogTitle, ImageIcon programIcon,
			String programTitle, String version, String info,
			String companyName, ImageIcon companyIcon, JFrame parent) {
		super(parent);

		setTitle(dialogTitle);
		setLayout(null);
		setSize(500, 350);
		setResizable(false);

		this.programTitle = programTitle;
		this.version = version;
		this.info = info;
		ImagePanel programLogoPanel = new ImagePanel(programIcon.getImage());
		JEditorPane infoPanel = new JEditorPane();
		JLabel companyInfoLabel= new JLabel();
		programLogoPanel.setBorder(BorderFactory.createEtchedBorder());
		
		companyInfoLabel.setHorizontalAlignment(JLabel.CENTER);
		companyInfoLabel.setVerticalAlignment(JLabel.CENTER);
		programLogoPanel.setPreferredSize(new Dimension(200,350));
		infoPanel.setContentType("text/html");
		infoPanel.setText(getFormatedInfo());
		infoPanel.setEditable(false);
		infoPanel.setBorder(BorderFactory.createEtchedBorder());
	
		companyInfoLabel.setText(companyName);;
		Font f = companyInfoLabel.getFont();
		f = f.deriveFont(16.0f);
		companyInfoLabel.setFont(f);
		companyInfoLabel.setBorder(BorderFactory.createEtchedBorder());
		
		programLogoPanel.setBounds(0, 0, 200, 200);
		infoPanel.setBounds(200,0,300,200);
		companyInfoLabel.setBounds(0,200,500,70);
		closeButton.setBounds(200,280,100,40);
		
		add(programLogoPanel);
		add(infoPanel);
		add(companyInfoLabel);
		add(closeButton);
		
		closeButton.addActionListener(this);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
	}

	private String getFormatedInfo() {
		String result = "";
		result = result + "<h1>" + programTitle + "<h1>";
		result = result  + "version " + version ;
		result = result + "<p>" + info + "<p><br>";
		
		return result;
	}
	
	public static void init(String dialogTitle,
			ImageIcon programIcon, String programTitle, String version,
			String info, String companyName, ImageIcon companyIcon,
			JFrame parent) {
		if(aboutDialog ==  null) {
			aboutDialog = new AboutDialog(dialogTitle, programIcon,
					programTitle, version, info, companyName, companyIcon,
					parent);
		}
		
	}

	public static void showAboutDialog(String dialogTitle,
			ImageIcon programIcon, String programTitle, String version,
			String info, String companyName, ImageIcon companyIcon,
			JFrame parent) {
		if (aboutDialog == null) {
			aboutDialog = new AboutDialog(dialogTitle, programIcon,
					programTitle, version, info, companyName, companyIcon,
					parent);
		}
		aboutDialog.setVisible(true);
	}
	
	public static void showMe() {
		if(aboutDialog == null) {
			throw new NullPointerException();
		}
		else {
			aboutDialog.setVisible(true);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeButton) {
			aboutDialog.setVisible(false);
		}
	}
}
