package com.qa.orangehrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.orangehrm.base.BasePage;

public class LoginPagePF extends BasePage {
	
	//field
	WebDriver driver;
	//Page Factory model
	@FindBy(how=How.ID,using ="txtUsername")
	@CacheLookup
	WebElement userInput;
	
	
	@FindBy(how=How.ID, using="txtPassword")
	@CacheLookup
	WebElement passwordInput;
	
	@FindBy(how=How.ID, using="btnLogin")
	@CacheLookup
	WebElement loginBtn;
	
	public LoginPagePF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void doLogin() {
		userInput.sendKeys("Admin");
		passwordInput.sendKeys("admin123");
		loginBtn.click();
		
	}
	

}
