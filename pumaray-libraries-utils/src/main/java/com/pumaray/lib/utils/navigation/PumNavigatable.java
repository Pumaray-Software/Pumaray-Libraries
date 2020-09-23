package com.pumaray.lib.utils.navigation;

public interface PumNavigatable {
	
	PumNavigatable getNext();
	PumNavigatable getPrev();
	
	void navigateToPrev();
	void navigateToNext();
}
