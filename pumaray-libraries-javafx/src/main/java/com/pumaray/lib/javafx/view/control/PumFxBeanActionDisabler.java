package com.pumaray.lib.javafx.view.control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pumaray.lib.javafx.mvc.view.bean.binding.PumFXBeanBinding;
import com.pumaray.lib.javafx.mvc.view.tools.PumLayout;
import com.pumaray.lib.javafx.view.control.action.PumAction;
import com.pumaray.lib.javafx.view.control.action.PumFXAction;
import com.pumaray.lib.javafx.view.model.PumMessage;
import com.pumaray.lib.model.PumBean;
import com.pumaray.lib.tools.validator.PumValidator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class PumFxBeanActionDisabler extends PumAbstractActionDisabler implements ChangeListener {

	private final Logger logger = LoggerFactory.getLogger(PumFxBeanActionDisabler.class);
	private final Validator beanValidator = Validation.buildDefaultValidatorFactory().getValidator();

	private PumFXBeanBinding<? extends PumBean> binding;
	private Collection<PumFXBeanBinding<? extends PumBean>> bindings;
	private List<PumValidator> validators = new ArrayList<PumValidator>();;
	private String failStyle = PumLayout.ERROR_STYLE;
	private String successStyle = PumLayout.SUCCESS_STYLE;

	private PumMessage message;

	public PumFxBeanActionDisabler(PumFXBeanBinding<? extends PumBean> binding, PumFXAction... actions) {
		super(actions);
		this.binding = binding;
		bindings = new ArrayList<PumFXBeanBinding<? extends PumBean>>();
		bindings.add(binding);

		init();
		validate();
	}

	public PumFxBeanActionDisabler(Collection<PumFXBeanBinding<? extends PumBean>> bindings, PumFXAction... actions) {
		super(actions);
		this.bindings = bindings;

		init();
		validate();
	}

	// todo korda purba wak si bo por hasie nested lambda expressions
	private void init() {

		bindings.stream().map(PumFXBeanBinding::getBindings)
				.forEach(d -> d.keySet().stream().forEach(e -> e.addListener(this)));

		// bindings.stream().map(PumFXBeanBinding::getControls)
		// .forEach(d -> d.values().stream().forEach(e ->
		// e.setStyle(failStyle)));
	}

	public void addValidator(PumValidator validator) {
		validators.add(validator);
	}

	public boolean validateOtherValidators() {
		if (validators.size() > 0) {
			return validators.stream().anyMatch(t -> t.isValid());
		}
		else {
			return true;
		}
	}

	@Override
	public void validate() {
		PumBean bean = binding.getPumBean();
		try {
			Set<ConstraintViolation<PumBean>> errors = beanValidator.validate(bean);
			if (errors.size() > 0) {
				ConstraintViolation<PumBean> c = errors.iterator().next();
				logger.debug(c.getPropertyPath() + "->" + c.getMessage());
				disableActions();
			}
			else {
				if (validateOtherValidators()) {
					enableActions();
				}
				else {
					disableActions();
				}
			}
		}
		catch (ValidationException ev) {
			disableActions();
			logger.debug(ev.getMessage());
		}
		catch (Exception ex) {
			logger.error("Error in bean validation", ex);
		}
	}

	public String getFailStyle() {
		return failStyle;
	}

	public void setFailStyle(String failStyle) {
		this.failStyle = failStyle;
	}

	public String getSuccessStyle() {
		return successStyle;
	}

	public void setSuccessStyle(String successStyle) {
		this.successStyle = successStyle;
	}

	@Override
	public <T extends PumAction> void addAction(T action) {
		actions.add(action);
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public void changed(ObservableValue observable, Object oldValue, Object newValue) {
		validate();
	}

}
