package com.pumaray.lib.utils.io;

import java.io.File;

public class PumFileOperations {
	
	public static String FileNameWithoutExtention(File file) {
		return FileNameWithoutExtention(file.getAbsolutePath());
	}
	
	public static String FileNameWithoutExtention(String fileName) {
		if(fileName.contains(".")) {
			return fileName.substring(0,fileName.lastIndexOf("."));
		}
		else {
			throw new IllegalArgumentException("This is not a file");
		}
	}

}
