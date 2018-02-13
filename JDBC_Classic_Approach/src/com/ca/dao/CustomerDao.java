package com.ca.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.ca.bo.CustomerBo;

public class CustomerDao {
	private JdbcTemplate jdbcTemplate;
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public List<CustomerBo> getCustomers(){
		return	jdbcTemplate.execute("select * from customer", new Customercallback());
		
	} 
	
	public int addCustomer(CustomerBo customer){
		CustomerPreparedstatementCreator  customerPreparedstatementCreator =new CustomerPreparedstatementCreator(); 
		customerPreparedstatementCreator.setCustomer(customer);
		return  jdbcTemplate.execute(customerPreparedstatementCreator, new AddCustomerPreparedStatementCallback());
		
	}
	private final class AddCustomerPreparedStatementCallback implements PreparedStatementCallback<Integer>{

		@Override
		public Integer doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			
			return pstmt.executeUpdate();
		}
		
	}
	
	private final class CustomerPreparedstatementCreator implements  PreparedStatementCreator{
        CustomerBo customer;
        
		public CustomerBo getCustomer() {
			return customer;
		}

		public void setCustomer(CustomerBo customer) {
			this.customer = customer;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement ps=con.prepareStatement("INSERT INTO CUSTOMER (customer_no,customer_fname,customer_lname,customer_phoneno,customer_mailid) VALUES(?,?,?,?,?)");
			ps.setInt(1, customer.getCustomerNo());
			ps.setString(2,customer.getFirstName() );
			ps.setString(3,customer.getLastName());
			ps.setString(4,customer.getPhNo());
			ps.setString(5,customer.getEmail());
			return ps;
		}
		
	}
	
	
	private final  class Customercallback implements PreparedStatementCallback<List<CustomerBo>>{
      private List<CustomerBo> customers;
      CustomerBo customer;
		@Override
		public List<CustomerBo> doInPreparedStatement(PreparedStatement pstmt) throws SQLException, DataAccessException {
			ResultSet rs=pstmt.executeQuery();
			customers=new ArrayList<>();
			while(rs.next()){
				customer=new CustomerBo();
				customer.setCustomerNo(rs.getInt("CUSTOMER_NO"));
				customer.setFirstName(rs.getString("customer_fname"));
				customer.setLastName(rs.getString("customer_lname"));
				customer.setEmail(rs.getString("customer_mailid"));
				customer.setPhNo(rs.getString("customer_phoneno"));
				customers.add(customer);
			}
			return customers;
		}
		
	}
	private  final class FetchdatCallablestatementCreator implements CallableStatementCreator{

		@Override
		public CallableStatement createCallableStatement(Connection con) throws SQLException {
			con.prepareCall("{? = call f_calculate}");
			return null;
		}
		
	}

}
