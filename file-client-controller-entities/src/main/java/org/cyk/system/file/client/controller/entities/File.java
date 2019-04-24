package org.cyk.system.file.client.controller.entities;

import org.cyk.utility.client.controller.data.Data;

public interface File extends Data {

	org.cyk.utility.file.File getContent();
	File setContent(org.cyk.utility.file.File content);
	
	@Override File setIdentifier(Object identifier);
	
	/**/
	
	String PROPERTY_CONTENT = "content";
}
