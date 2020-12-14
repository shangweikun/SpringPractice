package com.example.SpringWeb.aopdemo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

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
}
