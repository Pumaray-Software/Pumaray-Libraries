package com.pumaray.lib.utils.resource;

public interface PumResourceRegister<K,V> {

	public void register(K k, V v);
	public V retrieve(K k);
	
}
