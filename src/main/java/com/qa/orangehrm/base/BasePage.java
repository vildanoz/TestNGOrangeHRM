package com.qa.orangehrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.orangehrm.util.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {
	
	//fields, driver
	
	//WebDriver driver;
	Properties properties;
	OptionsManager optionsManager;
	
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	public static synchronized WebDriver getDriver() {
		return driver.get();
	}
	//initialize driver
	public WebDriver initilizeDriver(String browserName) {
		//properties=initializeProperties();
		optionsManager=new OptionsManager(properties);
		//String browser =properties.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}else {
			System.out.println("Undefined browser");
		}
		//list all options here
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		getDriver().get(properties.getProperty("url"));
		return getDriver();
	}
	
	
	//initializing properties

	
	public Properties initializeProperties() {
		
		properties =new Properties();
		try {
			FileInputStream inStream=new FileInputStream("./src/main/java/com/qa/orangehrm/config/config.properties");
			properties.load(inStream);
		} catch (IOException e) {
			
		}
		
		return properties;
	}
}
