package com.example.SpringWeb.proxy.jdk;

public interface Car {
	default void say(){
		System.out.println("I'm car and run");
	}
}
