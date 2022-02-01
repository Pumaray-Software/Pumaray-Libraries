package com.pumaray.lib.swing.panels;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6990082227462631842L;
	private Image image;
	
	public ImagePanel(Image image) {
		this.image = image;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 5, 5, getWidth()-10, getHeight()-10, null);
	}

}
