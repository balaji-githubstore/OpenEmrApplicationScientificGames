package com.sg.test;
	
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.sg.base.WebDriverWrapper;
import com.sg.pages.DashboardPage;
import com.sg.pages.LoginPage;
import com.sg.utilities.DataProviderUtils;

public class LoginTest extends WebDriverWrapper {
	
	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "validCredentialData")
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
	
	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "commonDataProvider")
	public void invalidCredentialTest(String username,String password,String language,String expectedValue)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		test.log(Status.INFO, "Entered username as "+username);
		login.enterPassword(password);
		test.log(Status.INFO, "Entered password as "+password);
		login.selectLanguageByText(language);
		test.log(Status.INFO, "Selected language as "+language);
		login.clickOnLogin();
		test.log(Status.INFO, "Clicked on login");
		
		Assert.assertEquals(login.getInvalidLoginErrorMessage(), expectedValue);
	}
}







