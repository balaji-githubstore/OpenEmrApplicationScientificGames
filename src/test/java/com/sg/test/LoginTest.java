package com.sg.test;
	
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.DashboardPage;
import com.sg.pages.LoginPage;

public class LoginTest extends WebDriverWrapper {
	
	@Test
	public void validCredentialTest() {

		LoginPage login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("pass");
		login.selectLanguageByText("English (Indian)");
		login.clickOnLogin();

		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.waitForPresenceOfFlowBoard();

		Assert.assertEquals(dashboard.getCurrentTitle(), "OpenEMR");
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







