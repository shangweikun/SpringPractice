package com.example.SpringWeb.java8demo.capter10;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class Demo {

	public static class Person {
		@Getter
		@Setter
		String personName;

		@Getter
		@Setter
		Car car;

		public Optional<Car> getCarAsOptional() {
			return Optional.of(this.car);
		}
	}

	public static class Car {
		@Getter
		@Setter
		String carName;

		@Getter
		@Setter
		Insurance insurance;

		public Optional<Insurance> getInsuranceAsOptional() {
			return Optional.of(this.insurance);
		}


	}

	public static class Insurance {
		@Getter
		@Setter
		String insName;
	}

	public static void main(String[] args) {
		Person person1 = new Person();
		person1.setPersonName("person1");
		Car car1 = new Car();
		car1.setCarName("car1");
		Insurance insurance1 = new Insurance();
		insurance1.setInsName("insurance1");

		person1.setCar(car1);
		car1.setInsurance(insurance1);

		Optional<Person> optPerson = Optional.of(person1);
		String insName = optPerson
				.flatMap(Person::getCarAsOptional)
				.flatMap(Car::getInsuranceAsOptional)
				.map(Insurance::getInsName)
				.orElse("unknown");
		System.out.println(insName);
	}
}
