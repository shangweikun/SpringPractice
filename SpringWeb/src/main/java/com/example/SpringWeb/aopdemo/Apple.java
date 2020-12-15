package com.example.SpringWeb.aopdemo;

import org.springframework.stereotype.Component;

@Component
public class Apple implements Fruit{
	@Override
	public void eat() {
		System.out.println("I'm eating Apple");
	}
}
