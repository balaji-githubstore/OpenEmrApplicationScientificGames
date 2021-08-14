package com.sg.test;
	
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.DashboardPage;
import com.sg.pages.LoginPage;

public class LoginTest extends WebDriverWrapper {
	
	
	//admin,pass,English (Indian),OpenEMR
	//physician,physician,English (Indian),OpenEMR
	//accountant,accountant,English (Indian),OpenEMR
	//
	@Test
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







