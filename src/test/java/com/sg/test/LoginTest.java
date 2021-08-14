package com.sg.test;
	
import org.testng.Assert;
import org.testng.annotations.Test;

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
	
	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username,String password,String language,String expectedValue)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanguageByText(language);
		login.clickOnLogin();
		
		Assert.assertEquals(login.getInvalidLoginErrorMessage(), expectedValue);
	}
}







