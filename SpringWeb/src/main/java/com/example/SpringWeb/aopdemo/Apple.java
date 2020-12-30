package com.example.SpringWeb.aopdemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Apple implements Fruit {

	public int a;

	@Override
	public Fruit eat() {
		System.out.println("I'm eating Apple");
		return this;
	}
}
