package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class BookingPage extends TestBase {
	
	@FindBy(xpath="//div[@id='bs-navbar-collapse-1']/ul[2]/li[2]/a")
	public WebElement bookingLink;
	
	public  BookingPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateBookingPageTitle() throws InterruptedException {
		Thread.sleep(2000);
		bookingLink.click();
		return driver.getTitle();
	}

}
