package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//public WebDriver driver;
	@FindBy(name="email")
	public WebElement email;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//button[@type='submit']/span[1]")
	public WebElement loginButton;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage Login(String un, String pwd)
	{
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginButton.click();
		
		return new HomePage();
	}

}
