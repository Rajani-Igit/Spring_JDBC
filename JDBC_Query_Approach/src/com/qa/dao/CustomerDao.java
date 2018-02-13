package com.qa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.qa.bo.CustomerBo;

public class CustomerDao {
	private JdbcTemplate jdbctemplate;
	private GeneratedKeyHolder gkh;
	private final String GET_CUSTOMERS_COUNT = "SELECT COUNT(1) FROM CUSTOMER";
	private final String GET_CUSTOMERNAME_BY_PHONENO = "SELECT customer_fname FROM CUSTOMER WHERE customer_no=?";
	private final String FIND_CUSTOMER_BYID = "SELECT customer_no, customer_fname, customer_lname,customer_mailid,customer_phoneno FROM CUSTOMER WHERE customer_no=?";
	private final String GET_CUSTOMERS = "SELECT  customer_no, customer_fname, customer_lname,customer_mailid,customer_phoneno FROM CUSTOMER";
	private final String SQL_INSERT_CUSTOMER = "INSERT INTO CUSTOMER (customer_fname, customer_lname,customer_mailid,customer_phoneno) VALUES(?,?,?,?)";

	CustomerDao(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public int getCustomeCount() {
		return jdbctemplate.queryForObject(GET_CUSTOMERS_COUNT, Integer.class);
	}

	public String findNamebyCustomerNo(int id) {
		return jdbctemplate.queryForObject(GET_CUSTOMERNAME_BY_PHONENO, new Object[] { 2 }, String.class);

	}

	public CustomerBo findcustomerbyId(int id) {
		return jdbctemplate.queryForObject(FIND_CUSTOMER_BYID, new Object[] { 2 }, new RowMapper<CustomerBo>() {

			@Override
			public CustomerBo mapRow(ResultSet rs, int arg1) throws SQLException {

				CustomerBo customer = null;
				customer = new CustomerBo();
				customer.setCustomerNo(rs.getInt(1));
				customer.setfName(rs.getString(2));
				customer.setlName(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setPhNo(rs.getString(5));
				return customer;
			}

		});
	}

	public List<CustomerBo> getCustomers() {

		return jdbctemplate.query(GET_CUSTOMERS, new RowMapper<CustomerBo>() {

			@Override
			public CustomerBo mapRow(ResultSet rs, int count) throws SQLException {
				// TODO Auto-generated method stub
				CustomerBo customer = null;
				customer = new CustomerBo();
				customer.setCustomerNo(rs.getInt(1));
				customer.setfName(rs.getString(2));
				customer.setlName(rs.getString(3));
				customer.setEmail(rs.getString(4));
				customer.setPhNo(rs.getString(5));
				return customer;
			}

		});

	}

	public int saveCustomer(CustomerBo cbo) {
		return jdbctemplate.update(SQL_INSERT_CUSTOMER, cbo.getfName(), cbo.getlName(), cbo.getPhNo(), cbo.getEmail());
	}

	public int saveCustomerandgetId(CustomerBo cbo) {
		gkh = new GeneratedKeyHolder();

		int records = jdbctemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement ps = con.prepareStatement(SQL_INSERT_CUSTOMER, new String[] { "customer_no" });
				ps.setString(1, cbo.getfName());
				ps.setString(2, cbo.getlName());
				ps.setString(3, cbo.getlName());
				ps.setString(4, cbo.getEmail());

				return ps;
			}

		}, gkh);
		System.out.println(gkh.getKeyList());
		return records;
	}
}
