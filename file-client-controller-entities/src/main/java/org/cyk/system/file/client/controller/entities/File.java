package org.cyk.system.file.client.controller.entities;

import java.io.Serializable;

import org.cyk.utility.__kernel__.object.__static__.controller.AbstractDataIdentifiableSystemStringImpl;
import org.cyk.utility.__kernel__.object.__static__.controller.annotation.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public class File extends AbstractDataIdentifiableSystemStringImpl implements Serializable {

	private String uniformResourceLocator;
	@Column
	private String name;
	private String extension;
	private String mimeType;
	private Long size;
	private String sha1;
	
	private org.cyk.utility.__kernel__.file.File content;
	
	public org.cyk.utility.__kernel__.file.File getContent(Boolean injectIfNull) {
		if(content == null && Boolean.TRUE.equals(injectIfNull))
			content = __inject__(org.cyk.utility.__kernel__.file.File.class);
		return content;
	}
	
	/**/
	
	public static final String FIELD_NAME = "name";
	public static final String FIELD_TEXT = "text";
	public static final String FIELD_EXTENSION = "extension";
	public static final String FIELD_NAME_AND_EXTENSION = "nameAndExtension";
	public static final String FIELD_MIME_TYPE = "mimeType";
	public static final String FIELD_UNIFORM_RESOURCE_LOCATOR = "uniformResourceLocator";
	public static final String FIELD_SIZE = "size";
	public static final String FIELD_SHA1 = "sha1";
	public static final String FIELD_CONTENT = "content";
}
