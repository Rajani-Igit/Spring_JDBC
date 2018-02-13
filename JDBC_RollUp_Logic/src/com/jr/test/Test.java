package com.jr.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jr.bo.CustomerJobSheetBo;
import com.jr.bo.JobSheetBo;
import com.jr.dao.CustomerJobSheetDao;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("com\\jr\\common\\application-context.xml");
    CustomerJobSheetDao cdao=context.getBean("customerjobsheetdao", CustomerJobSheetDao.class);
    List<CustomerJobSheetBo> list=cdao.getCustomerJobSheets();
    for(CustomerJobSheetBo customer:list){
    	System.out.println(customer.getCustomer().getFirstName());
    List<JobSheetBo> jobsheets=customer.getJobshets();
    for(JobSheetBo jobsheet:jobsheets){
    	System.out.println(jobsheet.getJobsheetNo());
    }
    System.out.println("*************************************");
    }
	}

}
