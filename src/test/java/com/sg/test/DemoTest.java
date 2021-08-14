package com.sg.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {
	
	//john,john123
	//peter,peter123
	//mark,mark123
	//kevin,kevin123
	
	@DataProvider
	public Object[][] validData()
	{
		Object[][] main=new Object[4][2];
		//i --> 3
		//j --> 2
		
		main[0][0]="john";
		main[0][1]="john123";
		
		main[1][0]="peter";
		main[1][1]="peter123";
		
		main[2][0]="mark";
		main[2][1]="mark123";
		
		main[3][0]="kevin";
		main[3][1]="kevin123";
		
		return main;
	}
	
	
	@Test(dataProvider = "validData")
	public void validTest(String username,String password)
	{
		System.out.println("test"+username+password);
	}

}
