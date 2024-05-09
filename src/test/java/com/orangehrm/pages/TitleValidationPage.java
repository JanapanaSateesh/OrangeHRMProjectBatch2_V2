package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;

import com.orangehrm.commands.CommandsCls;
import com.orangehrm.objects.ObjectsCls;
import com.orangehrm.utilities.ExtentManagerCls;

public class TitleValidationPage extends CommandsCls {

	ExtentManagerCls reportcls;
	public TitleValidationPage(WebDriver driver) {
		super(driver);
		reportcls=new ExtentManagerCls();
		// TODO Auto-generated constructor stub
	}
	
	public void TitleValidation(String username, String password, String expectedtitle) {
		type(ObjectsCls.username, username);
		reportcls.AddTestcaseSteps("Username is entered: "+username);
		type(ObjectsCls.password, password);
		reportcls.AddTestcaseSteps("Password is entered: "+password);
		click(ObjectsCls.loginbutton);
		reportcls.AddTestcaseSteps("Clicked on Login button");
		String actualtitle= getTitle();
		validate(actualtitle, expectedtitle);
		reportcls.AddTestcaseSteps("Comparision of actual title with expected title is validated: "+"Actual Title: "+actualtitle+"Expected Title is: "+expectedtitle);
	}

}
