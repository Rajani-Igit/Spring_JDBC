package com.pa.bo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
@Component("databasedetails")
@PropertySource("classpath:com/pa/common/db.properties")
public class ConnectionResource {
@Value("${driverclassName}")	
private String driverclassName;
@Value("${url}")
private String url;
@Value("${user}")
private String username;
@Value("${password}")
private String password;
public String getDriverclassName() {
	return driverclassName;
}
public void setDriverclassName(String driverclassName) {
	this.driverclassName = driverclassName;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
