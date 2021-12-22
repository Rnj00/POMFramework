package com.qa.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.BookingPage;
import com.qa.pages.LoginPage;


public class BookingPageTest extends TestBase{
	
	LoginPage lp;
	BookingPage bookingPage;
	
	
	
	 @BeforeMethod
	 public void beforeMethod() {
		  initializeDriver();
		  lp =new LoginPage();
		  bookingPage= new BookingPage();
		 
		  lp.Login(prop.getProperty("username"), prop.getProperty("password"));
	 }
	
	 @AfterMethod
	 public void afterMethod() {
		  driver.close();
	 }
	
	 @Test
	 public void bookingPageTitleTest() throws InterruptedException
	 {
		  
		  String title=bookingPage.validateBookingPageTitle();
		  Assert.assertEquals(title, "All Bookings View");
	 }
}
