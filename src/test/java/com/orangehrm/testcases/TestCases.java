package com.orangehrm.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.pages.LoginPage;
import com.orangehrm.pages.TitleValidationPage;
import com.orangehrm.utilities.ReadExcleCls2;

public class TestCases extends BaseCls {

	@Test(enabled = true,priority = 1,groups = {"regression","smoke"})
	public void LoginWithValidCredentials_TC001() {

			LoginPage loginpage = new LoginPage(driver);
			reportclass.CreateTestCaseNameOnTheReport("LoginWithValidCredentials_TC001");
			loginpage.LoginWithValidCredentials(username, password);		
		
	}
	
	@Test(enabled = true,priority = 2,groups = {"regression"} )
	public void LoginWithInvalidUsername_TC002() {
		LoginPage loginpage = new LoginPage(driver);
		reportclass.CreateTestCaseNameOnTheReport("LoginWithInvalidUsername_TC002");
		loginpage.LoginWithInValidUsername(username, password);
	}
	
	@Test(enabled = true,priority = 3, dataProvider ="testDataTC003",groups = {"sanity","regression"} )
	public void TitleValidation_TC003(String username, String password, String expectedtitlte) {
		TitleValidationPage titlevalidationpage = new TitleValidationPage(driver);
		reportclass.CreateTestCaseNameOnTheReport("TitleValidation_TC003");
		titlevalidationpage.TitleValidation(username, password,expectedtitlte);				
	}

	@Test(enabled = true,priority = 1,groups = {"acceptance","smoke","regression"} )
	public void LoginWithValidCredentials_TC004() {

			LoginPage loginpage = new LoginPage(driver);
			reportclass.CreateTestCaseNameOnTheReport("LoginWithValidCredentials_TC004");
			loginpage.LoginWithValidCredentials(username, password);		
		
	}
	
	@Test(enabled = true,priority = 2, groups = {"sanity","regression"} )
	public void LoginWithInvalidUsername_TC005() {
		LoginPage loginpage = new LoginPage(driver);
		reportclass.CreateTestCaseNameOnTheReport("LoginWithInvalidUsername_TC005");
		loginpage.LoginWithInValidUsername(username, password);
	}
	
	@Test(enabled = true,priority = 3, dataProvider ="testDataTC003",groups = {"regression","smoke"} )
	public void TitleValidation_TC006(String username, String password, String expectedtitlte) {
		TitleValidationPage titlevalidationpage = new TitleValidationPage(driver);
		reportclass.CreateTestCaseNameOnTheReport("TitleValidation_TC006");
		titlevalidationpage.TitleValidation(username, password,expectedtitlte);				
	}

	
	
	@DataProvider
	public String[][] testDataTC003() throws IOException {
		ReadExcleCls2 readexcel = new ReadExcleCls2();
		String[][] testdata= readexcel.getData("./TestData/TestDataForTitleValidation.xlsx");
		System.out.println(testdata.length);
		return testdata;
	}
}
