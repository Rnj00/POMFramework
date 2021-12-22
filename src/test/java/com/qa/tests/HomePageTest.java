package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase{
	LoginPage lp;
	 HomePage homePage;
  
  @BeforeMethod
  public void beforeMethod() {
	  initializeDriver();
	  lp =new LoginPage();
	  homePage=lp.Login(prop.getProperty("username"), prop.getProperty("password"));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  
  @Test(priority=1)
  public void homePageTitleTest() throws InterruptedException
  {
	  String title=homePage.validHomePageTitle();
	  Thread.sleep(2000);
	  Assert.assertEquals(title, "Dashboard");
  }

  @Test(priority=2)
  public void usernameDiplayTest()
  {
	  Assert.assertTrue(homePage.verifyUsername());
  }
  
  @Test(priority=3)
  public void clickAgentTest() throws InterruptedException
  {
	  homePage.clickAddAgent();
  }
}
