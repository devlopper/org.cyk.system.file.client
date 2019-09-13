package org.cyk.system.file.client.deployment.kwordz;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.system.file.client.controller.api.FileController;
import org.cyk.system.file.client.controller.entities.File;
import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.properties.Properties;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class KwordzIndexPage implements Serializable {
	private static final long serialVersionUID = 1L;

	private LazyDataModel<File> files;
	
	@PostConstruct
	public void postConstruct() {
		initialise();
	}
	
	public void initialise() {
		files = new LazyDataModel<File>() {
			private static final long serialVersionUID = 1L;
			
		    @Override
		    public List<File> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String,Object> filters) {
		    	return (List<File>) DependencyInjection.inject(FileController.class).read(new Properties().setIsPageable(Boolean.TRUE).setFrom(first)
		    			.setCount(pageSize));
		    }
			
		    @Override
		    public int getRowCount() {
		    	return 25;
		    }
		};
	}
	
}
