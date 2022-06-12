package testSteps;

import java.io.IOException;

import com.Baseclass.WebTestBase;
import com.aventstack.extentreports.ExtentTest;
import com.customException.BrowserException;
import com.monefy.app.ExpOrInc;
import com.monefy.app.PieChartElements;
import com.monefy.app.StartActivity;
import com.monefy.app.Transfer;
import com.runner.TestRunner;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExpenseIncome extends WebTestBase{
	
	WebTestBase webTestBase;
	AppiumDriver driver;
	ExpOrInc expOrInc;
	StartActivity activity;
	TestRunner runner = new TestRunner();
	PieChartElements chartElements;
	String CategoryName, amount;
	Transfer transfer;
	
	@Given("user launches the application")
	public void user_launches_the_application() throws BrowserException, IOException, InterruptedException {
		driver = MobileDevice(getAppName());
		webTestBase = new WebTestBase(driver);
		ExtentTest createTest = runner.createTest("Add Epense/Income", "Track Expenses or Income", driver);
		expOrInc = new ExpOrInc(driver, createTest);
		activity = new StartActivity(driver, createTest);
		chartElements = new PieChartElements(driver, createTest);
		transfer = new Transfer(driver, createTest);
		activity.clickGetStarted();
	}
	
	@Given("user clicks on Expense button to add expense")
	public void user_clicks_on_button_to_add_expense() {
		expOrInc.clickExpenseOrIncome("Expense");
	}
	
	@When("User enters the {string} and chooses the category")
	public void user_enters_the_and_chooses_the_category(String amount) {
		CategoryName = expOrInc.addExpenseOrIncome(amount, 3);
		this.amount = amount;
	}
	
	@Given("user clicks on Income button to add Income")
	public void user_clicks_on_income_button_to_add_income() {
		expOrInc.clickExpenseOrIncome("Income");
	}
	
	@Then("Date should br displayed on the pie chart")
	public void date_should_br_displayed_on_the_pie_chart() {
		chartElements.clickBalance();
		
		boolean checkCategoryOrDate = chartElements.checkCategoryOrDate();
		if(checkCategoryOrDate) {
			chartElements.verifyCategoryName(CategoryName);
			chartElements.verifyCategoryAmount(amount);
		}
		else
			System.out.println("Numbers...!");
	}
	
	@Given("user clicks on transferIcon")
	public void user_clicks_on_transferIcon() {
		transfer.clickDots();
	}
	
	@When("user enters in {string} and click on back ")
	public void user_clicks_on_accounts_and_user_enters_in_and_click_on_back(String string) throws InterruptedException {
		transfer.openCash(amount);
	}
	
	@Then("the amount must get displayed in the selected category")
	public void the_amount_must_get_displayed_in_the_selected_category() {
	    
	}
	
	@When("user click on transfer and transfers money")
	public void user_click_on_transfer_and_transfers_money() {
	    
	}
	
	@Then("verify that the transferred amount is shown or not")
	public void verify_that_the_transferred_amount_is_shown_or_not() {
	    
	}
	
	@When("user enters in {string} and click on back")
	public void user_enters_in_and_click_on_back(String string) {
	    
	}
	
}