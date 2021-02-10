package com.example.SpringWeb.java8demo;

import com.example.SpringWeb.java8demo.capter6.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collectors.*;

public class Demo6 {

	public static int count = 0;

	public static Collector<Object, ArrayList<Object>, ArrayList<AExtend>> collector = new Collector<Object, ArrayList<Object>, ArrayList<AExtend>>() {
		@Override
		public Supplier<ArrayList<Object>> supplier() {
			return ArrayList::new;
		}

		@Override
		public BiConsumer<ArrayList<Object>, Object> accumulator() {
			return List::add;
		}

		@Override
		public BinaryOperator<ArrayList<Object>> combiner() {
			return (list1, list2) -> {
				list1.addAll(list2);
				return list1;
			};
		}

		@Override
		public Function<ArrayList<Object>, ArrayList<AExtend>> finisher() {
			return (list1) -> {
				ArrayList<AExtend> list2 = new ArrayList<>();
				for (Object o : list1) {
					A tmp = (A) o;
					AExtend result = new AExtend();
					result.a1 = tmp.a1;
					result.a2 = String.valueOf(count++);
					list2.add(result);
				}
				return (ArrayList<AExtend>) list2;
			};
		}

		//IDENTITY_FINISH 表示完成器返回一个恒等值，会跳过finisher的方法执行
		@Override
		public Set<Characteristics> characteristics() {
			return Collections.unmodifiableSet(EnumSet.of(
					CONCURRENT
			));
		}
	};

	@AllArgsConstructor
	public static class A {
		public String a1;
	}

	@Data
	public static class AExtend {
		public String a1;
		public String a2;
	}

	public static void testCollector() {
		List<A> param = Arrays.asList(new A("test1"), new A("test2"));
		List<AExtend> result = param.stream().collect(collector);
		for (AExtend aExtend : result) {
			System.out.println(aExtend.toString());
		}
	}

	public static void main(String[] args) {
		List<Dish> dishes = Arrays.asList(new Dish("Pizza", 100),
				new Dish("Hamburger", 200));
		Map<String, Set<String>> result = dishes.stream().collect(groupingBy(Dish::getName, mapping(dish -> {
			if (dish.getCalories() > 150) return "High";
			else return "Low";
		}, toCollection(HashSet::new))));
		result.forEach((a, b) -> System.out.println(a + b));

		Map<Boolean, List<Dish>> result2 =
				dishes.stream().collect(partitioningBy(dish -> dish.getCalories() > 150));
		result2.forEach((a, b) -> System.out.println(a.toString() + b));

		System.out.println("<<<<<<<<<<<<<testCollector<<<<<<<<<<<<<");
		testCollector();
	}
}
