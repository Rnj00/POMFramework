package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.support.PageFactory;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	//public static WebDriverWait wait;
	
	
public TestBase(){
	try {
	 prop= new Properties();
		FileInputStream f = new FileInputStream("/Users/amitmehta/Desktop/Selenium_workspace1/PomFrameworkProject/src/main/java/com/qa/config/config.properties");
		prop.load(f);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

	
	public void initializeDriver() {
		 
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/amitmehta/Desktop/SeleniumJars/geckodriver");
			driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/amitmehta/Desktop/SeleniumJars/chromedriver");
			 driver =new ChromeDriver();
		}else {
			System.setProperty("webdriver.safari.driver", "/Users/amitmehta/Desktop/SeleniumJars/safaridriver");
			driver =new SafariDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		//PageFactory.initElements(driver, this);
		
		
		//return driver;
	
	}
	public void closeDriver()
	{
		driver.close();
	}
	

}
