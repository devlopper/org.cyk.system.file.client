package org.cyk.system.file.client.controller.api;

import java.io.Serializable;

import org.cyk.system.file.client.controller.entities.File;
import org.cyk.utility.__kernel__.function.AbstractFunctionRunnableImpl;
import org.cyk.utility.__kernel__.function.FunctionRunnableMap;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProvider;
import org.cyk.utility.client.controller.proxy.ProxyClassUniformResourceIdentifierStringProviderImpl;
import org.cyk.utility.client.controller.test.TestControllerCreate;
import org.cyk.utility.client.controller.test.arquillian.AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram;
import org.junit.Test;

public class FileControllerIntegrationTest extends AbstractControllerArquillianIntegrationTestWithDefaultDeploymentAsSwram {
	private static final long serialVersionUID = 1L;
	
	/* Create */
	
	@Test
	public void createOneFile() throws Exception{
		__inject__(ApplicationScopeLifeCycleListener.class).initialize(null);
		__inject__(FunctionRunnableMap.class).set(ProxyClassUniformResourceIdentifierStringProviderImpl.class, ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl.class,100);
		
		String identifier = __getRandomIdentifier__();
		String text = "Hello";
		File file = __inject__(File.class).setIdentifier(identifier).setContent(__inject__(org.cyk.utility.file.File.class).setName("myfile").setExtension("txt")
				.setBytes(text.getBytes()));
		__inject__(TestControllerCreate.class).setIsCatchThrowable(Boolean.FALSE).addObjects(file).execute();
	}
	
	/**/
	
	public static class ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl extends AbstractFunctionRunnableImpl<ProxyClassUniformResourceIdentifierStringProvider> implements Serializable {
		private static final long serialVersionUID = 1L;
		
		public ProxyClassUniformResourceIdentifierStringProviderFunctionRunnableImpl() {
			setRunnable(new Runnable() {
				@Override
				public void run() {
					setOutput("http://localhost:8080/file/server/");
				}
			});
		}
		
	}
	
}
