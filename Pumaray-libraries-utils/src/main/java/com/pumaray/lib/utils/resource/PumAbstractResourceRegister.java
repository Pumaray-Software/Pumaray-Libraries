package com.pumaray.lib.utils.resource;

import java.util.Hashtable;

public abstract class PumAbstractResourceRegister<K, V> extends Hashtable<K, V> implements
		PumResourceRegister<K, V> {

	protected PumAbstractResourceRegister() {	}

}
