package com.pumaray.lib.swing.resources;

import java.awt.Image;
import java.net.URL;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.ImageIcon;

public class ImagesStorage {
	private static ImagesStorage storage;
	private Vector<String> iconsNames = new Vector<String>();
	private Hashtable<String, ImageIcon> images = new Hashtable<String, ImageIcon>();
	private String path;
	
	
	private ImagesStorage(String path) {
		this.path = path;
	}
	
	public static void init(String path) {
		if(storage == null) {
			storage = new ImagesStorage(path);
		}
	}
	
	public static void loadImageByName(String name) {
		URL fileUrl = storage.getClass().getClassLoader().getResource(storage.path + "/" + name);
		ImageIcon icon = new ImageIcon(fileUrl);
		storage.images.put(name.substring(0, name.indexOf('.')), icon);
	}
	
	public static void addImageByName(String name) {
		storage.iconsNames.add(name);
		ImagesStorage.loadImageByName(name);
	}
	
	public static ImageIcon getImageIcon(String name) {
		return storage.images.get(name);
	}
	
	public static Image getImage(String name) {
		return ImagesStorage.getImageIcon(name).getImage();
	}
}
