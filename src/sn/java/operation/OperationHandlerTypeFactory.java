package sn.java.operation;

import sn.java.operation.iface.IOperationHandler;

public enum OperationHandlerTypeFactory {
	INSTANCE;
	
	public IOperationHandler getOperationHandlerType(String handlerType, Object sourceMap) {
		
		switch(handlerType) {
		case "file":
			return new FileHandler(sourceMap);
		default:
			return null;
		}
		
	}

}
