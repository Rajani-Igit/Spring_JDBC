package com.pa.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.pa.bo.ConnectionResource;

@Configuration
@ComponentScan(basePackages={"com.pa.bo","com.pa.dao"})
public class JavaConfig {
	@Autowired
private ConnectionResource connresource;
	@Bean
	public DataSource getDatasource(){
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		System.out.println(connresource.getDriverclassName());
		System.out.println(connresource.getUrl());
	
		System.out.println(connresource.getUsername());
		System.out.println(connresource.getPassword());
		datasource.setDriverClassName(connresource.getDriverclassName());
		datasource.setUrl(connresource.getUrl());
		datasource.setUsername(connresource.getUsername());
		datasource.setPassword(connresource.getPassword());
		return datasource;
		
	}
	@Bean
	@Autowired
	public JdbcTemplate getJdbcTemplate(DataSource datasource){
		JdbcTemplate jt=new JdbcTemplate();
		jt.setDataSource(datasource);
		return jt;
	}
}
