package com.sg.test;
	
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.DashboardPage;
import com.sg.pages.LoginPage;

public class LoginTest extends WebDriverWrapper {
	
	
	//admin,pass,English (Indian),OpenEMR
	//physician,physician,English (Indian),OpenEMR
	//accountant,accountant,English (Indian),OpenEMR
	@DataProvider
	public Object[][] validCredentialData()
	{
		Object[][] main=new Object[3][4];
		
		main[0][0]="admin";
		main[0][1]="pass";
		main[0][2]="English (Indian)";
		main[0][3]="OpenEMR";
		
		main[1][0]="physician";
		main[1][1]="physician";
		main[1][2]="English (Indian)";
		main[1][3]="OpenEMR";
		
		main[2][0]="accountant";
		main[2][1]="accountant";
		main[2][2]="English (Indian)";
		main[2][3]="OpenEMR";
		
		return main;
	}
	
	@Test(dataProvider = "validCredentialData")
	public void validCredentialTest(String username,String password,String language,String expectedValue) {

		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanguageByText(language);
		login.clickOnLogin();

		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.waitForPresenceOfFlowBoard();

		Assert.assertEquals(dashboard.getCurrentTitle(), expectedValue);
	}
	
	@Test
	public void invalidCredentialTest()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername("admin123");
		login.enterPassword("pass");
		login.selectLanguageByText("English (Indian)");
		login.clickOnLogin();
		
		Assert.assertEquals(login.getInvalidLoginErrorMessage(), "Invalid username or password");
	}
}







