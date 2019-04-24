package org.cyk.system.file.client.controller.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.system.file.client.controller.entities.File;
import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.client.controller.component.menu.MenuBuilderMapGetterImpl;
import org.cyk.utility.client.controller.component.theme.ThemeClassGetterImpl;
import org.cyk.utility.identifier.resource.UniformResourceIdentifierParameterValueMatrix;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		__inject__(FunctionRunnableMap.class).set(MenuBuilderMapGetterImpl.class, MenuBuilderMapGetterFunctionRunnableImpl.class,LEVEL);
		__inject__(FunctionRunnableMap.class).set(ThemeClassGetterImpl.class, ThemeClassGetterFunctionRunnableImpl.class,LEVEL);
		
		__inject__(UniformResourceIdentifierParameterValueMatrix.class).setClasses(File.class);
	}
	
	@Override
	public void __destroy__(Object object) {}
	
	/**/
	
	public static final Integer LEVEL = new Integer(org.cyk.system.file.client.controller.api.ApplicationScopeLifeCycleListener.LEVEL+1);
}
