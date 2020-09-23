package com.pumaray.lib.javafx.view.components;

import java.util.Collection;

import com.pumaray.lib.javafx.mvc.view.bean.PumBeanListener;
import com.pumaray.lib.javafx.view.model.PumMessage;
import com.pumaray.lib.model.PumBean;

import javafx.scene.control.Label;
import jfxtras.labs.scene.control.BeanPathAdapter;

public class PumMessageView extends Label implements PumBeanListener<PumMessage> {

	private PumMessage message = new PumMessage();
	private BeanPathAdapter<PumMessage> messagePA = new BeanPathAdapter<>(message);

	public PumMessageView(String id) {
		setId(id);
		messagePA.bindBidirectional(PumMessage.MESSAGE, textProperty());
		
		showInfo();
	}

	@Override
	public String getUniqueKey() {
		return getId();
	}

	@Override
	public void setPumBean(PumMessage bean) {
		this.message = (PumMessage) bean;
		switch (message.getType()) {
		case ERROR:
			showError();
			break;
		case SUCCES : showSucceed(); break;

		}
		messagePA.setBean(message);
	}

	@Override
	public PumMessage getPumBean() {
		return messagePA.getBean();
	}

	@Override
	public void setPumBeans(Collection<PumMessage> beans) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<PumMessage> getPumBeans() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateView() {
		setPumBean(message);
	}

	public void showError() {
		getStyleClass().add("error");
	}

	public void showSucceed() {
		getStyleClass().add("succes");
	}

	public void showWarning() {
		getStyleClass().add("warning");
	}
	
	public void showInfo() {
		getStyleClass().add("info");
	}

	@Override
	public Class<? extends PumBean> getBeanToListenTo() {
		return PumMessage.class;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
