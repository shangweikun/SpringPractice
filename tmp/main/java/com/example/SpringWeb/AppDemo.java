package com.example.SpringWeb;

import com.example.SpringWeb.proxy.jdk.BMWCar;
import com.example.SpringWeb.proxy.jdk.Car;
import com.example.SpringWeb.proxy.jdk.MyInvocationHandle;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Proxy;

public class AppDemo {

	public static void test1() {
		BMWCar car1 = new BMWCar();
		MyInvocationHandle handle = new MyInvocationHandle(car1);
		Car car2 = (Car) Proxy.newProxyInstance(
				car1.getClass().getClassLoader(), car1.getClass().getInterfaces(), handle);
		car1.say();
		car2.say();
		System.out.println(car1.getClass() + ":" + car1.hashCode());
		System.out.println(car2.getClass() + ":" + car2.hashCode());
	}

	public static void test2() throws Exception {
		String param = "[{\"test\":\"1\"},{\"test\":\"2\"},{\"test\":\"2\"}]";
		ObjectMapper objectMapper = new ObjectMapper();
		Test[] tests = objectMapper.readValue(param,Test[].class);
		objectMapper.readValue(null,null);
	}

	public static void main(String[] args) {

	}
}
