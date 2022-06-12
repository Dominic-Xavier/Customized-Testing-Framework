package com.monefy.app;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.WebTestBase;
import com.aventstack.extentreports.ExtentTest;

public class ExpOrInc extends WebTestBase{
	
	public ExpOrInc(WebDriver driver, ExtentTest createTest){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "com.monefy.app.lite:id/buttonContinue")
	private WebElement getStarted;
	
	@FindBy(id = "com.monefy.app.lite:id/buttonClose")
	private WebElement closepopUP;
	
	@FindBy(id = "com.monefy.app.lite:id/expense_button")
	private WebElement expenseButton;
	
	@FindBy(id = "com.monefy.app.lite:id/income_button")
	private WebElement incomeButton;
	
	@FindBy(id = "com.monefy.app.lite:id/amount_text")
	private WebElement amountText;
	
	@FindBy(id = "com.monefy.app.lite:id/buttonKeyboardPlus")
	private WebElement btnPlus;
	
	@FindBy(id = "com.monefy.app.lite:id/buttonKeyboardMinus")
	private WebElement btnminus;
	
	@FindBy(id = "com.monefy.app.lite:id/buttonKeyboardDivide")
	private WebElement btnDiv;
	
	@FindBy(id = "com.monefy.app.lite:id/buttonKeyboardMultiply")
	private WebElement btnMul;
	
	@FindBy(id = "com.monefy.app.lite:id/buttonKeyboardClear")
	private WebElement btnClear;
	
	@FindBy(id = "com.monefy.app.lite:id/keyboard_action_button")
	private WebElement btnchooseCategory;
	
	@FindBy(id = "com.monefy.app.lite:id/textViewNote")
	private WebElement viewNotes;
	
	public void pressNumbers(String number) {
		for(int i=0;i<number.length();i++)
			driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard"+number.charAt(i)));
	}
	
	public void clickExpenseOrIncome(String choice) {
		if(choice.equals("Expense"))
			expenseButton.click();
		else
			incomeButton.click();
	}
	
	public String addExpenseOrIncome(String number, int index) {
		
		for(int i=0;i<number.length();i++)
			driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard"+number.charAt(i))).click();
		btnchooseCategory.click();
		String category;
		WebElement element;
		element = driver.findElement(By.xpath("//android.widget.GridView/android.widget.FrameLayout["+index+"]/android.widget.LinearLayout/android.widget.TextView"));
		category = element.getText();
		System.out.println("Category Text are "+category);
		element.click();
		return category;
	}
}