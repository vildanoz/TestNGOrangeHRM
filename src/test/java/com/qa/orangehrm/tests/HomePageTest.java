package com.qa.orangehrm.tests;

import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;

//@Listeners(com.qa.orangehrm.listeners.ScreenshotListener.class)
//@Listeners(com.qa.orangehrm.listeners.ExtentReportListener.class)
public class HomePageTest {
	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
	Logger logger=Logger.getLogger(HomePageTest.class);
	
	
	@BeforeMethod
	//@Parameters(value = {"browser"})
	public void setUp() {
		basePage =new BasePage();
		logger.info("Browser is launching...");
		properties=basePage.initializeProperties();
		String browserName=properties.getProperty("browser");
		driver=basePage.initilizeDriver(browserName);
		loginPage=new LoginPage(driver);
		homePage=loginPage.doLogin(properties.getProperty("username"),properties.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitle() {
		BasicConfigurator.configure();
		logger.info("Verifying home page title starting...");
		String actual=homePage.getHomePageTitle();
		String expected="OrangeHRM";
		Assert.assertEquals(actual, expected);
		logger.info("Verifying home page title ending...");
	}
	@Test
	public void verifyHeader() {
		logger.info("Verifying home page header");
		Assert.assertEquals(homePage.gtPageHeader(), "Dashboard");
			System.out.println("deneme");
			logger.info("Verifying home page header ending...");
	}
	@Test
public void verifyAccountName() {
		//logger.debug("Getting overall description");
		String accountName=homePage.getLoggedInUserAccountName();
		Assert.assertTrue(accountName.contains("Welcome"));
	
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
