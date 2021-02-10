package com.example.SpringWeb;

import com.example.SpringWeb.java8demo.capter6.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

public class Test2 {

	enum CaloricLevel {
		DIET, NORMAL, FAT
	}

	public static void joiningTest() {
		Dish dish1 = new Dish("dish1", 0);
		Dish dish2 = new Dish("dish2", 0);
		List<Dish> list = new ArrayList<>();
		list.add(dish1);
		list.add(dish2);

		String result = list.stream()
				.map(Dish::getName)
				.collect(joining(", "));

		System.out.println(result);
	}

	public static void reducingTest() {
		Dish dish1 = new Dish("dish1", 10);
		Dish dish2 = new Dish("dish2", 20);
		Dish dish3 = new Dish("dish2", 30);

		List<Dish> list = new ArrayList<>();
		list.add(dish1);
		list.add(dish2);
		list.add(dish3);

		int result = list.stream()
				.collect(reducing(0, Dish::getCalories, Integer::sum));
		int result1 = list.stream()
				.map(Dish::getCalories).reduce(0, Integer::sum);

		System.out.println(result == result1);
	}

	public static void groupingTest() {
		Dish dish1 = new Dish("dish1", 10);
		Dish dish2 = new Dish("dish2", 20);

		Dish[] dishes = {dish1, dish2};

		Map<CaloricLevel, List<Dish>> result = Arrays.stream(dishes)
				.collect(
						groupingBy(ts ->
								{
									if (ts.getCalories() > 15) return CaloricLevel.FAT;
									return CaloricLevel.NORMAL;
								}
						));
		System.out.println(result.toString());
	}

	public static void countTest() {
		List<String> menu = new ArrayList<>();
		menu.add("1");
		long count = menu.stream().collect(counting());
		long count2 = menu.stream().count();

		System.out.println(count + count2);
	}

	public static void main(String[] args) {
		/*
		joiningTest();
		reducingTest();
		*/
		groupingTest();
	}
}
