package com.pumaray.lib.model.impl;

import com.pumaray.lib.model.PumEntity;
import com.pumaray.lib.model.constant.ModelConstant;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.TableGenerator;

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
