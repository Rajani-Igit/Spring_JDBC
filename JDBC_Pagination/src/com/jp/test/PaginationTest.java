package com.jp.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.jp.dao.CustomerDao;

public class PaginationTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com\\jp\\common\\application-context.xml");
		CustomerDao cdao = context.getBean("customerdao", CustomerDao.class);
		System.out.println(cdao.getCustomers(1, 2));
		System.out.println(cdao.getCustomers(2, 2));
		System.out.println(cdao.getCustomers(3, 2));
		
	}
	

}
