package sn.java.operation.iface;

import java.io.File;
import java.util.List;

import sn.java.exception.ApplicationException;

public interface IOperationHandler {
	
	public List<String> readOperation() throws ApplicationException;
	
	public void writeOperation(Object contentsToWrite, File outputDirectory) throws ApplicationException;

}
