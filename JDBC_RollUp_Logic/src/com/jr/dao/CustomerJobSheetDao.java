package com.jr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.jr.bo.CustomerBo;
import com.jr.bo.CustomerJobSheetBo;
import com.jr.bo.JobSheetBo;

public class CustomerJobSheetDao {
	private final String SQL_GET_FETCH_CUSTOMER_JOBSHEETS = "select  c.customer_no, c.customer_fname, c.customer_lname, c.customer_phoneno, c.customer_mailid, j.job_sheet_no, j.opendate, j.job_sheet_type, j.petrol_level, j.customer_no from customer c inner join job_sheet j on c.customer_no= j.customer_no";
	private JdbcTemplate jdbctemplate;

	

	public JdbcTemplate getJdbctemplate() {
		
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}



	public List<CustomerJobSheetBo> getCustomerJobSheets() {

		return jdbctemplate.query(SQL_GET_FETCH_CUSTOMER_JOBSHEETS, new ResultSetExtractor<List<CustomerJobSheetBo>>() {

			@Override
			public List<CustomerJobSheetBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				HashMap<Integer, CustomerJobSheetBo> customerjobsheetmap = new HashMap<>();
				List<CustomerJobSheetBo>  customerjobsheets=new ArrayList<CustomerJobSheetBo>();

				while (rs.next()) {
					int customerno = rs.getInt(1);

					if (customerjobsheetmap.containsKey(customerno)==false) {
						CustomerBo customer = new CustomerBo();
						customer.setCustomerNo(rs.getInt(1));
						customer.setFirstName(rs.getString(2));
						customer.setLastName(rs.getString(3));
						customer.setPhoneNo(rs.getString(4));
						customer.setEmail(rs.getString(5));

						List<JobSheetBo> jobsheetlist = new ArrayList<>();
						CustomerJobSheetBo customerjobsheet = new CustomerJobSheetBo();
						customerjobsheet.setCustomer(customer);
						customerjobsheet.setJobshets(jobsheetlist);
						customerjobsheetmap.put(customerno, customerjobsheet);
					}
					JobSheetBo jobsheet = new JobSheetBo();
					jobsheet.setJobsheetNo(rs.getShort(6));
					jobsheet.setDate(rs.getDate(7));
					jobsheet.setJobsheetType(rs.getString(8));
					jobsheet.setPetrolLevel(rs.getInt(9));
					CustomerJobSheetBo customerjobsheet = customerjobsheetmap.get(customerno);
					customerjobsheet.getJobshets().add(jobsheet);
					
				}
				for(int customerno :customerjobsheetmap.keySet()){
					customerjobsheets.add(customerjobsheetmap.get(customerno));
				}
				return customerjobsheets;
			}

		});

	}

}
