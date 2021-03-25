package com.qa.orangehrm.tests;

import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.pages.LoginPagePF;
import com.qa.orangehrm.util.Credentials;

public class LoginPageTestPF {

	WebDriver driver;
	Properties properties;
	BasePage basePage;
	LoginPagePF loginPagePF;
	
	@BeforeMethod
	public void setUp(String browser) {
		
		basePage =new BasePage();
		String browserName=null;
		properties=basePage.initializeProperties();
		if(browser.equals(null)) {
			browserName=properties.getProperty("browser");
		}else {
			browserName=browser;
		}
		driver=basePage.initilizeDriver(browserName);
		loginPagePF=new LoginPagePF(driver);
		
	}
	@Test
	public void loginTest() {
		loginPagePF.doLogin();
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
