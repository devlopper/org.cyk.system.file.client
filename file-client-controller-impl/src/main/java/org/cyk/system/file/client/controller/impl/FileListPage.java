package org.cyk.system.file.client.controller.impl;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.cyk.system.file.client.controller.entities.File;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.enumeration.Action;
import org.cyk.utility.__kernel__.map.MapHelper;
import org.cyk.utility.client.controller.web.jsf.primefaces.model.collection.AbstractDataTable;
import org.cyk.utility.client.controller.web.jsf.primefaces.model.collection.Column;
import org.cyk.utility.client.controller.web.jsf.primefaces.model.collection.DataTable;
import org.cyk.utility.client.controller.web.jsf.primefaces.page.AbstractEntityListPageContainerManagedImpl;

import lombok.Getter;
import lombok.Setter;

@Named @ViewScoped @Getter @Setter
public class FileListPage extends AbstractEntityListPageContainerManagedImpl<File> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected Map<Object,Object> __getDataTableArguments__() {
		return MapHelper.instantiate(DataTable.FIELD_LAZY,Boolean.TRUE,DataTable.FIELD_ELEMENT_CLASS,entityClass
				,DataTable.ConfiguratorImpl.FIELD_FILTERABLE,Boolean.TRUE
				,DataTable.ConfiguratorImpl.FIELD_COLUMNS_FIELDS_NAMES,CollectionHelper.listOf(File.FIELD_NAME)
				,DataTable.ConfiguratorImpl.FIELD_ACTIONS,null//CollectionHelper.listOf(Action.CREATE)
				,DataTable.ConfiguratorImpl.FIELD_RECORD_ACTIONS,CollectionHelper.listOf(Action.READ)
			,DataTable.ConfiguratorImpl.FIELD_LISTENER,new AbstractDataTable.Listener.AbstractImpl() {
				public Map<Object,Object> getColumnArguments(AbstractDataTable dataTable, String fieldName) {
					Map<Object,Object> arguments = super.getColumnArguments(dataTable, fieldName);
					if(arguments == null)
						arguments = new LinkedHashMap<>();
					if(File.FIELD_NAME.equals(fieldName))
						arguments.put(Column.ConfiguratorImpl.FIELD_FILTERABLE, Boolean.TRUE); 
					return arguments;
				}
			}
		);
	}
	
	/*
	@Override
	protected void __listenPostConstruct__() {
		super.__listenPostConstruct__();
		dataTable.useQueryIdentifiersFiltersLike();
		dataTable.setIsExportable(Boolean.FALSE);
		dataTable.setAreColumnsChoosable(Boolean.FALSE);
	}
	*/
	/*
	@Override
	protected DataTable __buildDataTable__() {
		DataTable dataTable = super.__buildDataTable__();
		dataTable.useQueryIdentifiersFiltersLike();
		dataTable.setIsExportable(Boolean.FALSE);
		dataTable.setAreColumnsChoosable(Boolean.FALSE);
		return dataTable;
	}
	
	@Override
	protected Map<Object, Object> __getDataTableArguments__() {
		Map<Object, Object> arguments = super.__getDataTableArguments__();
		arguments.put(DataTable.ConfiguratorImpl.FIELD_FILTERABLE, Boolean.TRUE);
		return arguments;
	}
	*/
	/*
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
	*/
}