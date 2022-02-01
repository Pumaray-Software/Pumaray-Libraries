package com.pumaray.lib.model.graphics;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.pumaray.lib.model.impl.PumDefaultEntity;
import com.pumaray.lib.utils.graphics.PumSupportedImageExtension;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

@Entity(name = TableNames.IMAGE)
@Table(name = TableNames.IMAGE)
@AttributeOverride(name = PumDefaultEntity.ID, column = @Column(name = ColumnNames.ID))
@XmlAccessorType(XmlAccessType.FIELD)
public class PumEntityImage extends PumDefaultEntity implements PumImage<Long> {

	private static final long serialVersionUID = 4659890256393882603L;

	@Column(name = ColumnNames.NAME)
	@XmlElement(name = XmlElementNames.NAME)
	private String name;

	@Column(name = ColumnNames.EXTENSION)
	@XmlElement(name = XmlElementNames.EXTENSION)
	private PumSupportedImageExtension extension;

	@Column(name = ColumnNames.DATA)
	@XmlElement(name = XmlElementNames.DATA)
	@Lob
	private byte[] data;

	public PumEntityImage() {
	}

	public PumEntityImage(String name, PumSupportedImageExtension extension, byte[] data) {
		this.name = name;
		this.extension = extension;
		this.data = data;
	}

	public PumEntityImage(Path imagePath) throws Exception {
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
	@Column(name = ColumnNames.NAME)
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	@Column(name = ColumnNames.EXTENSION)
	public PumSupportedImageExtension getExtension() {
		return extension;
	}

	@Override
	public void setExtension(PumSupportedImageExtension extension) {
		this.extension = extension;
	}

	@Override
	@Column(name = ColumnNames.DATA)
	public byte[] getData() {
		return data;
	}

	@Override
	public void setData(byte[] data) {
		this.data = data;
	}

}

final class TableNames {

	public static final String IMAGE = "PUM_IMAGE";

}

final class ColumnNames {

	public static final String ID = "IMAGE_ID";
	public static final String NAME = "NAME";
	public static final String EXTENSION = "EXTENSION";
	public static final String DATA = "DATA";

}

final class XmlElementNames {

	public static final String ID = "image-id";
	public static final String NAME = "name";
	public static final String EXTENSION = "extension";
	public static final String DATA = "data";
}
