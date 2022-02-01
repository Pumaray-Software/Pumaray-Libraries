package com.pumaray.lib.model.graphics;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.pumaray.lib.model.impl.PumDefaultBean;
import com.pumaray.lib.utils.graphics.PumSupportedImageExtension;

public class PumDefaultImage<K> extends PumDefaultBean implements PumImage<K> {

	private static final long serialVersionUID = 2083538309274904665L;

	protected K id;
	protected String name;
	protected PumSupportedImageExtension extension;
	protected byte[] data;

	public PumDefaultImage() {
	}

	public PumDefaultImage(String name, PumSupportedImageExtension extension, byte[] data) {
		this.name = name;
		this.extension = extension;
		this.data = data;
	}

	public PumDefaultImage(Path imagePath) throws Exception {
		createPumImageFromPath(imagePath);
	}

	private void validateImage(Path imagePath) throws Exception {
		if (!Files.exists(imagePath)) {
			throw new FileNotFoundException(imagePath.getFileName() + " Not found");
		}
		String fileName = imagePath.getFileName().toString();
		String extension = fileName.toString().substring(fileName.lastIndexOf(".") + 1);
		if (!validExtension(extension)) {
			throw new UnsupportedEncodingException(extension + "-> this format is not supported");
		}
	}

	private void createPumImageFromPath(Path imagePath) throws Exception {
		validateImage(imagePath);
		String fileName = imagePath.getFileName().toString();
		this.name = fileName.substring(0, fileName.lastIndexOf("."));
		this.extension = PumSupportedImageExtension.valueOf(fileName.substring(fileName.lastIndexOf(".") + 1).toUpperCase());
		this.data = Files.readAllBytes(imagePath);
	}

	private boolean validExtension(String extension) {
		boolean result = false;
		PumSupportedImageExtension[] validExtensions = PumSupportedImageExtension.values();
		boolean found = false;
		int index = 0;
		while (!found && index < validExtensions.length) {
			if (validExtensions[index].name().equalsIgnoreCase(extension)) {
				found = true;
			}
			else {
				index++;
			}
		}
		result = found;
		return result;
	}

	@Override
	public K getId() {
		return id;
	}

	@Override
	public void setId(K id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public PumSupportedImageExtension getExtension() {
		return extension;
	}

	@Override
	public void setExtension(PumSupportedImageExtension extension) {
		this.extension = extension;
	}

	@Override
	public byte[] getData() {
		return data;
	}

	@Override
	public void setData(byte[] data) {
		this.data = data;
	}
}
