package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//h2[@id='mainHeader']")
	public WebElement userLable;
	
	@FindBy(xpath="//a[contains(text(),'Accounts')]")
	public WebElement linkAccount;
	
	@FindBy(xpath="//a[contains(text(),'Agents')]")
	public WebElement linkAgent;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement addBtn;
	
	public  HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validHomePageTitle() {
		
		return driver.getTitle();
	}
	
	public boolean verifyUsername() {
		return userLable.isDisplayed();
	}
	
	public void clickAddAgent() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(linkAccount).build().perform();
		WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Agents')]")));
		
		Thread.sleep(2000);
		linkAgent.click();
		Thread.sleep(2000);
		addBtn.click();

	}
	
}
