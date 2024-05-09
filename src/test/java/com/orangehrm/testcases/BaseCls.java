package com.orangehrm.testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.spi.DefaultThreadContextMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.utilities.ExtentManagerCls;
import com.orangehrm.utilities.ReadConfig;


public class BaseCls {
	
	ReadConfig readconfigdata;
	public String url="";
	public String username="";
	public String password="";
	
	public WebDriver driver;
	
	
	ExtentManagerCls reportclass;
	
	///----------------LOGS-----------
	public final static Logger logger=LogManager.getLogger("rootLogger");
	
	@BeforeSuite(alwaysRun = true)
	public void StartReport() {
		reportclass=new ExtentManagerCls();
		reportclass.StartReport();
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException, IOException {
		readconfigdata= new ReadConfig();
		url=readconfigdata.getUrl();
		username=readconfigdata.getUsername();
		password=readconfigdata.getPassword();
		
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Thread.sleep(5000);
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) {
		//driver.close();
		if(result.getStatus()==ITestResult.SUCCESS) {
			logger.info("Test Case"+result.getName()+" is passed: ");
			driver.close();
		}
		
		else if(result.getStatus()==ITestResult.FAILURE) {
			logger.info("Test Case"+result.getName()+" is failed: ");
			reportclass.addOnTestCaseFailure(driver,result.getThrowable().getMessage());
			driver.close();
		}
	}
	
	@AfterSuite(alwaysRun = true)
	public void EndReport() {
		reportclass.EndReport();
	}
}
