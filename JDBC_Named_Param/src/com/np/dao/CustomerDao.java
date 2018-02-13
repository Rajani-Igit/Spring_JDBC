package com.np.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.np.bo.CustomerBo;

public class CustomerDao {
	private NamedParameterJdbcTemplate npjdbctemplate;
	// Here in this case the named parameters be same as the name of the
	// attributes of customerBo
	private final String SQL_INSERT_Customer_using_BeanPropertySource = "INSERT INTO customer (customer_no, customer_fname, customer_lname, customer_phoneno, customer_mailid) values(:customerNo,:firstName,:lastName,:mobile,:email)";
	private final String SQL_INSERT_Customer = "INSERT INTO customer (customer_no, customer_fname, customer_lname, customer_phoneno, customer_mailid) values(:customerNo,:fName,:lName,:mob,:email)";
	private final String SQL_FIND_CUSTOMER_BY_No = "SELECT customer_no, customer_fname, customer_lname, customer_phoneno, customer_mailid FROM CUSTOMER WHERE customer_no= :cno";
	private HashMap<String, Object> params;
    private final String SQL_INSERT_Date_Query="INSERT INTO employee(firstname, last_name, mail, password, contactno, status, join_date) values(:firstname, :last_name, :mail, :password, :contactno, :status, :join_date)";
	private final String  SQL_FETCH_Date_Query="SELECT firstname, last_name, mail, password, contactno, status, join_date FROM employee WHERE firstname=:fname";
    public NamedParameterJdbcTemplate getNpjdbctemplate() {
		return npjdbctemplate;
	}

	public void setNpjdbctemplate(NamedParameterJdbcTemplate npjdbctemplate) {
		this.npjdbctemplate = npjdbctemplate;
	}

	public int saveCustomer(CustomerBo cbo) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		/*
		 * params=new HashMap<>(); params.put("customerNo",
		 * cbo.getCustomerNo()); params.put("fName", cbo.getFirstName());
		 * params.put("lName",cbo.getLastName()); params.put("mob",
		 * cbo.getMobile()); params.put("email", cbo.getEmail()); return
		 * npjdbctemplate.update(SQL_INSERT_Customer, params);
		 */
		params.addValue("customerNo", cbo.getCustomerNo());
		params.addValue("fName", cbo.getFirstName());
		params.addValue("lName", cbo.getLastName());
		params.addValue("mob", cbo.getMobile());
		params.addValue("email", cbo.getEmail());
		return npjdbctemplate.update(SQL_INSERT_Customer, params);
	}

	public int saveCustomerUsingBeanPropertySource(CustomerBo cbo) {
		BeanPropertySqlParameterSource parameterSource = new BeanPropertySqlParameterSource(cbo);
		return npjdbctemplate.update(SQL_INSERT_Customer_using_BeanPropertySource, parameterSource);

	}

	public CustomerBo findCustomer(int no) {

		return npjdbctemplate.queryForObject(SQL_FIND_CUSTOMER_BY_No, new MapSqlParameterSource().addValue("cno", no),
				new RowMapper<CustomerBo>() {
					CustomerBo cbo = new CustomerBo();

					@Override
					public CustomerBo mapRow(ResultSet rs, int count) throws SQLException {
						cbo.setCustomerNo(rs.getInt(1));
						cbo.setFirstName(rs.getString(2));
						cbo.setLastName(rs.getString(3));
						cbo.setMobile(rs.getString(4));
						cbo.setEmail(rs.getString(5));

						return cbo;
					}
				});
	}
	
	
	public int insertData(String firstname, String last_name,String mail, String password, String contactno, int status,Date date){
		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("firstname", firstname);
		params.addValue("last_name", last_name);
		params.addValue("mail", mail);
		params.addValue("password", password);
		params.addValue("contactno", contactno);
		params.addValue("status", status);
		params.addValue("join_date", new java.sql.Date(date.getTime()));
		return npjdbctemplate.update(SQL_INSERT_Date_Query, params);
	}

	
	public CustomerBo fetchdate(String name){
		
MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("fname", name);
		return npjdbctemplate.query(SQL_FETCH_Date_Query,params,new ResultSetExtractor<CustomerBo>() {

			@Override
			public CustomerBo extractData(ResultSet rs) throws SQLException, DataAccessException {
				while(rs.next()){// TODO Auto-generated method stub
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getString(5));
				System.out.println(rs.getInt(6));
				System.out.println(rs.getDate(7));
				Date date=new Date(rs.getDate(7).getTime());
				String datef=new SimpleDateFormat("dd/MM/yyyy").format(date);
				System.out.println("Joing date :" +datef);}
				return null;
			}
		});
	}
}
