package com.monefy.app;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Baseclass.WebTestBase;
import com.aventstack.extentreports.ExtentTest;

public class PieChartElements extends WebTestBase{
	
	WebDriver driver;
	
	public PieChartElements(WebDriver driver, ExtentTest extentTest){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.monefy.app.lite:id/balance_amount")
	private WebElement displayBalance;
	
	@FindBy(id = "com.monefy.app.lite:id/rightLinesImageView")
	private WebElement listItemViewRight;
	
	@FindBy(id = "com.monefy.app.lite:id/leftLinesImageView")
	private WebElement listItemViewLeft;
	
	@FindBy(id = "com.monefy.app.lite:id/buttonChooseListSortingMode")
	private WebElement displayInCategory_and_Dates;
	
	@FindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
	private WebElement getFirstElementText;
	
	@FindBy(xpath = "//android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]")
	private WebElement getFirstElementTexts;
	
	@FindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
	private WebElement categoryElement;
	
	@FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
	private WebElement categoryElements;
	
	@FindBy(id = "com.monefy.app.lite:id/textViewCategoryName")
	private WebElement firstCategory;
	
	@FindBy(id = "com.monefy.app.lite:id/textViewTransactionAmount")
	private WebElement firstAmount;
	
	public void clickBalance() {
		displayBalance.click();
	}
	
	public void verifyCategoryName(String category) {
		//displayInCategory_and_Dates.click();
		String text2 = firstCategory.getText();
		if(checkCategoryOrDate()) {
			try {
				String text = getFirstElementText.getText();
				Assert.assertEquals(category, text2, "Vefy the category is correct or not");
			}
			catch (NoSuchElementException e) {
				String text = getFirstElementTexts.getText();
				Assert.assertEquals(category, text2, "Vefy the category is correct or not");
			}
		}
	}
	
	public void verifyCategoryAmount(String ExpAmount) {
		firstCategory.click();
		String amount = firstAmount.getText();
		String replaceAll = amount.replaceAll("\\.0*$", "");
		String actualNumber = replaceAll.replaceAll("[$]", "");
		Assert.assertEquals(ExpAmount, actualNumber, "Amount is not equal");
	}
	
	public boolean checkCategoryOrDate() {
		boolean isCategory = false;
		
		try{
			String text = getFirstElementText.getText();
			String date = text.split(" ")[0];
			Integer.parseInt(date);
			isCategory = false;
		}
		catch (NoSuchElementException e) {
			try {
				String text = getFirstElementTexts.getText();
				String date = text.split(" ")[0];
				Integer.parseInt(date);
			}
			catch (Exception el) {
				isCategory = true;
			}
		}
		catch (NumberFormatException e) {
			isCategory = true;
		}
		return isCategory;
	}
}
