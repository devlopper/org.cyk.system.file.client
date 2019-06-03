package org.cyk.system.file.client.controller.entities;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.client.controller.AbstractApplicationScopeLifeCycleListenerEntities;
import org.cyk.utility.client.controller.component.input.choice.ChoicePropertyValueBuilder;
import org.cyk.utility.instance.InstanceBuilder;
import org.cyk.utility.system.node.SystemNodeClient;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListenerEntities implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		super.__initialize__(object);
		__inject__(SystemNodeClient.class).setName("Gestion des fichiers");
		__setQualifiersClasses__(InstanceBuilder.class, org.cyk.system.file.server.annotation.System.class);
		__setQualifierClassTo__(org.cyk.system.file.server.annotation.System.class, InstanceBuilder.class,ChoicePropertyValueBuilder.class);
	}
	
	@Override
	public void __destroy__(Object object) {}
	
}