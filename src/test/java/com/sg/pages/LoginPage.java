package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.sg.base.WebDriverWrapper;

public class LoginPage {
	private By usernameLocator = By.id("authUser");
	private By passwordLocator = By.id("clearPass");
	private By languageLocator = By.name("languageChoice");
	private By loginLocator = By.xpath("//button[@type='submit']");
	private By ackLicCertiLocator = By.partialLinkText("Acknowledgments");
	private By appDescriptionLocator = By.xpath("//p[contains(text(),'most')]");
	private By errorLocator=By.xpath("//div[contains(text(),'Invalid')]");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		this.driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void selectLanguageByText(String language) {
		Select selectLang = new Select(driver.findElement(languageLocator));
		selectLang.selectByVisibleText(language);
	}

	public void clickOnLogin() {
		driver.findElement(loginLocator).click();
	}

	public void clickOnAckLicAndCertifi() {
		driver.findElement(ackLicCertiLocator).click();
	}

	public String getApplicationDescription() {
		String desc = driver.findElement(appDescriptionLocator).getText().trim();
		return desc;
	}

	public String getInvalidLoginErrorMessage() {
		return driver.findElement(errorLocator).getText().trim();
	}
}
