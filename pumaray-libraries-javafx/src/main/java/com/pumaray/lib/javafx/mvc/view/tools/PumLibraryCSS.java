package com.pumaray.lib.javafx.mvc.view.tools;

import java.net.URISyntaxException;

import javafx.scene.Scene;

public class PumLibraryCSS {

	public static void addLibraryCSSToScene(Scene scene) throws URISyntaxException {
		scene.getStylesheets().addAll(
				PumLibraryCSS.class.getResource("/css/messages.css").toURI().toString(),
				PumLibraryCSS.class.getResource("/css/titled-border-pane.css").toURI().toString()
		);
	}

}
