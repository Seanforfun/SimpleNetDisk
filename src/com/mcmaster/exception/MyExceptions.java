package com.mcmaster.exception;

public class MyExceptions extends Exception {

	public MyExceptions() {
		super();
	}

	public MyExceptions(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MyExceptions(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MyExceptions(String arg0) {
		super(arg0);
	}

	public MyExceptions(Throwable arg0) {
		super(arg0);
	}

}
