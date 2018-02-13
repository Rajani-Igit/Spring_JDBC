package com.jp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.jp.bo.CustomerBo;
import com.jp.extrators.PaginationPreparedstatementCrator;

public class CustomerDao {
	private final String  SQL_SELECT_FIND_PGINATED_RECORDS="SELECT * FROM CUSTOMER";
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	public List<CustomerBo> getCustomers(int pageNo,int pageSize){
		
		return jdbctemplate.query(SQL_SELECT_FIND_PGINATED_RECORDS,new PaginationExtractor(pageNo,pageSize));
	}
	
	private class PaginationExtractor extends PaginationPreparedstatementCrator{

		public PaginationExtractor(int pageno, int pageSize) {
			super(pageno, pageSize);
			
		}

		@Override
		public CustomerBo maprow(ResultSet rs) throws SQLException {
			CustomerBo cbo=new CustomerBo();
			cbo.setCustomerNo(rs.getInt(1));
			cbo.setFirstName(rs.getString(2));
			cbo.setLastName(rs.getString(3));
			cbo.setMobile(rs.getString(4));
			cbo.setEmail(rs.getString(5));
			
			return cbo;
		}
		
	}

}
