package com.pumaray.lib.tools.comparator.impl;

import com.pumaray.lib.model.PumBean;
import com.pumaray.lib.tools.comparator.PumComparator;

public class PumDefaultBeanComparator implements PumComparator {

	@Override
	public boolean isEquals(PumBean bean1, PumBean bean2) {
		return bean1.isEqualsTo(bean2);
	}

}
