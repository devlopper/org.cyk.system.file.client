package org.cyk.system.file.client.controller.entities;

import java.io.Serializable;

import org.cyk.system.file.server.representation.entities.FileDto;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.AbstractInstanceBuilderImpl;

@org.cyk.system.file.server.annotation.System
public class InstanceBuilderImpl extends AbstractInstanceBuilderImpl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __copy__(Object source, Object destination,Properties properties) {
		if(source instanceof FileDto && destination instanceof File) {
			FileDto representation = (FileDto) source;
			File data = (File) destination;
			data.setIdentifier(representation.getIdentifier());
			org.cyk.utility.file.File content = __inject__(org.cyk.utility.file.File.class);
			content.setBytes(representation.getBytes());
			content.setUniformResourceLocator(representation.getUniformResourceLocator());
			content.setSize(representation.getSize());
			content.setName(representation.getName());
			content.setMimeType(representation.getMimeType());
			content.setExtension(representation.getExtension());
			data.setContent(content);
		}else if(source instanceof File && destination instanceof FileDto) {
			File data = (File) source;
			FileDto representation = (FileDto) destination;
			representation.setIdentifier((String) data.getIdentifier());
			if(data.getContent()!=null) {
				representation.setUniformResourceLocator(data.getContent().getUniformResourceLocator());
				representation.setSize(data.getContent().getSize());
				representation.setName(data.getContent().getName());
				representation.setMimeType(data.getContent().getMimeType());
				representation.setExtension(data.getContent().getExtension());
				representation.setBytes(data.getContent().getBytes());
			}
		}else
			super.__copy__(source, destination,properties);
	}
	
}
