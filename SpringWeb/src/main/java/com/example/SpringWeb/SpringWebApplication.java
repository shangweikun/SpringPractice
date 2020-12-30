package com.example.SpringWeb;

import com.example.SpringWeb.aopdemo.Apple;
import com.example.SpringWeb.aopdemo.Fruit;
import com.example.SpringWeb.threadpool.demo.A;
import com.example.SpringWeb.threadpool.demo.service.AService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@ComponentScan("com.example.SpringWeb.*")
public class SpringWebApplication {

	public /*static*/ void main(String[] args) {
		/*
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringWebApplication.class, args);
		Fruit apple = (Fruit) context.getBean(Apple.class);
		apple.eat();
		*/
		/*
		Object obj;
		while(true){
			 obj = new Object();
		}
		*/
		ConfigurableApplicationContext context =
				SpringApplication.run(SpringWebApplication.class, args);
		final AService service = context.getBean(AService.class);
		System.out.println(service.updateA("1_1"));
		ThreadPoolExecutor pool = new ThreadPoolExecutor(
				5, 5, 10L, TimeUnit.MINUTES,
				new LinkedBlockingQueue<>());
		Thread thread1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				pool.submit(() -> {
					System.out.println(service.updateA("1_1"));
				});
			}
		});
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				pool.submit(() -> {
					System.out.println(service.updateA("1_1"));
				});
			}
		});
		thread2.start();
		thread1.start();
	}
}
