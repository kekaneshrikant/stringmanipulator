package sn.java;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sn.java.exception.ApplicationException;
import sn.java.operation.OperationHandlerTypeFactory;
import sn.java.operation.iface.IOperationHandler;
import sn.java.strings.StringManipulatorTypeFactory;
import sn.java.strings.iface.IStringManipulator;

/**
 * This is the starting point of the application.
 * Two Arguments are required.
 * Input Source Directory Path and Output Destination directory path
 * @author shrikant kekane
 *
 */
public class ApplicationStartUp {

	/**
	 * Start of the application
	 * 
	 * @param args
	 *            Will Accept the Input and Output Directories as arguments
	 */
	public static void main(String[] args) throws ApplicationException {

		File inputDirectory = new File(args[0]);
		File outputDirectory = new File(args[1]);
		Map<String, File> sourceMap = new HashMap<>();

		if (inputDirectory.exists() && inputDirectory.isDirectory()) {
			File[] inputSources = inputDirectory.listFiles();
			for (File file : inputSources) {
				sourceMap.put(file.getName(), file);
			}
		} else {
			throw new ApplicationException("Invalid Directory");
		}
		

		IOperationHandler handlerType = OperationHandlerTypeFactory.INSTANCE.getOperationHandlerType("file", sourceMap);
		try {
			List<String> inputStringsList = handlerType.readOperation();
			IStringManipulator simpleStringManipulator = StringManipulatorTypeFactory.INSTANCE
					.getStringManipulator("SIMPLE", inputStringsList);
			List<String> manipulatedList = simpleStringManipulator.manipulate();
			handlerType.writeOperation(manipulatedList, outputDirectory);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
	}

}
