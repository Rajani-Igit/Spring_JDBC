package com.jr.bo;

import java.util.Date;

public class JobSheetBo {
private int jobsheetNo;
private Date date;
private String jobsheetType;
private int petrolLevel;
public int getJobsheetNo() {
	return jobsheetNo;
}
public void setJobsheetNo(int jobsheetNo) {
	this.jobsheetNo = jobsheetNo;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getJobsheetType() {
	return jobsheetType;
}
public void setJobsheetType(String jobsheetType) {
	this.jobsheetType = jobsheetType;
}
public int getPetrolLevel() {
	return petrolLevel;
}
public void setPetrolLevel(int petrolLevel) {
	this.petrolLevel = petrolLevel;
}

}
