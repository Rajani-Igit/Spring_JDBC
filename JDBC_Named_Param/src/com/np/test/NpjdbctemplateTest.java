package com.np.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.np.bo.CustomerBo;
import com.np.dao.CustomerDao;

public class NpjdbctemplateTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		ApplicationContext context =new ClassPathXmlApplicationContext("com\\np\\common\\application-context.xml");
CustomerDao cdao= context.getBean("customerdao", CustomerDao.class);
CustomerBo cbo=new CustomerBo();
/*cbo.setCustomerNo(16);
cbo.setFirstName("Somesh");
cbo.setLastName("Bagarti");
cbo.setMobile("8895247511");
cbo.setEmail("soma@gmail.com");
cdao.saveCustomer(cbo);*/
/*cbo.setCustomerNo(17);
cbo.setFirstName("RashmiRanjan");
cbo.setLastName("Behera");
cbo.setMobile("8895247512");
cbo.setEmail("rashmi@gmail.com");
System.out.println(cdao.saveCustomer(cbo));*/
//System.out.println(cdao.findCustomer(17));
String sdate="01/23/2018";
Date date=new SimpleDateFormat("dd/MM/yyyy").parse(sdate);
//cdao.insertData("Rajanikanta","Pradhan", "rajani@123gmail.com", "12245","897897",1, date);
	cdao.fetchdate("Rajanikanta");
	}

}
