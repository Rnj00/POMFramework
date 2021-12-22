package com.qa.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;
import com.qa.utils.Xls_Reader;

public class DataFile extends TestBase{
	
	
	public static Object[][] agentDataFromFile(){
	Xls_Reader d= new Xls_Reader("/Users/amitmehta/Desktop/Selenium_workspace1/PomFrameworkProject/src/main/java/com/qa/testdata/AgentData.xlsx");
	String[][] data = null;  
	int noOfRows = d.getRowCount("Sheet1");
	int noOfCols = d.getColumnCount("Sheet1");
	
	
	data = new String[noOfRows-1][noOfCols];
	
	for(int i =1; i<noOfRows;i++){
		     for(int j=0;j<noOfCols;j++){
		    	 data[i-1][j] =  d.getCellData("Sheet1", j, i+1);
		 	  }
	   	}
	return data;	
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
