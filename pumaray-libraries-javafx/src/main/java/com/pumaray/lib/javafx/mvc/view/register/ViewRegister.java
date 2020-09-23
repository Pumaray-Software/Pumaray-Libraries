package com.pumaray.lib.javafx.mvc.view.register;

import java.util.Collection;
import java.util.stream.Collectors;

import com.pumaray.lib.javafx.mvc.view.PumRegisterable;
import com.pumaray.lib.utils.resource.PumSimpleResourceRegister;

public class ViewRegister extends PumSimpleResourceRegister<String, PumRegisterable> {
	
	private static final long serialVersionUID = 3124256771611627040L;
	private static ViewRegister viewRegister = null;
	
	public ViewRegister(){}
	
	private static void init() {
		if(viewRegister == null) {
			viewRegister = new ViewRegister();
		}
	}
	
	public static void register(PumRegisterable item) {
		init();
		viewRegister.put(item.getUniqueKey(), item);
	}
	
	public static void unRegister(String key) {
		init();
		viewRegister.remove(key);
	}
	
	public static PumRegisterable getRegistarable(String key) {
		init();
		return viewRegister.get(key);
	}
	
	public static Collection<PumRegisterable> getAllRegisteredListeners() {
		init();
		return viewRegister.values();
	}
	
	public static <T> Collection<T> getAllRegisteredListenersOfType(Class<T> type) {
		init();
		return viewRegister.values().stream()
				.filter(p -> type.isInstance(p))
				.map(p -> type.cast(p))
				.collect(Collectors.toList());
	}
}
