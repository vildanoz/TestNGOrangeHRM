package com.qa.orangehrm.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.orangehrm.base.BasePage;
import com.qa.orangehrm.util.ElementUtil;

public class AddEmployeePage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	HomePage homePage;
	//By firstName=By.id("firstName");
	By firstName=By.cssSelector("#firstName");
	By lastName=By.id("lastName");
	By btnSave=By.id("btnSave");
	By header =By.xpath("//h1[contains(text(),'Add Employee')]");
	By clickPIM=By.xpath("//b[contains(text(),'PIM')]");
	By addEmployee=By.xpath("//a[contains(text(),'Add Employee')]");
	
	public AddEmployeePage(WebDriver driver) {
		this.driver=driver;
		elementUtil=new ElementUtil(driver);
	}
	
	public String getAddEmployeePageHeader() {
		elementUtil.waitForElementVisible(header);
		return driver.findElement(header).getText();
	}
	
	public void goToAddEmployee() throws InterruptedException {
		elementUtil.waitForElementVisible(clickPIM);
		
		elementUtil.doClick(clickPIM);
		elementUtil.waitForElementVisible(addEmployee);
		//Thread.sleep(1000);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		elementUtil.doClick(addEmployee);
	}
	
	public void addEmployee(String fName, String lName) {
		elementUtil.doSendKeys(firstName, fName);
		elementUtil.doSendKeys(lastName, lName);
		elementUtil.doClick(btnSave);
		
	}
	
	
	

}
