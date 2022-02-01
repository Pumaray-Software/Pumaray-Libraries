package com.pumaray.lib.swing.filter;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PumSingleFileFilter extends FileFilter {
	
	private String name;
	private String description;
		
	public PumSingleFileFilter(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public boolean accept(File file) {
		if(file.isDirectory()) {
			return true;
		}
		else {
			return file.getName().equalsIgnoreCase(name) ;
		}
	}
	

	@Override
	public String getDescription() {
		return description;
	}

}
