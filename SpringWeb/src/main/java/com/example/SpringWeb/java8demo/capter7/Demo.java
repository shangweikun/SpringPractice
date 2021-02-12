package com.example.SpringWeb.java8demo.capter7;

import java.util.stream.LongStream;

public class Demo {

	/**
	 * Demo有一个静态成员，Accumulator的静态内部类，在堆上分配的
	 */
	static class Accumulator {
		public long total = 0;

		public void add(long value) {
			total += value;
		}
	}

	public static void main(String[] args) {
		Accumulator accumulator = new Demo.Accumulator();
		LongStream.rangeClosed(0L, 100000L).parallel().forEach(accumulator::add);
		System.out.println(accumulator.total);
	}

	public static void test() {
		Accumulator accumulator1 = new Accumulator();
		Accumulator accumulator2 = new Accumulator();
		System.out.println(accumulator1.hashCode());
		System.out.println(accumulator2.hashCode());
	}
}
