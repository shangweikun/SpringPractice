package com.example.SpringWeb;

import com.example.SpringWeb.aopdemo.Fruit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemoApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:spring5-fruit.xml");
		Fruit apple = (Fruit) applicationContext.getBean("apple");
		apple.eat();
	}
}
