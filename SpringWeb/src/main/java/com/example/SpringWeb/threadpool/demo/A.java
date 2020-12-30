package com.example.SpringWeb.threadpool.demo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Table(name = "A")
public class A {

	@Column(name = "A1")
	String A1;

	@Column(name = "A2")
	String A2;
}
