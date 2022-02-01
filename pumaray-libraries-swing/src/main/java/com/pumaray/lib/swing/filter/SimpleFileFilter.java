package com.pumaray.lib.swing.filter;

import java.io.File;
import java.util.ArrayList;

import javax.swing.filechooser.FileFilter;

/**
 * A simple filefilter
 * @author randy
 * @version 1.0
 *
 */
public class SimpleFileFilter extends FileFilter {
	
	private ArrayList<String> extentions = new ArrayList<String>();
	private String description;
	
	public SimpleFileFilter(String[] exts, String description) {
		this.description = description;
		populateArrayList(exts);
	}
	
	public SimpleFileFilter(ArrayList<String> exts,String description) { 
		this.description = description;
		this.extentions = exts;
	}
	
	private void populateArrayList(String [] exts) {
		extentions.clear();
		for(String s : exts) {
			extentions.add(s);
		}
	}

	public void addExtentions(String extention) {
		extentions.add(extention);
	}
	
	@Override
	public boolean accept(File file) {
		boolean result = false;
		if(file.isDirectory()) {
			result = true;
		}
		else {
			for(String e : extentions) {
				if(file.getName().endsWith(e)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
