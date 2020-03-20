package org.cyk.system.file.client.controller.impl;

import java.io.Serializable;
import java.security.Principal;

import org.cyk.utility.client.controller.component.menu.AbstractMenuBuilderMapInstantiatorImpl;
import org.cyk.utility.client.controller.component.menu.MenuBuilder;

@org.cyk.system.file.server.annotation.System
public class MenuBuilderMapInstantiatorImpl extends AbstractMenuBuilderMapInstantiatorImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __instantiateSessionMenuBuilderItems__(Object key,MenuBuilder sessionMenuBuilder, Object request, Principal principal) {
		
	}
	
}
