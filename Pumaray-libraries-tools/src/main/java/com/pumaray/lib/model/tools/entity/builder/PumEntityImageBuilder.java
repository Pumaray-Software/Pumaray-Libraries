package com.pumaray.lib.model.tools.entity.builder;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import javax.imageio.ImageIO;

import com.pumaray.lib.model.graphics.PumEntityImage;
import com.pumaray.lib.utils.graphics.PumSupportedImageExtension;

public class PumEntityImageBuilder implements PumEntityBuilder<PumEntityImage> {

	public PumEntityImage createInstanceFromUrl(URL imageUrl) throws IOException {
		PumEntityImage pumImage = null;
		String extension = getExtensionByStringHandling(imageUrl.getFile()).get();
		BufferedImage bufImage = ImageIO.read(imageUrl);
		byte[] imageData = convertBufferedImageToByteArray(bufImage, extension);
		PumSupportedImageExtension imageExtension = PumSupportedImageExtension.valueOf(extension.toUpperCase());
		pumImage = new PumEntityImage(imageUrl.getFile(), imageExtension, imageData );
		return pumImage;

	}

	@Override
	public PumEntityImage build() {
		// TODO Auto-generated method stub
		return null;
	}

	private byte[] convertBufferedImageToByteArray(BufferedImage bufImage, String extension) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bufImage, extension, bos);
		byte[] data = bos.toByteArray();
		return data;
	}

	private Optional<String> getExtensionByStringHandling(String filename) {
	    return Optional.ofNullable(filename)
	      .filter(f -> f.contains("."))
	      .map(f -> f.substring(filename.lastIndexOf(".") + 1));
	}
}
