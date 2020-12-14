package com.example.SpringWeb;

import com.example.SpringWeb.aopdemo.Apple;
import com.example.SpringWeb.aopdemo.Fruit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
//@ComponentScan("com.example.SpringWeb.*")
public class SpringWebApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringWebApplication.class, args);
		Fruit apple = (Fruit) context.getBean(Apple.class);
		apple.eat();
		/*
		Object obj;
		while(true){
			 obj = new Object();
		}
		*/
	}

}
