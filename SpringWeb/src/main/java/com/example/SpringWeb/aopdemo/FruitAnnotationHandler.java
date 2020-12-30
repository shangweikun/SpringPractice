package com.example.SpringWeb.aopdemo;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.lang.reflect.Field;

@Component
@Aspect
public class FruitAnnotationHandler {

	@Pointcut("execution(* com.example.SpringWeb.aopdemo.Fruit.*(..))")
	public void eatFruit() {
	}

	@Before("eatFruit()")
	public void beforeEatFruit() {
		System.out.println("I'm ready to eat fruit" + this.hashCode());
	}

	@After("eatFruit()")
	public void afterEatFruit() {
		System.out.println("I have eat fruit" + this.hashCode());
	}

	@AfterReturning(pointcut = "eatFruit()", returning = "returnValue")
	public void afterReturnEatFruit(Object returnValue) throws NoSuchFieldException, IllegalAccessException {
		if (returnValue instanceof Apple) {
			System.out.println("I have eat Apple");
		}

		Field field;
		if (!ObjectUtils.isEmpty((field = returnValue.getClass().getField("a")))) {
			System.out.println(field.get(returnValue));
		}
	}

}
