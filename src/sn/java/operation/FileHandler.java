package sn.java.operation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import sn.java.exception.ApplicationException;
import sn.java.operation.iface.IOperationHandler;

public class FileHandler implements IOperationHandler {

	private Map<String, File> inputSourceMap = new HashMap<>();

	@SuppressWarnings("unchecked")
	public FileHandler(Object sourceMap) {
		if (sourceMap instanceof HashMap<?, ?>) {
			this.inputSourceMap = (HashMap<String, File>) sourceMap;
		}
	}

	/**
	 * Purpose of the method is to read the contents of each file in a loop and store it as an array
	 * of Strings and return the List of String back.
	 * Example - if there are 2 files then 1 the List will contain 2 String objects with the contents of each file as 
	 * separate string object.
	 * 
	 */
	@Override
	public List<String> readOperation() throws ApplicationException {
		List<String> finalInputList = new ArrayList<>();
		Iterator iterator = this.inputSourceMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, File> entry = (Map.Entry<String, File>) iterator.next();

			StringBuffer stringBuffer = new StringBuffer();
			try {
				FileInputStream fileInputStream = new FileInputStream(entry.getValue());
				int counter = 0;
				while ((counter = fileInputStream.read()) != -1) {
					stringBuffer.append((char) counter);
				}
				fileInputStream.close();
			} catch (final FileNotFoundException fileNotFoundException) {
				throw new ApplicationException(fileNotFoundException);
			} catch (final IOException ioException) {
				throw new ApplicationException(ioException);
			}
			finalInputList.add(stringBuffer.toString());
		}
		return finalInputList;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void writeOperation(Object contentsToWrite, File outputDirectory) throws ApplicationException {
		try {
			List<String> contentList = (List<String>) contentsToWrite;
			int fileCounter = 1;
			for (String string : contentList) {
				FileOutputStream fileOutputStream = new FileOutputStream(
						outputDirectory + File.separator + "output_" + fileCounter + ".txt");
				fileOutputStream.write(string.getBytes());
				fileOutputStream.close();
				fileCounter++;
			}
		} catch (IOException ioException) {
			throw new ApplicationException(ioException);
		}

	}

}
