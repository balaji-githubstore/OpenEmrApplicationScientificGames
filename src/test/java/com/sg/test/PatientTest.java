package com.sg.test;
	
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.LoginPage;
import com.sg.utilities.DataProviderUtils;

public class PatientTest extends WebDriverWrapper {	

	@Test(dataProviderClass = DataProviderUtils.class,dataProvider = "commonDataProvider")
	public void addPatientTest(String username,String password,String language,String firstname,String lastname,String dob,String gender,String expectedAlert,String expectedPatientName)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.selectLanguageByText(language);
		login.clickOnLogin();
		
		//mouseover on patient/
		
		//firstname - john 
		//lastname - paul
		
		//Assert the added record Medical Record Dashboard - John Paul
	}
}
