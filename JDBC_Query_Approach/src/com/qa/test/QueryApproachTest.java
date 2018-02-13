package com.qa.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qa.bo.CustomerBo;
import com.qa.dao.CustomerDao;

public class QueryApproachTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ApplicationContext context=new ClassPathXmlApplicationContext("com\\qa\\common\\application-context.xml");
CustomerDao  dao=context.getBean("customerDao",CustomerDao.class); 
//System.out.println(dao.getCustomeCount());
//System.out.println(dao.findNamebyCustomerNo(2));
//System.out.println(dao.findcustomerbyId(2));
//System.out.println(dao.getCustomers());
CustomerBo cbo=new CustomerBo();
cbo.setfName("Saroj");
cbo.setlName("Mohapatra");
cbo.setPhNo("8895247515");
cbo.setEmail("saraoj@gmail.com");
System.out.println(dao.saveCustomerandgetId(cbo));
	}

}
