package com.np.bo;

public class CustomerBo {
private int customerNo;
private String firstName;
private String lastName;
private String mobile;
private String email;
public int getCustomerNo() {
	return customerNo;
}
public void setCustomerNo(int customerNo) {
	this.customerNo = customerNo;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "CustomerBo [customerNo=" + customerNo + ", firstName=" + firstName + ", lastName=" + lastName + ", mobile="
			+ mobile + ", email=" + email + "]";
}

}
