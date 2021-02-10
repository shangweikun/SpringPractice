package com.example.SpringWeb.exceptionHandle;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.example.SpringWeb.exceptionHandle.ExceptionHandler.assembleException;

public class ExcToMapTransformer implements Transformer<Map> {

	@Override
	public Map<String, Object> myExceptionToTarget(Exception e) {
		Map<String, Object> mapResult = new LinkedHashMap<>();
		MyException myException = assembleException(e);
		mapResult.put(RESULT_CODE, false);
		mapResult.put(ERROR_MESSAGE, myException.getMessage());
		return mapResult;
	}
}
