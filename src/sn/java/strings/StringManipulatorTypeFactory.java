package sn.java.strings;

import java.util.List;

import sn.java.strings.iface.IStringManipulator;

public enum StringManipulatorTypeFactory {
	INSTANCE;
	
	public IStringManipulator getStringManipulator(String manipulatorType, List<String> contentsToManipulate) {
		
		switch(manipulatorType) {
		
		case "SIMPLE":
			return new SimpleStringManipulator(contentsToManipulate);
		default:
			return null;
		
		}
		
	}

}
