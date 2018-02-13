package com.sji.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sji.bo.CustomerBo;
import com.sji.dao.CustomerDao;

public class SjiTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CustomerBo cbo=new CustomerBo();
		cbo.setCustomer_no(18);
		cbo.setCustomer_fname("Rakesh");
		cbo.setCustomer_lname("Singh");
		cbo.setCustomer_phoneno("8895247513");
		cbo.setCustomer_mailid("rk@gmail.com");
		ApplicationContext context=new ClassPathXmlApplicationContext("com\\sji\\common\\application-context.xml");
		CustomerDao cdao=context.getBean("customerdao", CustomerDao.class);
		cdao.savecustomer(cbo);
	
	}

}
