package com.qa.orangehrm.util;

public class Credentials {
	//it effects our test case speed instead of using properties file we use cren. class
	//if I store it in a local object(Loginpage test te credentials objesi olusturduk)
	String username;

	String password;
	public Credentials(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	



}
