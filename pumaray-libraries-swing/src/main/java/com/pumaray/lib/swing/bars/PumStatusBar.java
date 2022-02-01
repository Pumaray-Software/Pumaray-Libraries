package com.pumaray.lib.swing.bars;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class PumStatusBar extends JPanel  {
	
	private JLabel nameLabel = new JLabel();
	private JLabel messageLabel = new JLabel();
	private JProgressBar progressBar = new JProgressBar();
	
	private final Color standardColor = nameLabel.getBackground();
	
	public PumStatusBar() {
		setLayout(new GridLayout(1,3));
		
		add(nameLabel);
		add(messageLabel);
		add(progressBar);
		
		Border border = new EtchedBorder();
		
		nameLabel.setBorder(border);
		messageLabel.setBorder(border);
		progressBar.setBorder(border);
		
		messageLabel.setOpaque(true);
		
		//nameLabel.setHorizontalAlignment(JLabel.CENTER);
		//messageLabel.setHorizontalAlignment(JLabel.CENTER);
		//progressBar.setHorizontalAlignment(JLabel.CENTER);
		
		//progressBar.setIndeterminate(true);
		progressBar.setStringPainted(true);
		
		PumStatus.init(this);
	}
	
	public void update(Operation operation) {
		nameLabel.setText(operation.getName());
		//nameLabel.setBackground(operation.getColor());
		messageLabel.setText(operation.getMessage());
		if(operation.getUrgency().equals(Operation.Urgency.HIGH)) {
			messageLabel.setBackground(operation.getColor());
		}
		else {
			messageLabel.setBackground(standardColor);
		}
		progressBar.setString("");
	}
	
	
	
	

}
