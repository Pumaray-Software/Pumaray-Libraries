package com.pumaray.lib.utils.jaxrs.patch;

public interface ObjectPatch {
	
	<T> T apply(T target) throws ObjectPatchException;

}
