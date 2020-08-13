package com.pumaray.lib.model.tools.entity.builder;

import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.junit.Test;

import com.pumaray.lib.model.graphics.PumEntityImage;

public class PumEntityImageBuilderIt {

	@Test
	public void testCreateInstanceFromUrl() {
		try {
		PumEntityImage image = new PumEntityImageBuilder().createInstanceFromUrl(
				new URL("https://www.debian.org/Pics/openlogo-50.png"));
		assertTrue(image != null);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
