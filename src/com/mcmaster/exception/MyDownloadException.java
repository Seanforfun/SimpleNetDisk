package com.mcmaster.exception;

public class MyDownloadException extends Exception {

	public MyDownloadException() {
		super();
	}

	public MyDownloadException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public MyDownloadException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MyDownloadException(String arg0) {
		super(arg0);
	}

	public MyDownloadException(Throwable arg0) {
		super(arg0);
	}

}
