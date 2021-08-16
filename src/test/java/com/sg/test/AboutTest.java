package com.sg.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.AboutPage;
import com.sg.pages.DashboardPage;
import com.sg.pages.LoginPage;

public class AboutTest extends WebDriverWrapper {
	
	@Test
	public void checkAboutHeaderAndVersionTest()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("pass");
		login.selectLanguageByText("English (Indian)");
		login.clickOnLogin();
		
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.clickOnAbout();
		
		AboutPage about=new AboutPage(driver);
		about.switchToMscFrame();
		String actualHeader= about.getHeader();
		String actualVersion=about.getVersion();
		about.SwitchOutOfFrame();
		
		Assert.assertEquals(actualHeader, "About OpenEMR");
		
		Assert.assertTrue(actualVersion.contains("v6.0.0"));
	}

}









