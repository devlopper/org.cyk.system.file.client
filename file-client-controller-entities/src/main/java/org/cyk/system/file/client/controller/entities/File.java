package org.cyk.system.file.client.controller.entities;

import org.cyk.utility.client.controller.data.DataIdentifiedByString;

public interface File extends DataIdentifiedByString {

	org.cyk.utility.file.File getContent();
	File setContent(org.cyk.utility.file.File content);
	
	@Override File setIdentifier(String identifier);
	
	/**/
	
	String PROPERTY_CONTENT = "content";
}
