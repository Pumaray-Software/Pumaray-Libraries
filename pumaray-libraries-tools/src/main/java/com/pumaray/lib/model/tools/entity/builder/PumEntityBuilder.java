package com.pumaray.lib.model.tools.entity.builder;

import com.pumaray.lib.model.PumEntity;

public interface PumEntityBuilder<E extends PumEntity> {

	public E build();

}
