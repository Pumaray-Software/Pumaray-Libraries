package com.pumaray.lib.model.graphics;

import com.pumaray.lib.model.PumBean;
import com.pumaray.lib.utils.graphics.PumSupportedImageExtension;

public interface PumImage<K> extends PumBean {

	public K getId();

	public void setId(K id);

	public String getName();

	public void setName(String name);

	public PumSupportedImageExtension getExtension();

	public void setExtension(PumSupportedImageExtension extension);

	public byte[] getData();

	public void setData(byte[] data);

}
