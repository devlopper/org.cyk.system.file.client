package org.cyk.system.file.client.controller.api;

import java.io.Serializable;

import javax.inject.Singleton;

import org.cyk.system.file.client.controller.entities.File;
import org.cyk.utility.client.controller.AbstractControllerEntityImpl;

@Singleton
public class FileControllerImpl extends AbstractControllerEntityImpl<File> implements FileController,Serializable {
	private static final long serialVersionUID = 1L;

}
