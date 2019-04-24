package org.cyk.system.file.client.controller.entities;

import java.io.Serializable;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputFile;
import org.cyk.utility.client.controller.data.AbstractDataImpl;

public class FileImpl extends AbstractDataImpl implements File,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputFile
	private org.cyk.utility.file.File content;
	
	public org.cyk.utility.file.File getContent() {
		return content;
	}
	
	@Override
	public File setContent(org.cyk.utility.file.File content) {
		this.content = content;
		return this;
	}
	
	@Override
	public File setIdentifier(Object identifier) {
		return (File) super.setIdentifier(identifier);
	}
	
}
