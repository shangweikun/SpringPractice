package com.example.SpringWeb;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Test0 {

	public static int sum(int[] numbers) {
		int result = Arrays.stream(numbers).reduce(0, (a, b) -> a + b);
		return result;
	}

	public static int max(int[] numbers) {
		OptionalInt max = Arrays.stream(numbers).reduce(Integer::max);
		return max.getAsInt();
	}

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("a");
		strings.add("ab");
		strings.add("abc");
		strings.add("abcd");
		List<String> strings2 = strings.stream()
				.filter(s -> s.equals("target") || s.length() > 2)
				.map(s -> s.substring(1))
				.collect(toList());
		for (String s : strings2
		) {
			System.out.println(s);
		}

		Stream<String> stream = strings.stream();
		stream.forEach(System.out::println);
		//java.lang.IllegalStateException
		//stream.forEach(System.out::println);

		String[] arrays = {"Hello", " world"};
		Stream<String> stream3 = Arrays.stream(arrays);
		List<Stream> streams = stream3
				.map(s -> s.split(""))
				.map(Arrays::stream)
				.distinct()
				.collect(toList());
		stream3 = Arrays.stream(arrays);
		List<String> strings3 = stream3
				.map(s -> s.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(toList());
		streams.forEach(System.out::println);
		strings3.forEach(System.out::println);

		strings3.stream()
				.findAny();

		int[] numbers = {1, 2, 3, 4, 5};
		System.out.println(sum(numbers));

		String[] dishes = {};
		Arrays.stream(dishes).map(d -> 1).reduce(0, (a, b) -> a + b);

		int a = 3;
		Stream<int[]> ints = IntStream.range(1, 100)
				.filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
				.boxed()
				.map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)});


	}

}
