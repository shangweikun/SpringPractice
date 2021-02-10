package com.example.SpringWeb.exceptionHandle;

public class ExceptionHandler {

	public static MyException assembleException(Exception e) {
		MyException myException;
		if (e instanceof MyException) {
			myException = (MyException) e;
		} else {
			myException = handleException(e);
		}
		return myException;
	}

	private static MyException handleException(java.lang.Exception e) {
		MyException finallyException = new MyException();
		if (e instanceof RuntimeException) {

		} else if (e instanceof Exception) {

		}
		return finallyException;
	}

	public static MyException assembleException(Exception e, Result result) {
		return null;
	}
}
