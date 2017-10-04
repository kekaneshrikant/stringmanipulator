package sn.java.strings;

import java.util.ArrayList;
import java.util.List;

import sn.java.strings.iface.IStringManipulator;

public class SimpleStringManipulator implements IStringManipulator {

	private List<String> stringsList;

	public SimpleStringManipulator(List<String> contentsToManipulate) {
		this.stringsList = contentsToManipulate;
	}

	@Override
	public List<String> manipulate() {
		List<String> manipulatedStringList = new ArrayList<>();
		for (String string : this.stringsList) {

			StringBuffer stringBuffer = new StringBuffer("");
			String[] wordsArray = string.split(" ");
			for (String word : wordsArray) {
				stringBuffer.append(word.substring(0, 1).toUpperCase() + word.substring(1)).append(" ");
			}
		manipulatedStringList.add(stringBuffer.toString().substring(0, stringBuffer.length() - 1));
		}
		return manipulatedStringList;
	}

}
