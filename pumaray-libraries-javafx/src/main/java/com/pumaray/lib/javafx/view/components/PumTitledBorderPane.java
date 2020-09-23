package com.pumaray.lib.javafx.view.components;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class PumTitledBorderPane extends StackPane {

	public PumTitledBorderPane(String titleString, Node content, Pos titlePosition) {
		setId("titled-border-pane");
		System.out.println("The scene of pumtitledpane = " + getScene());
		Label title = new Label(" " + titleString + " ");
		title.getStyleClass().add("bordered-titled-title");
		StackPane.setAlignment(title, titlePosition);

		StackPane contentPane = new StackPane();
		content.getStyleClass().add("bordered-titled-content");
		contentPane.getChildren().add(content);

		getStyleClass().add("bordered-titled-border");
		getChildren().addAll(title, contentPane);
	}
}
