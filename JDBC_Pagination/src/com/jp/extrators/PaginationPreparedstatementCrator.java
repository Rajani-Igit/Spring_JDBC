package com.jp.extrators;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.jp.bo.CustomerBo;

public abstract  class PaginationPreparedstatementCrator implements ResultSetExtractor<List<CustomerBo>> {
	private int pageno;
	private int pageSize;
	private List<CustomerBo> cutomers;
	public PaginationPreparedstatementCrator(int pageno,int pageSize){
		this.pageno=pageno;
		this. pageSize=pageSize;
		cutomers=new ArrayList<>();
	}
	
	@Override
	public List<CustomerBo> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
       int startindex=0;
       int endindex=0;
       int count=1;
       startindex=(pageno*pageSize)-pageSize+1;
       endindex=pageno*pageSize;

		while(rs.next()&& count<=endindex){
			if(count>=startindex&&count<=endindex){
				CustomerBo	customerbo=maprow(rs);
				cutomers.add(customerbo);
			}
			count=count+1;
		}
		return cutomers;
	}
	
	public abstract CustomerBo maprow(ResultSet rs) throws SQLException;

}
