package com.example.SpringWeb.java8demo;

import com.example.SpringWeb.java8demo.capter1.Apple;
import com.example.SpringWeb.java8demo.capter1.ApplePredicate;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static <T> List filterApple(List<T> inventory, ApplePredicate<T> predicate) {
		inventory.removeIf((T t) -> !predicate.test(t));
		return inventory;
	}

	public static void main(String[] args) {
		Apple a = new Apple(140, "GREEN");
		Apple b = new Apple(160, "Red");
		List<Apple> inventory = new ArrayList<>();
		inventory.add(a);
		inventory.add(b);
		filterApple(inventory, new ApplePredicate<Apple>() {
			@Override
			public boolean test(Apple a) {
				return 150 > a.getWeight();
			}
		});
		filterApple(inventory, (Apple a1) -> "Red".equals(a1.getColor()));
		System.out.println(inventory.size());
		inventory.sort((Apple a1, Apple a2) -> a1.getWeight() - a2.getWeight());
	}
}
