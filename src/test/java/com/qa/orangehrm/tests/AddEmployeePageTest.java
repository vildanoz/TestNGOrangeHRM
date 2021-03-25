package com.qa.orangehrm.tests;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.pages.AddEmployeePage;
import com.qa.orangehrm.pages.HomePage;
import com.qa.orangehrm.pages.LoginPage;
import com.qa.orangehrm.util.ExcelUtil;

public class AddEmployeePageTest {

	WebDriver driver;
	BasePage basePage;
	Properties properties;
	LoginPage loginPage;
	HomePage homePage;
	AddEmployeePage addEmployeePage;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		basePage =new BasePage();
		properties=basePage.initializeProperties();
		String browserName=properties.getProperty("browser");
		driver=basePage.initilizeDriver(browserName);
		loginPage=new LoginPage(driver);
		homePage=loginPage.doLogin(properties.getProperty("username"),properties.getProperty("password"));
		addEmployeePage=new AddEmployeePage(driver);
		addEmployeePage.goToAddEmployee();
	}
	
	@Test
	public void verifyAddEmployeeHeader(){
		String header = addEmployeePage.getAddEmployeePageHeader();
		Assert.assertEquals(header, "Add Employee");
	}
	@Test
	public void verifyAddEmployeePage() {
		String actual=addEmployeePage.getAddEmployeePageHeader();
		String expected="Add Employee";
		Assert.assertEquals(actual, expected);
	}
	@DataProvider
	public Object[][] getContactData(){
		Object [][] data=ExcelUtil.getTestData("Employees");
		return data;
	}
	@Test(dataProvider="getContactData")
	public void addEmployee(String name, String lastName) throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addEmployeePage.goToAddEmployee();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addEmployeePage.addEmployee(name, lastName);
	}
	
//	@Test
//	public void verifyAddEmployee() throws InterruptedException {
//		addEmployeePage.goToAddEmployee();
//		addEmployeePage.addEmployee("Mary", "Smith");
//	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
