package com.sji.dao;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.sji.bo.CustomerBo;

public class CustomerDao {
private SimpleJdbcInsert sji;

public void setSji(SimpleJdbcInsert sji) {
	this.sji = sji;
}
public int savecustomer(CustomerBo cbo){
	return sji.execute(new BeanPropertySqlParameterSource(cbo));
}

}
