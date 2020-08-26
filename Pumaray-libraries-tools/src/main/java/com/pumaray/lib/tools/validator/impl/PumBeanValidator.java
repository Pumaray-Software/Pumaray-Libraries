package com.pumaray.lib.tools.validator.impl;

import com.pumaray.lib.model.PumBean;
import com.pumaray.lib.tools.generators.validator.PumValidator;

public class PumBeanValidator implements PumValidator<PumBean>{

	@Override
	public boolean isValid(PumBean e) {
		return e.isValid();
	}

}
