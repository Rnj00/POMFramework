package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class AgentPage extends TestBase{
	
	@FindBy(name="fname")
	public WebElement firstName;
	
	@FindBy(name="lname")
	public WebElement lastName;
	
	@FindBy(name="email")
	public WebElement emailText;
	
	@FindBy(name="password")
	public WebElement password;
	
	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement submitBtn;
	
	
	public  AgentPage() {
		PageFactory.initElements(driver, this);
	}

	public String validAgentPageTitle() {
		return driver.getTitle();
	}
	
	public void addAgentData(String fn,String ln,String email,String pwd,String country) 
	{	
		firstName.sendKeys(fn);
		lastName.sendKeys(ln);
		emailText.sendKeys(email);
		password.sendKeys(pwd);
		WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("country")));
		driver.findElement(By.id("//div[@id='s2id_autogen1']")).click();
		WebElement countryOption=driver.findElement(By.name("country"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", countryOption);
		
		Select select= new Select(countryOption);
		select.selectByValue(country);
		
		wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
		submitBtn.click();
		
	}
}
