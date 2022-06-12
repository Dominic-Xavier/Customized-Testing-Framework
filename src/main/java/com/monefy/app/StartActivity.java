package com.monefy.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.WebTestBase;
import com.aventstack.extentreports.ExtentTest;

public class StartActivity extends WebTestBase {
	
	WebDriver driver;
	
	public StartActivity(WebDriver driver, ExtentTest extentTest) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);;
	}
	
	@FindBy(id = "com.monefy.app.lite:id/buttonContinue")
	private WebElement getStarted;
	
	@FindBy(id = "com.monefy.app.lite:id/buttonClose")
	private WebElement closePopUp;
	
	public void clickGetStarted() throws InterruptedException{
		getStarted.click();
		Thread.sleep(2000);
		getStarted.click();
		implicitWait(10);
		getStarted.click();
		implicitWait(10);
		closePopUp.click();
	}
}
