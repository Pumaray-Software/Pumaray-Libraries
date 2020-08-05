package com.pumaray.lib.javafx.mvc.view.nav;

import com.pumaray.lib.utils.navigation.PumNavigatable;

import javafx.scene.Node;

public interface PumFXNavigatable<E extends Node> extends PumNavigatable {

	void displayMe();
}
