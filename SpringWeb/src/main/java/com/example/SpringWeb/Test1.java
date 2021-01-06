package com.example.SpringWeb;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {

	public static void fileTest() {
		long uniqueWords = 0;
		try (Stream<String> lines
				     = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
					.distinct()
					.count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(uniqueWords);
	}


	public static void fibonacciSequence() {
		Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
				.limit(10)
				.map(t -> t[0])
				.forEach(System.out::println);
	}

	public static void fibonacciSequence2() {

		IntSupplier fib = new IntSupplier() {
			private int previous = 0;
			private int current = 1;

			@Override
			public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		};
		IntStream.generate(fib).limit(10).forEach(System.out::println);
	}

	public static void main(String[] args) {
		fibonacciSequence2();
	}
}
