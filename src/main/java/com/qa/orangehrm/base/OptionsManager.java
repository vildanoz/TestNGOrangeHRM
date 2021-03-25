package com.qa.orangehrm.base;

import java.util.Properties;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	//can we say that by using credentials and optionsManager classes, we prevent to reach direct access to our properties file? 
	//	Other than speed what is the benefit of using that structure?POM	
//fields
	public ChromeOptions cOptions;
	public FirefoxOptions fOptions;
	public Properties properties;
	
	public OptionsManager(Properties properties) {
		this.properties=properties;
	}
	
	public ChromeOptions getChromeOptions() {
		cOptions=new ChromeOptions();
		if(properties.getProperty("incognito").equals("yes"))
			cOptions.addArguments("--incognito");
		if(properties.getProperty("headless").equals("yes")){
			cOptions.addArguments("--headless");
		}
		return cOptions;
	}
	public FirefoxOptions getFirefoxOptions() {
		fOptions=new FirefoxOptions();
		if(properties.getProperty("incognito").equals("yes"))
			cOptions.addArguments("--incognito");
		if(properties.getProperty("headless").equals("yes"))
			cOptions.addArguments("--headless");
		
		return fOptions;
	}

	
}
