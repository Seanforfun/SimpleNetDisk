package com.mcmaster.exception;

public class DownloadException extends Exception {

	public DownloadException() {
		super();
	}

	public DownloadException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public DownloadException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public DownloadException(String arg0) {
		super(arg0);
	}

	public DownloadException(Throwable arg0) {
		super(arg0);
	}

}
