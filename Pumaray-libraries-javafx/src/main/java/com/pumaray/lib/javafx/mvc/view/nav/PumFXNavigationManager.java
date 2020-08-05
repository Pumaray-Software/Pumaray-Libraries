package com.pumaray.lib.javafx.mvc.view.nav;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import com.pumaray.lib.utils.navigation.PumNavigatable;

public class PumFXNavigationManager extends ArrayList<PumFXNavigatable> {

	private static final long serialVersionUID = -7080310828613253454L;

	private static PumFXNavigationManager nav = null;

	private PumFXNavigatable current;

	private PumFXNavigationManager() {}

	private static void init() {
		if (nav == null) {
			nav = new PumFXNavigationManager();
		}
	}

	public static void addPumFXNavigatable(PumFXNavigatable navigatable) {
		init();
		nav.add(navigatable);
	}

	public static void goToNext() throws NoSuchElementException {
		init();
		nav.navigateToNext();
	}

	public static void goToPrev() throws NoSuchElementException {
		init();
		nav.navigateToPrev();
	}
	
	@Override
	public boolean add(PumFXNavigatable navigatable) {
		current = navigatable;
		return super.add(navigatable);
	}

	public void navigateToNext() throws NoSuchElementException {
		PumNavigatable next;
		if ((next = current.getNext()) != null) {
			current = (PumFXNavigatable) next;
			current.displayMe();
		}
		else {
			throw new NoSuchElementException();
		}
	}
	
	public void navigateToPrev() throws NoSuchElementException {
		PumNavigatable prev;
		if ((prev = current.getPrev()) != null) {
			current = (PumFXNavigatable) prev;
			current.displayMe();
		}
		else {
			throw new NoSuchElementException();
		}
	}

}
