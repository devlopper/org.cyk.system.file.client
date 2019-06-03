package org.cyk.system.file.client.controller.entities;

import java.io.Serializable;

import org.cyk.utility.client.controller.component.input.choice.AbstractChoicePropertyValueBuilderImpl;
import org.cyk.utility.client.controller.component.input.choice.ChoiceProperty;

@org.cyk.system.file.server.annotation.System
public class ChoicePropertyValueBuilderImpl extends AbstractChoicePropertyValueBuilderImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected String __execute__() throws Exception {
		Object object = getObject();
		if(object instanceof File) {
			ChoiceProperty property = getProperty();
			if(ChoiceProperty.LABEL.equals(property))
				return ((File)object).getContent().getName();
		}
		return super.__execute__();
	}
	
}