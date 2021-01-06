package com.example.SpringWeb.java8demo.capter3;

import com.example.SpringWeb.java8demo.capter1.Apple;
import com.example.SpringWeb.java8demo.capter3.lambdaTest.AppleComparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

public class Demo1 {

	public static void main(String[] args) {
		Apple apple1 = new Apple();
		Apple apple2 = new Apple();
		apple1.setWeight(100);
		apple2.setWeight(200);
		List<Apple> apples = new ArrayList<>();

		apples.add(apple2);
		apples.add(apple1);
		/** 第1步 增加比较器类 **/
		AppleComparator comparator = new AppleComparator();
		apples.sort(comparator);

		apples.clear();
		apples.add(apple2);
		apples.add(apple1);
		/** 第2步 匿名内部类 **/
		apples.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		});

		apples.clear();
		apples.add(apple2);
		apples.add(apple1);
		/** 第3步 使用lambda表达式 **/
		apples.sort((o1,o2)->o1.getWeight().compareTo(o2.getWeight()));
		apples.sort(comparing(o1->o1.getWeight()));

		apples.clear();
		apples.add(apple2);
		apples.add(apple1);
		/** 第4步 方法引用引入 **/
		apples.sort(comparing(Apple::getWeight));


	}
}
