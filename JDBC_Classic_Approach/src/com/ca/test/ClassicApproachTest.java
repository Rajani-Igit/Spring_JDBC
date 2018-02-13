package com.ca.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ca.bo.CustomerBo;
import com.ca.dao.CustomerDao;

public class ClassicApproachTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  ApplicationContext context=new ClassPathXmlApplicationContext("com\\ca\\common\\application-context.xml");
  CustomerDao cdao=context.getBean("customerdao", CustomerDao.class);
  /*List<CustomerBo> customers=cdao.getCustomers();
  for(CustomerBo customer:customers){
	  System.out.println(customer.getCustomerNo());
	  System.out.println(customer.getFirstName());
	  System.out.println(customer.getLastName());
	  System.out.println(customer.getEmail());
	  System.out.println(customer.getPhNo());
	  System.out.println("**************************************");
  }*/
  CustomerBo customer= new CustomerBo();
  customer.setCustomerNo(5);
  customer.setFirstName("Akshya");
  customer.setLastName("Nalmwar");
  customer.setPhNo("8895247585");
  customer.setEmail("ak@gmail.com");
  System.out.println(cdao.addCustomer(customer));
	}

}
