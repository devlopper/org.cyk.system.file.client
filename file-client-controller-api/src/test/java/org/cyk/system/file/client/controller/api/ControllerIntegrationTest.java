package org.cyk.system.file.client.controller.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.cyk.system.file.client.controller.entities.File;
import org.cyk.utility.__kernel__.object.__static__.representation.Action;
import org.cyk.utility.__kernel__.persistence.query.filter.Filter;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.client.controller.test.arquillian.AbstractControllerArquillianIntegrationTestWithDefaultDeployment;
import org.junit.Test;

public class ControllerIntegrationTest extends AbstractControllerArquillianIntegrationTestWithDefaultDeployment {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenBefore__() {
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		super.__listenBefore__();
	}
	
	/* Create */
	
	@Test
	public void createOneFile() throws Exception{
		String identifier = __getRandomIdentifier__();
		String text = "Hello";
		File file = null;//__inject__(File.class).setIdentifier(identifier).setContent(FileHelper.build(new FileAsFunctionParameter().setName("myfile.txt").setBytes(text.getBytes())));
		__inject__(FileController.class).create(file);
		
		file = __inject__(FileController.class).readBySystemIdentifier(identifier, new Properties());
		assertThat(file).isNotNull();
		assertThat(file.getContent()).isNotNull();
		assertThat(file.getContent().getExtension()).isEqualTo("txt");
		assertThat(file.getContent().getMimeType()).isEqualTo("text/plain");
		assertThat(file.getContent().getName()).isEqualTo("myfile");
		assertThat(file.get__actionUniformResourceLocatorByIdentifier__(Action.IDENTIFIER_DOWNLOAD)).isEqualTo("http://localhost:8080/file/server/file/"+file.getIdentifier()+"/download?isinline=true");
		assertThat(file.getContent().getBytes()).isNull();
		
		file = __inject__(FileController.class).readBySystemIdentifier(identifier, new Properties().setFields("name,extension,mimeType"));
		assertThat(file).isNotNull();
		assertThat(file.getContent()).isNotNull();
		assertThat(file.getContent().getExtension()).isEqualTo("txt");
		assertThat(file.getContent().getMimeType()).isEqualTo("text/plain");
		assertThat(file.getContent().getName()).isEqualTo("myfile");
		assertThat(file.getContent().getUniformResourceLocator()).isEqualTo(null);
		assertThat(file.getContent().getBytes()).isNull();
		
		file = __inject__(FileController.class).readBySystemIdentifier(identifier, new Properties().setFields("name,extension,mimeType,bytes"));
		assertThat(file).isNotNull();
		assertThat(file.getContent()).isNotNull();
		assertThat(file.getContent().getExtension()).isEqualTo("txt");
		assertThat(file.getContent().getMimeType()).isEqualTo("text/plain");
		assertThat(file.getContent().getName()).isEqualTo("myfile");
		assertThat(file.get__actionUniformResourceLocatorByIdentifier__(Action.IDENTIFIER_DOWNLOAD)).isEqualTo("http://localhost:8080/file/server/file/"+file.getIdentifier()+"/download?isinline=true");
		assertThat(file.getContent().getBytes()).isNotNull();
		assertThat(new String(file.getContent().getBytes())).isEqualTo(text);
	}
	
	@Test
	public void get_whereNameContains() throws Exception{
		for(Integer index = 0 ; index < 20 ; index = index + 1) {
			//String identifier = __getRandomIdentifier__();
			File file = null;//__inject__(File.class).setIdentifier(identifier).setContent(FileHelper.build(new FileAsFunctionParameter().setName("file"+index).setExtension("txt")
					//.setMimeType("text/plain").setUniformResourceLocatorValue("url").setSize(1l).setChecksum("sha1")));
			__inject__(FileController.class).create(file);
		}
		
		assertThat(__inject__(FileController.class).read()).as("file not found").hasSize(5);
		assertGetMany_whereNameContains("f",20);
		assertGetMany_whereNameContains("i",20);
		assertGetMany_whereNameContains("10",1);
		assertGetMany_whereNameContains("file0",1);
		assertGetMany_whereNameContains("file1",11);
		assertGetMany_whereNameContains("file11",1);		
	}
	
	/**/
	
	private void assertGetMany_whereNameContains(String string,Integer count) {
		Filter.Dto filter = new Filter.Dto().useKlass(org.cyk.system.file.server.persistence.entities.File.class).addField(org.cyk.system.file.server.persistence.entities.File.FIELD_NAME, string);
		assertThat(__inject__(FileController.class).read(new Properties().setIsPageable(Boolean.TRUE).setFrom(0).setCount(count)
				.setFilters(filter)))
				.as("complex : number of file where name contains <<"+string+">> is incorrect").hasSize(count);
		
		filter = new Filter.Dto().setValue(string);
		assertThat(__inject__(FileController.class).read(new Properties().setIsPageable(Boolean.TRUE).setFrom(0).setCount(count)
				.setFilters(filter)))
				.as("global : number of file where name contains <<"+string+">> is incorrect").hasSize(count);
	}
	
}
