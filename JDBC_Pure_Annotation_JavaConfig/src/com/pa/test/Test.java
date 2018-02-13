package com.pa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pa.config.JavaConfig;
import com.pa.dao.CustomerDao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context =new AnnotationConfigApplicationContext(JavaConfig.class);
CustomerDao dao=context.getBean("customerDao",CustomerDao.class);

System.out.println(dao.findCustomerCount());
	}

}
