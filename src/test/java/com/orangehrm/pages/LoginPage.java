package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;

import com.orangehrm.commands.CommandsCls;
import com.orangehrm.objects.ObjectsCls;
import com.orangehrm.utilities.ExtentManagerCls;

public class LoginPage extends CommandsCls {

	ExtentManagerCls reportcls;
	public LoginPage(WebDriver driver) {
		super(driver);
		reportcls=new ExtentManagerCls();
		
	}
	
	
	public void LoginWithValidCredentials(String username, String password) {
		
		//driver.findElement(null).sendKeys(null);
		type(ObjectsCls.username, username);
		reportcls.AddTestcaseSteps("Username is entered: "+username);
		type(ObjectsCls.password, password);
		reportcls.AddTestcaseSteps("Password is entered: "+password);
		click(ObjectsCls.loginbutton);
		reportcls.AddTestcaseSteps("Clicked on Login button");
	}
	
	public void LoginWithInValidUsername(String invalidusername, String password) {
		type(ObjectsCls.username, invalidusername);
		reportcls.AddTestcaseSteps("Entered invalid username: "+invalidusername);
		type(ObjectsCls.password, password);
		reportcls.AddTestcaseSteps("Entered the password: "+password);
		click(ObjectsCls.loginbutton);
		reportcls.AddTestcaseSteps("Clicked on login button");
	}

}
