package com.pa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component("customerDao")
public class CustomerDao {
@Autowired
private JdbcTemplate jdbcTemplate;
public int findCustomerCount(){
	return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM CUSTOMER",Integer.class);
}

}
