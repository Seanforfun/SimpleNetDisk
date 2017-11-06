package com.mcmaster.exception;

public class MyDeleteException extends Exception {

	public MyDeleteException() {
		super();
	}

	public MyDeleteException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MyDeleteException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MyDeleteException(String arg0) {
		super(arg0);
	}

	public MyDeleteException(Throwable arg0) {
		super(arg0);
	}

}
