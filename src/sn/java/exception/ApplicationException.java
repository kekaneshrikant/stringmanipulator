package sn.java.exception;

public class ApplicationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -539767120402781998L;

	public ApplicationException(Exception exception) {
		System.out.println(exception.toString());
	}

	public ApplicationException(String string) {
		System.out.println(string);
	}

}
