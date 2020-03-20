package org.cyk.system.file.client.controller.entities;

import org.cyk.system.file.server.representation.entities.FileDto;
import org.cyk.utility.__kernel__.mapping.AbstractMapperSourceDestinationImpl;
import org.cyk.utility.client.controller.data.MappingInstantiator;
import org.mapstruct.Mapper;

@Mapper(uses= {MappingInstantiator.class})
public abstract class FileMapper extends AbstractMapperSourceDestinationImpl<File, FileDto> {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void __listenGetSourceAfter__(FileDto destination, File source) {
		super.__listenGetSourceAfter__(destination, source);
		source.getContent(Boolean.TRUE).setBytes(destination.getBytes());
		source.getContent(Boolean.TRUE).setExtension(destination.getExtension());
		source.getContent(Boolean.TRUE).setMimeType(destination.getMimeType());
		source.getContent(Boolean.TRUE).setName(destination.getName());
		source.getContent(Boolean.TRUE).setSize(destination.getSize());
		source.getContent(Boolean.TRUE).setUniformResourceLocator(destination.getUniformResourceLocator());
		source.getContent(Boolean.TRUE).setChecksum(destination.getSha1());
	}
	
	@Override
	protected void __listenGetDestinationAfter__(File source, FileDto destination) {
		super.__listenGetDestinationAfter__(source, destination);
		if(source.getContent() != null) {
			destination.setBytes(source.getContent().getBytes());
			destination.setExtension(source.getContent().getExtension());
			destination.setMimeType(source.getContent().getMimeType());
			destination.setName(source.getContent().getName());
			destination.setNameAndExtension(source.getContent().getNameAndExtension());
			destination.setSize(source.getContent().getSize());
			destination.setUniformResourceLocator(source.getContent().getUniformResourceLocator());
			destination.setSha1(source.getContent().getChecksum());
		}
	}
	
}