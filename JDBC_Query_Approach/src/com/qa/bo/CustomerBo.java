package com.qa.bo;

public class CustomerBo {
private int customerNo;
private String fName;
private String lName;
private String email;
private String phNo;
public int getCustomerNo() {
	return customerNo;
}
public void setCustomerNo(int customerNo) {
	this.customerNo = customerNo;
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhNo() {
	return phNo;
}
public void setPhNo(String phNo) {
	this.phNo = phNo;
}
@Override
public String toString() {
	return "CustomerBo [customerNo=" + customerNo + ", fName=" + fName + ", lName=" + lName + ", email=" + email
			+ ", phNo=" + phNo + "]";
}

}
