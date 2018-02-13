package com.jr.bo;

import java.util.List;

public class CustomerJobSheetBo {
private CustomerBo customer;
private List<JobSheetBo> jobshets;
public CustomerBo getCustomer() {
	return customer;
}
public void setCustomer(CustomerBo customer) {
	this.customer = customer;
}
public List<JobSheetBo> getJobshets() {
	return jobshets;
}
public void setJobshets(List<JobSheetBo> jobshets) {
	this.jobshets = jobshets;
}

}
