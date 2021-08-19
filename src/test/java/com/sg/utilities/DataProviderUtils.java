package com.sg.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {
	
	@DataProvider
	public Object[][] commonDataProvider(Method method) throws IOException
	{	
		Object[][] main= ExcelUtils.getSheetToObjectArray("src/test/resources/testdata/OpenEmrData.xlsx", method.getName());
		return main;
	}
	
//	@DataProvider
//	public Object[][] checkAboutHeaderAndVersionData() throws IOException
//	{
//		Object[][] main= ExcelUtils.getSheetToObjectArray("src/test/resources/testdata/OpenEmrData.xlsx", "checkAboutHeaderAndVersionTest");
//		return main;
//	}
//	
//	@DataProvider
//	public Object[][] invalidCredentialData() throws IOException
//	{
//		Object[][] main= ExcelUtils.getSheetToObjectArray("src/test/resources/testdata/OpenEmrData.xlsx", "invalidCredentialTest");
//		return main;
//	}

	@DataProvider
	public Object[][] validCredentialData() {
		
		Object[][] main = new Object[1][4];

		main[0][0] = "admin";
		main[0][1] = "pass";
		main[0][2] = "English (Indian)";
		main[0][3] = "OpenEMR";

//		main[1][0] = "physician";
//		main[1][1] = "physician";
//		main[1][2] = "English (Indian)";
//		main[1][3] = "OpenEMR";
//
//		main[2][0] = "accountant";
//		main[2][1] = "accountant";
//		main[2][2] = "English (Indian)";
//		main[2][3] = "OpenEMR";

		return main;
	}

}
