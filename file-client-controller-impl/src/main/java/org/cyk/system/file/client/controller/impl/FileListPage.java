package org.cyk.system.file.client.controller.impl;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.system.file.client.controller.entities.File;
import org.cyk.utility.client.controller.web.jsf.primefaces.model.collection.Column;
import org.cyk.utility.client.controller.web.jsf.primefaces.model.collection.DataTable;
import org.cyk.utility.client.controller.web.jsf.primefaces.page.AbstractEntityListPageContainerManagedImpl;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class FileListPage extends AbstractEntityListPageContainerManagedImpl<File> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		dataTable.useQueryIdentifiersFiltersLike();
		dataTable.setIsExportable(Boolean.FALSE);
		dataTable.setAreColumnsChoosable(Boolean.FALSE);
	}
	
	@Override
	protected Map<Object, Object> __getDataTableArguments__() {
		Map<Object, Object> arguments = super.__getDataTableArguments__();
		arguments.put(DataTable.ConfiguratorImpl.FIELD_FILTERABLE, Boolean.TRUE);
		return arguments;
	}
	
	@Override
	protected Collection<String> __getColumnsFieldsNames__(Class<File> entityClass) {
		return List.of(File.FIELD_NAME);
	}
	
	@Override
	protected Map<Object, Object> __getColumnArguments__(String fieldName) {
		Map<Object, Object> arguments =  super.__getColumnArguments__(fieldName);
		if(File.FIELD_NAME.equals(fieldName))
			arguments.put(Column.ConfiguratorImpl.FIELD_FILTERABLE, Boolean.TRUE);
		return arguments;
	}
	
	protected void __addDataTableHeaderToolbarLeftCommandsByArguments__(DataTable dataTable) {
		
	}
	
	protected void __addDataTableRecordMenuItemByArguments__(DataTable dataTable) {
		dataTable.addRecordMenuItemByArgumentsOpenViewInDialogRead();
	}
}
