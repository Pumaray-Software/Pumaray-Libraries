package com.pumaray.lib.utils.resource;

public class PumSimpleResourceRegister<String,V> extends PumAbstractResourceRegister<String,V>{

	public PumSimpleResourceRegister() {
		
	}
	
	@Override
	public void register(String k, V v) {
		put(k,v);
	}

	@Override
	public V retrieve(String key) {
		return get(key);
	}

}
