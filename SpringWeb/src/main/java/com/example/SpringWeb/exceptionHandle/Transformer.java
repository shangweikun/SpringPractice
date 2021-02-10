package com.example.SpringWeb.exceptionHandle;

public interface Transformer<T> {

	String RESULT_CODE = "ResCode";
	String ERROR_CODE = "ErrCode";
	String ERROR_MESSAGE = "ErrMsg";

	T myExceptionToTarget(Exception e);
}
