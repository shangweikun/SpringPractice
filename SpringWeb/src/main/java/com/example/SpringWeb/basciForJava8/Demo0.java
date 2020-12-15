package com.example.SpringWeb.basciForJava8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Demo0 {

	private static final Demo0 demo = new Demo0();

	@Data
	@AllArgsConstructor
	class Apple {
		int weight;
		String color;
	}

	static boolean isGreenApple(Apple apple) {
		return "Green".equals(apple.getColor());
	}

	static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		inventory.stream().forEach(apple -> {
			if(p.test(apple)){
				result.add(apple);
			}
		});
		return result;
	}

	public static void demo0Test() {
		System.out.println("demo0Test BEGIN");
		Apple greenApple = demo.new Apple(50, "Green");
		Apple redApple = demo.new Apple(200, "Red");
		List<Apple> apples  = Arrays.asList(greenApple,redApple);
		List<Apple> filerGreenApples = filterApples(apples, Demo0::isGreenApple);
		filerGreenApples.stream().forEach(apple-> System.out.println(apple.getColor()));
		List<Apple> filerHeavyApples = filterApples(apples, Demo0::isHeavyApple);
		filerHeavyApples.stream().forEach(apple-> System.out.println(apple.getWeight()));
		System.out.println("demo0Test END");
	}
}
