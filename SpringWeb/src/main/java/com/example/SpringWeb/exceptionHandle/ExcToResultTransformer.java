package com.example.SpringWeb.exceptionHandle;

import static com.example.SpringWeb.exceptionHandle.ExceptionHandler.assembleException;

public class ExcToResultTransformer implements Transformer<Result> {

	@Override
	public Result myExceptionToTarget(Exception e) {
		Result result = new Result();
		MyException myException = assembleException(e);
		result.setCode(false);
		result.setErrMsg(myException.getMessage());
		return result;
	}
}
