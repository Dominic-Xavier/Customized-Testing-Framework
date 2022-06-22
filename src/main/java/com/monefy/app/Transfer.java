package com.monefy.app;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Reports.ReportStatus;
import com.Reports.Reports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class Transfer {
	AppiumDriver driver;
	ExtentTest extentTest;
	public Transfer(AppiumDriver driver, ExtentTest extentTest) {
		this.driver = driver;
		this.extentTest = extentTest;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.monefy.app.lite:id/overflow")
	private WebElement clickDots;
	
	@FindBy(xpath = "//*[@resource-id='com.monefy.app.lite:id/accounts_button']")
	private WebElement clickAccounts;
	
	@FindBy(id = "com.monefy.app.lite:id/accounts_button")
	private WebElement clickAccountss;
	
	@FindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[1]")
	private WebElement cash;
	
	@FindBy(id = "com.monefy.app.lite:id/initialAmount")
	private WebElement accountBalance;
	
	@FindBy(id = "Navigate up")
	private WebElement backNavigation;
	
	@FindBy(id = "com.monefy.app.lite:id/transfer_menu_item")
	private WebElement transferIcon;
	
	@FindBy(xpath = "//android.widget.Spinner[1]/android.widget.LinearLayout/android.widget.LinearLayout")
	private WebElement clickFirstElement;
	
	@FindBy(xpath = "//android.widget.Spinner[2]/android.widget.LinearLayout/android.widget.LinearLayout")
	private WebElement clickSecondElement;
	
	@FindBy(id = "com.monefy.app.lite:id/show_keyboard_fab")
	private WebElement transferButton;
	
	@FindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
	private WebElement addTransfer;
	
	public void clickTransferIcon() {
		transferIcon.click();
	}
	
	public void clickDots() throws IOException{
		clickDots.click();
		Reports.log(extentTest, "Clicked threeDots", ReportStatus.Pass);
	}
	
	public void openCash(String amount) throws InterruptedException, IOException {
		Thread.sleep(3000);
		//driver.switchTo().frame(1);
		try {
			clickAccountss.click();
			Reports.log(extentTest, "Clicked Accounts", ReportStatus.Pass);
			cash.click();
			Reports.log(extentTest, "Clicked Cash", ReportStatus.Pass);
			accountBalance.sendKeys(amount);
			driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
			Reports.log(extentTest, "Clicked Back button", ReportStatus.Pass);
			//backNavigation.click();
		}
		catch (Exception e) {
			Reports.log(extentTest, "Options did not click", ReportStatus.Fail);
		}
	}
	
	public void transFerMoney(String amount, int firstIndex, int secondIndex) {
		transferIcon.click();
		clickFirstElement.click();
		driver.findElement(By.xpath("android.widget.LinearLayout["+firstIndex+"]/android.widget.LinearLayout"));
		clickSecondElement.click();
		driver.findElement(By.xpath("android.widget.LinearLayout["+secondIndex+"]/android.widget.LinearLayout"));
		transferButton.click();
		for(int i=0; i<amount.length(); i++)
			driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard"+amount.charAt(i)));
		addTransfer.click();
	}
}
