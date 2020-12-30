package com.example.SpringWeb;

import com.example.SpringWeb.AtoBtest.A;
import com.example.SpringWeb.AtoBtest.B;
import com.example.SpringWeb.AtoBtest.Page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.util.StreamUtils.toUnmodifiableList;

public class AppDemo0 {

	private static AppDemo0 app = new AppDemo0();

	public static void main(String[] args) {
		A a = new A();
		List result = new Page<>("test");
		Iterator ite = result.iterator();
		result.add(a);

		//Error
//		Supplier<Page> supplier = (s) -> {
//			return new Page(s);
//		};
//		result.stream().map(it -> app.AtoB((A) it)).collect(Page::new, ArrayList::add, ArrayList::addAll);

		result.stream().forEach(System.out::println);


//		while (it.hasNext()) {
//			result.add(app.AtoB((A) it.next()));
//			it.remove();
//		}

//		result.stream().iterator();


/**
 *      for (Object obj : result
 * 		    ) {
 * 			result.add(app.AtoB((A) obj));
 * 			result.remove(obj);
 *      }
 */


//		test(result);


/*
		List result2 = (List) result.stream().map(it -> app.AtoB((A) it)).collect(toList());
		IntStream.range(0, result.size()).forEach(i -> app.transformer(i, result));
		System.out.println(((Page) result).getFlag());
//		System.out.println(((Page) result2).getFlag());

//		result.stream().forEach(it -> app.transformer(it, result));

		System.out.println(result.hashCode());
		System.out.println(result2.hashCode());

		result.stream().forEach(System.out::println);
		result2.stream().forEach(System.out::println);


*/
	}

	// ERROR

	/**
	 * Exception in thread "main" java.util.ConcurrentModificationException
	 * at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1631)
	 * at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:658)
	 * at com.example.SpringWeb.AppDemo0.test(AppDemo0.java:48)
	 * at com.example.SpringWeb.AppDemo0.main(AppDemo0.java:23)
	 */
	private static void test(List result) {
		System.out.println("test begin");
		result.stream().forEach(it -> app.transformer(it, result));
		result.stream().forEach(System.out::println);
		System.out.println("test end");
	}

	private static void test1(List result) {
		System.out.println("test begin");
		result.stream().forEach(it -> app.transformer(it, result));
		result.stream().forEach(System.out::println);
		System.out.println("test end");
	}

	void transformer1(Object it, List target) {
		target.add(app.AtoB((A) it));
	}

	void transformer(Object it, List target) {
		target.add(app.AtoB((A) it));
		target.remove(it);
	}

	void transformer(int point, List target) {
		target.set(point, AtoB((A) target.get(point)));
	}

	B AtoB(A a) {
		return new B();
	}
}
