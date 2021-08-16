package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage {

	private String mscFrameName = "msc";
	private By headerLocator = By.tagName("h1");
	private By versionLocator = By.tagName("h4");

	private WebDriver driver;

	public AboutPage(WebDriver driver) {
		this.driver = driver;
	}

	public void switchToMscFrame() {
		driver.switchTo().frame(mscFrameName);
	}

	public String getHeader() {
		return driver.findElement(headerLocator).getText().trim();
	}

	public String getVersion() {
		return driver.findElement(versionLocator).getText().trim();
	}
	
	public void SwitchOutOfFrame()
	{
		driver.switchTo().defaultContent();
	}
}
