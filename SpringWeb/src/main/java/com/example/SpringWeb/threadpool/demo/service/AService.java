package com.example.SpringWeb.threadpool.demo.service;

import com.example.SpringWeb.threadpool.demo.A;
import com.example.SpringWeb.threadpool.demo.repository.ADao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AService {

	@Resource
	public ADao dao;

	public A findA(String key){
		return dao.findByKey(key);
	}

	public int  updateA(String value){
		return dao.updateByValue(value);
	}
}
