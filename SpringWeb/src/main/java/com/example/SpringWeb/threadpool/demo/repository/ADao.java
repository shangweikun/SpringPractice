package com.example.SpringWeb.threadpool.demo.repository;

import com.example.SpringWeb.threadpool.demo.A;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ADao {

	@Resource
	private JdbcTemplate jdbcTemplate;

	public A findByKey(String key) {
		String querySQL = "select A1,A2 from A where A1=?";
		RowMapper<A> rowMapper = new BeanPropertyRowMapper<>(A.class);
		A vo = jdbcTemplate.queryForObject(querySQL, new Object[]{key}, rowMapper);
		return vo;
	}

	public int updateByValue(String value) {
		String updateSQL = "update A set A1 = A1+1 where A2=?";
		int result = jdbcTemplate.update(updateSQL, value);
		return result;
	}


}
