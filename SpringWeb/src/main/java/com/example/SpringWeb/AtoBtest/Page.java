package com.example.SpringWeb.AtoBtest;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Page<E> extends ArrayList<E> {
	@Setter
	@Getter
	String flag;

	public Page(String s) {
		super();
		this.flag = s;
	}

	public Page(Page p) {
		super();
		this.flag = p.flag;
	}

	public Page(Object obj) throws Exception {
		this(objToString(obj));
	}

	private static Page objToString(Object obj) throws Exception {
		if (obj instanceof Page) {
			return (Page) obj;
		}
		throw new Exception();
	}
}
