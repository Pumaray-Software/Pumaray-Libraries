package com.pumaray.lib.swing.labels;

import java.awt.Font;

import javax.swing.JLabel;

public class TitleLabel extends JLabel {

	private Font font;
	
	public TitleLabel(){
		super();
		init();
	}
	
	public TitleLabel(String text) {
		super(text);
		init();
	}
	
	public TitleLabel(Font font) {
		super();
		this.font = font;
		init();
	}
	
	public TitleLabel(String text, Font font) {
		super(text);
		this.font = font;
		init();
	}
	
	private void init() {
		if(font == null) {
			font = getFont().deriveFont(15.0f);
		}
		setFont(font);
	}

}
