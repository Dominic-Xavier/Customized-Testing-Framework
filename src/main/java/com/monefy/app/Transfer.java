package com.monefy.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

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
	
	@FindBy(id = "com.monefy.app.lite:id/accounts_imagebutton")
	private WebElement clickAccounts;
	
	@FindBy(xpath = "//android.widget.LinearLayout/android.widget.TextView[1]")
	private WebElement cash;
	
	@FindBy(id = "com.monefy.app.lite:id/initialAmount")
	private WebElement accountBalance;
	
	@FindBy(id = "AppiumBy")
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
	
	public void clickDots(){
		clickDots.click();
	}
	
	public void openCash(String amount) throws InterruptedException {
		Thread.sleep(2000);
		clickAccounts.click();
		cash.click();
		accountBalance.sendKeys(amount);
		backNavigation.click();
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
