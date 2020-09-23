package com.pumaray.lib.model.impl;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

import com.pumaray.lib.model.PumEntity;
import com.pumaray.lib.model.constant.ModelConstant;

@MappedSuperclass
public class PumDefaultEntity extends PumDefaultBean implements PumEntity<Long> {

	private static final long serialVersionUID = -1861599232928440325L;

	@TableGenerator(name = ModelConstant.DEFAULT_KEYS_TABLE_NAME,
			table = ModelConstant.DEFAULT_KEYS_TABLE,
			pkColumnName = ModelConstant.DEFAULT_KEYS_TABLE_PK_COLUNM_NAME,
			valueColumnName = ModelConstant.DEFAULT_KEYS_TABLE_VALUE_COLUMN_NAME,
			pkColumnValue = ModelConstant.DEFAULT_KEYS_TABLE_PK_COLUNM_VALUE)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = ModelConstant.DEFAULT_KEYS_TABLE_NAME)
	protected Long id;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "PumDefaultEntity [id=" + id + "]";
	}

}
