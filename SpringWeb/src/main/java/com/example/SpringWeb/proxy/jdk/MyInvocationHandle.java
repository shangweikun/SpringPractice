package com.example.SpringWeb.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandle implements InvocationHandler {

	private Object target;

	public MyInvocationHandle(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		//pre Aop
		System.out.println("pre Aop is here");

		//void method do not need return
		Object obj = method.invoke(this.target, args);

		//ago Aop
		System.out.println("ago Aop is here");

		return obj;
	}
}
