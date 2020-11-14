package test.world.spring.hello.springtest.deputy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class DemoCglibProxy implements MethodInterceptor {

	public Object createProxy(Class<?> clazz){
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);

		return enhancer.create();
	}

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

		System.out.println("<<<<    intercept begin    <<<<");
		Annotation[] annotations = method.getAnnotations();
		for(Annotation annotation : annotations){
			System.out.println("<<<<    annotation is here    <<<<");
			if(annotation instanceof RedisDemo){
				System.out.println("connect");
			}
		}
		System.out.println("<<<<    intercept end    <<<<");

//		return methodProxy.invoke(o,objects);    error 循环处理拦截方法。
		return methodProxy.invokeSuper(o,objects);
	}
}
