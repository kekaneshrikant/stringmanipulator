package sn.tests.operation;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import sn.java.operation.FileHandler;
import sn.java.operation.OperationHandlerTypeFactory;
import sn.java.operation.iface.IOperationHandler;

public class OperationHandlerTypeFactoryTest {

	@Test
	public void testGetOperationHandlerTypeWithValidType() {
		Map<String, File> sourceMap = new HashMap<>();
		IOperationHandler handlerType = OperationHandlerTypeFactory.INSTANCE.getOperationHandlerType("FILE", sourceMap);
		assertTrue(handlerType instanceof FileHandler);
	}
	
	@Test
	public void testGetOperationHandlerTypeWithInValidType() {
		Map<String, File> sourceMap = new HashMap<>();
		IOperationHandler handlerType = OperationHandlerTypeFactory.INSTANCE.getOperationHandlerType("INVALID", sourceMap);
		assertNull(handlerType);
	}

}
