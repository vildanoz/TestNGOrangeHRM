package com.qa.orangehrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.LoginPage;

import  com.qa.orangehrm.util.Constants;
import com.qa.orangehrm.util.Credentials;
//@Listeners(com.qa.orangehrm.listeners.Listener1.class)
//@Listeners(com.qa.orangehrm.listeners.ExtentReportListener.class)
public class LoginPageTest {
	
	//fileds:driver,properties , BasePage object, LoginPage object

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	Credentials cred;
	
	
	@BeforeMethod
	@Parameters(value = {"browser"})
	public void setup( String browser) {
		String browserName=null;
		basePage =new BasePage();
		properties=basePage.initializeProperties();
		if(browser.equals(null)) {
			browserName=properties.getProperty("browser");
		}else {
			browserName=browser;
		}
		driver=basePage.initilizeDriver(browserName);
		loginPage=new LoginPage(driver);
		cred=new Credentials(properties.getProperty("username"), properties.getProperty("password"));
	}
	@Test(priority=1, description="Check login page title")
	public void verifyTitle() {
		
		String actual=loginPage.getPageTitle();
		Assert.assertEquals(actual, Constants.LOGIN_PAGE_TITLE);
		
	}
	@Test(priority=2, description="verify login with correct credentials")
	public void loginTest() {
		loginPage.doLogin(cred.getUsername(), cred.getPassword());
	}
	@DataProvider
	public Object[][] invalidLoginData(){
		Object data[][]= {{"admin"," "},{"cemil","6789"},{"12345","ahmet"}};
		return data;
	}
	
	@Test(priority=3,dataProvider="invalidLoginData", description="verify login with incorrect credentials")
	public void InvalidLoginTest(String user,String pass) {
		loginPage.doLogin(user, pass);
		Assert.assertEquals(loginPage.invalidLogin(), Constants.LOGIN_PAGE_INVALIDMESSAGE);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
