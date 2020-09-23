package com.pumaray.lib.javafx.mvc.view.tools;

import java.io.InputStream;

import com.pumaray.lib.utils.io.PumFileOperations;
import com.pumaray.lib.utils.resource.PumSimpleResourceRegister;

import javafx.scene.image.Image;

public class ImagesRegister extends PumSimpleResourceRegister<String, Image> {
	
	private static ImagesRegister images = null;
	private final String path;
	
	public ImagesRegister(String path)   {
		this.path = path;
	}
	
	public static void init(String path) {
		if(images == null) {
			images = new ImagesRegister(path);
		}
	}
	
	public static void addImage(String imageFileName) {
		InputStream confStream = images.getClass().getResourceAsStream(images.path+"/" + imageFileName);
		Image image = new Image(confStream);
		//Image image = new Image(images.getClass().getClassLoader().getResourceAsStream(images.path+"/" + imageFileName));
		String key = PumFileOperations.FileNameWithoutExtention(imageFileName);
		images.register(key, image);
	}
	
	public static Image getImage(String key) {
		return images.retrieve(key);
	}
}
