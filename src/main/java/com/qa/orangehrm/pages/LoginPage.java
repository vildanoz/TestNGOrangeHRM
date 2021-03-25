package com.qa.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.base.BasePage;

public class LoginPage  extends BasePage{

	// fileds:driver,locators
	WebDriver driver;
	By username=By.id("txtUsername");
	By password=By.id("txtPassword");
	By loginBtn=By.id("btnLogin");
	By invalidLogin = By.id("spanMessage");
	
	//Constructor it is abridge our loginpage and logintestpage
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Page Actions
	public String getPageTitle() {
		String title=driver.getTitle();
		return title;
		
	}
	public String invalidLogin() {
		return driver.findElement(invalidLogin).getText();
	}
	public HomePage doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(loginBtn).click();	
		return new HomePage(driver);
}
}
