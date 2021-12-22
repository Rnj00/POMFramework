package com.qa.tests;

import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase{
 LoginPage lp;
 HomePage homePage;
	
//  public LoginPageTest(){
//	super();
// }
 
  @BeforeMethod
  public void setUp() {
	 initializeDriver();
	 lp =new LoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  
  @Test
  public void loginPageTitleTest()
  {
	 String title= lp.validateLoginPageTitle();
	 Assert.assertEquals(title, "Administator Login");
  }
  
  @Test
  public void loignTest() {
	  homePage=lp.Login(prop.getProperty("username"), prop.getProperty("password"));
  }

}
