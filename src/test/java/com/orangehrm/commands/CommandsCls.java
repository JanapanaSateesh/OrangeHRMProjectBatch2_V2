package com.orangehrm.commands;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommandsCls {

	public WebDriver driver;
	public final static Logger logger=LogManager.getLogger("rootLogger");
	
	public CommandsCls(WebDriver driver) {
			this.driver=driver;		
	}
	
	public void click(By byLocator) {
		
		try {
			
			
			driver.findElement(byLocator).click();
			logger.info("Clicked on"+byLocator);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			Assert.fail();
		}
		
	}
	
	public void type(By byLocator, String text) {
		
		try {
			driver.findElement(byLocator).sendKeys(text);
			logger.info("Entered the value: "+text);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			Assert.fail();
		}
		
	}
	
	public String getTitle() {
		
		String title="";
		try {
			 title=driver.getTitle();
			logger.info("Get the title :"+title);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			Assert.fail();
		}
	
		return title;
	}
						
	public void validate(String actualvalue, String expectedvalue) {
		try {
			Assert.assertEquals(actualvalue,expectedvalue);
			logger.info("Compared two strings: "+"Actual is: "+actualvalue+" "+"Expected is :"+expectedvalue);
		}catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage());
			Assert.fail();
		}		
		
	}
	
	public void Explicit(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
//		WebElement xpath= driver.findElement(By.xpath("//*[text()='Admin']"));
//		int x=10;
	}

}
