package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.AgentPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utils.DataFile;

public class AgentPageTest extends TestBase{
	LoginPage lp;
	HomePage homePage;
	AgentPage agentPage;
	DataFile dataFile;
 
	 @BeforeMethod
	 public void beforeMethod() {
		  initializeDriver();
		  lp =new LoginPage();
		  agentPage=new AgentPage();
		  dataFile=new DataFile();
		 // homePage=new HomePage();
		  homePage=lp.Login(prop.getProperty("username"), prop.getProperty("password"));
	 }
	
	 @AfterMethod
	 public void afterMethod() {
		  driver.close();
	 }
	 
	 @Test
	 public void agentPageTitleTest()
	 {
		  String title=agentPage.validAgentPageTitle();
		  Assert.assertEquals(title, "Dashboard");
	 }
	 
	 @DataProvider
		public Object[][] agentData(){
		 	 Object data[][] = DataFile.agentDataFromFile();
			//Object data[][] = ;
			return data;
		}
	 @Test(dataProvider="agentData")
	 public void addAgentsTest(String fn,String ln,String email,String pwd,String country) throws InterruptedException
	 {
		 homePage.clickAddAgent();
		 agentPage.addAgentData(fn,ln,email,pwd,country);
		 
	 }
 
}
