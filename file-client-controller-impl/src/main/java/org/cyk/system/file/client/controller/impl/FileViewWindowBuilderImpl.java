package org.cyk.system.file.client.controller.impl;

import java.io.Serializable;

import org.cyk.system.file.client.controller.entities.File;
import org.cyk.system.file.client.controller.entities.FileViewWindowBuilder;
import org.cyk.utility.client.controller.component.file.FileBuilder;
import org.cyk.utility.client.controller.component.view.ViewBuilder;
import org.cyk.utility.client.controller.component.window.AbstractWindowContainerManagedWindowBuilderViewDataImpl;
import org.cyk.utility.client.controller.data.Data;

public class FileViewWindowBuilderImpl extends AbstractWindowContainerManagedWindowBuilderViewDataImpl implements FileViewWindowBuilder,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __execute__(Data data, ViewBuilder viewBuilder) {
		FileBuilder fileBuilder = __inject__(FileBuilder.class);
		//fileBuilder.setValueUniformResourceLocator("http://localhost:8080/file/server/file/"+data.getIdentifier()+"/download?isinline=true");
		fileBuilder.setValueUniformResourceLocator(((File)data).getContent().getUniformResourceLocator());
		fileBuilder.setValueMimeType(((File)data).getContent().getMimeType());
		viewBuilder.addComponentBuilder(fileBuilder);
	}

	
}
