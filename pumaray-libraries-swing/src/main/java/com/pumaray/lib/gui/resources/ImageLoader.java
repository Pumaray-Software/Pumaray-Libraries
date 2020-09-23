package com.pumaray.lib.gui.resources;

import java.awt.Image;
import java.net.URL;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.ImageIcon;


public class ImageLoader {
	
	private static ImageLoader resourceLoader;
	private Vector<String> iconsNames = new Vector<String>();
	private Hashtable<String, ImageIcon> images = new Hashtable<String, ImageIcon>();
	private URL introductionUrl;
	private String path;
	
	
	public ImageLoader(String path) {
		this.path = path;
		loadImages(path);
		//loadIntroductionUrl();
	}
	
	public static ImageLoader getInstance(String path) {
		if(resourceLoader == null) {
			resourceLoader = new ImageLoader(path);
		}
		return resourceLoader;
	}
	
	public static ImageLoader getInstance() {
		if(resourceLoader == null ) {
			throw new NullPointerException();
		}
		else {
			return resourceLoader;
		}
	}
	
	private void loadImages(String path) {
		String fileName;
		URL fileUrl;
		for(int i =0; i<iconsNames.size(); i++) {
			fileName = iconsNames.elementAt(i);
			fileUrl = getClass().getClassLoader().getResource(path + "/" + fileName);
			ImageIcon icon = new ImageIcon(fileUrl);
			images.put(fileName.substring(0, fileName.indexOf('.')), icon);
		}
	}
	
	private void loadName(String name) {
		URL fileUrl = getClass().getClassLoader().getResource(path + "/" + name);
		ImageIcon icon = new ImageIcon(fileUrl);
		images.put(name.substring(0, name.indexOf('.')), icon);
	}
	
	public void addImageByName(String name) {
		iconsNames.add(name);
		loadName(name);
	}
	
	public URL getIntroductionUrl(){
		return resourceLoader.introductionUrl;
	}
	
	public ImageIcon getImageIcon(String name) {
		return resourceLoader.images.get(name);
	}
	
	public Image getImage(String name) {
		return resourceLoader.getImageIcon(name).getImage();
	}
}
	
	