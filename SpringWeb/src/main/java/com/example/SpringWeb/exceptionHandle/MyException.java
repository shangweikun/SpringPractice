package com.example.SpringWeb.exceptionHandle;

public class MyException extends Exception {
	public MyException() {
		super();
		System.out.println("MyException init");
	}

	public MyException(Exception e) {
		super(e);
		System.out.println("MyException init");
	}
}
