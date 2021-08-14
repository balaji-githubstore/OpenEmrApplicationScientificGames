package com.sg.test;
	
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sg.base.WebDriverWrapper;

public class LoginTest extends WebDriverWrapper {
	@Test
	public void validCredentialTest() {
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select selectLang = new Select(driver.findElement(By.name("languageChoice")));
		selectLang.selectByVisibleText("English (Indian)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Flow Board']")));

		String actualValue = driver.getTitle();
		Assert.assertEquals(actualValue, "OpenEMR");
	}
	
	@Test
	public void invalidCredentialTest()
	{
		driver.findElement(By.id("authUser")).sendKeys("admin123");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select selectLang = new Select(driver.findElement(By.name("languageChoice")));
		selectLang.selectByVisibleText("English (Indian)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String actualValue=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
		
		//get and assert the error message
		Assert.assertEquals(actualValue, "Invalid username or password");
	}
}







