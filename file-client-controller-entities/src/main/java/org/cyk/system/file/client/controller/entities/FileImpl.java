package org.cyk.system.file.client.controller.entities;

import java.io.Serializable;

import org.cyk.utility.client.controller.component.annotation.Input;
import org.cyk.utility.client.controller.component.annotation.InputFile;
import org.cyk.utility.client.controller.data.AbstractDataIdentifiedByStringImpl;

public class FileImpl extends AbstractDataIdentifiedByStringImpl implements File,Serializable {
	private static final long serialVersionUID = 1L;

	@Input @InputFile
	private org.cyk.utility.__kernel__.file.File content;
	
	public org.cyk.utility.__kernel__.file.File getContent() {
		return content;
	}
	
	@Override
	public org.cyk.utility.__kernel__.file.File getContent(Boolean injectIfNull) {
		if(content == null && Boolean.TRUE.equals(injectIfNull))
			content = __inject__(org.cyk.utility.__kernel__.file.File.class);
		return content;
	}
	
	@Override
	public File setContent(org.cyk.utility.__kernel__.file.File content) {
		this.content = content;
		return this;
	}
	
	@Override
	public File setIdentifier(String identifier) {
		return (File) super.setIdentifier(identifier);
	}
	
	@Override
	public String toString() {
		org.cyk.utility.__kernel__.file.File content = getContent();
		return content == null ? super.toString() : content.getNameAndExtension();
	}
}
