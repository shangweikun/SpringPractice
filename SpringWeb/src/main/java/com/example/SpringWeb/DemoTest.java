package com.example.SpringWeb;

public class DemoTest {

	public static InnerData A = new InnerData();
	private final int a = 0;

	public static class Data {
	}

	public class Data1 {
		void test() {
			System.out.println(DemoTest.this.a);
		}
	}

	public static void main(String[] args) {
		DemoTest app = new DemoTest();
		Data1 data1 = app.new Data1();
		Data data = new Data();
		System.out.println(data);
		System.out.println(A);
		data1.test();

	}
}
