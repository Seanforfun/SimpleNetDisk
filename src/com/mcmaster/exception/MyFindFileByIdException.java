package com.mcmaster.exception;

public class MyFindFileByIdException extends Exception {

	public MyFindFileByIdException() {
		super();
	}

	public MyFindFileByIdException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MyFindFileByIdException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MyFindFileByIdException(String arg0) {
		super(arg0);
	}

	public MyFindFileByIdException(Throwable arg0) {
		super(arg0);
	}

}
