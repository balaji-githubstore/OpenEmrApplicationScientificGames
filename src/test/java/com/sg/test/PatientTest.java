package com.sg.test;
	
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;

public class PatientTest extends WebDriverWrapper {

	@Test
	public void addPatientTest()
	{
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select selectLang = new Select(driver.findElement(By.name("languageChoice")));
		selectLang.selectByVisibleText("English (Indian)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//firstname - john 
		//lastname - paul
		
		//Assert the added record Medical Record Dashboard - John Paul
	}
}
