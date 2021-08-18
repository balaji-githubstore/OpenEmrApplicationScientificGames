package com.sg.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.AboutPage;
import com.sg.pages.DashboardPage;
import com.sg.pages.LoginPage;
import com.sg.utilities.DataProviderUtils;

public class AboutTest extends WebDriverWrapper {
	
	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "commonDataProvider")
	public void checkAboutHeaderAndVersionTest(String username,String password,String language,String expectedHeader,String expectedVersion)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanguageByText(language);
		login.clickOnLogin();
		
		DashboardPage dashboard=new DashboardPage(driver);
		dashboard.clickOnAbout();
		
		AboutPage about=new AboutPage(driver);
		about.switchToMscFrame();
		String actualHeader= about.getHeader();
		String actualVersion=about.getVersion();
		about.SwitchOutOfFrame();
		
		Assert.assertEquals(actualHeader, expectedHeader);
		
		Assert.assertTrue(actualVersion.contains(expectedVersion));
	}
}









