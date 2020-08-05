package com.pumaray.lib.javafx.mvc.view.nav;

import com.pumaray.lib.utils.navigation.PumNavigatable;

import javafx.scene.Node;

public class PumFXDefaultNavigationNode<E extends Node> implements PumFXNavigatable {

	private E node;
	private PumFXDefaultNavigationNode next;
	private PumFXDefaultNavigationNode prev;

	public PumFXDefaultNavigationNode(E node, PumFXDefaultNavigationNode prev, PumFXDefaultNavigationNode next) {
		this.next = next;
		this.prev = prev;
		this.node = node;
	}

	public static PumFXDefaultNavigationNode generateNode(Node fxNode, Node prevNode, Node nextNode) {
		PumFXDefaultNavigationNode prev = null;
		PumFXDefaultNavigationNode next = null;
		PumFXDefaultNavigationNode node = null;

		if (prevNode != null) {
			prev = new PumFXDefaultNavigationNode(prevNode, null, node);
		}
		if (nextNode != null) {
			next = new PumFXDefaultNavigationNode(nextNode, node, null);
		}
		node = new PumFXDefaultNavigationNode(fxNode, prev, next);

		return node;
	}

	@Override
	public void navigateToPrev() {
		prev.displayMe();
	}

	@Override
	public void navigateToNext() {
		next.displayMe();
	}

	@Override
	public void displayMe() {
		node.setVisible(true);
	}

	@Override
	public PumNavigatable getNext() {
		return next;
	}

	@Override
	public PumNavigatable getPrev() {
		return prev;
	}
}
