package com.sg.test;
	
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.LoginPage;

public class PatientTest extends WebDriverWrapper {	

	@Test
	public void addPatientTest()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername("admin");
		login.enterPassword("pass");
		login.selectLanguageByText("English (Indian)");
		login.clickOnLogin();
		
		//mouseover on patient/
		
		//firstname - john 
		//lastname - paul
		
		//Assert the added record Medical Record Dashboard - John Paul
	}
}
