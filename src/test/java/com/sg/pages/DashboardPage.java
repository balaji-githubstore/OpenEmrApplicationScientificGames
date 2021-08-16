package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	private By flowBoardLocator=By.xpath("//div[text()='Flow Board']");
	private By aboutLocator=By.xpath("//div[text()='About']");
	
	private WebDriver driver;
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPresenceOfFlowBoard()
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(flowBoardLocator));
	}
	
	public String getCurrentTitle()
	{
		return driver.getTitle().trim();
	}
	
	public void clickOnFlowBoard()
	{
		driver.findElement(flowBoardLocator).click();
	}
	
	public void clickOnAbout()
	{
		driver.findElement(aboutLocator).click();
	}

}
