package testSteps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.Baseclass.WebTestBase;
import com.Reports.ReportStatus;
import com.Reports.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.customException.BrowserException;
import com.monefy.app.ExpOrInc;
import com.monefy.app.PieChartElements;
import com.monefy.app.StartActivity;
import com.monefy.app.Transfer;
import com.runner.TestRunner;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
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
	Scenario scenario;
	Reports reports = new Reports();
	static ExtentTest createTest;
	
	@Before
	public void before(Scenario scenario) {
		this.scenario = scenario;
		System.out.println("Scenario Name: "+scenario.getName());
	}
	
	@Given("user launches the application")
	public void user_launches_the_application() throws BrowserException, IOException, InterruptedException {
		driver = MobileDevice(getAppName());
		createTest = runner.createTest(scenario.getName(), "Track Expenses or Income", driver);
		webTestBase = new WebTestBase(driver);
		ExtentTest node = new Reports().createNode(createTest, "Launching App..!");
		Reports.log(node, "Starting android app", ReportStatus.pass);
		expOrInc = new ExpOrInc(driver, node);
		activity = new StartActivity(driver, node);
		chartElements = new PieChartElements(driver, node);
		activity.clickGetStarted();
	}
	
	@Given("user clicks on Expense button to add expense$")
	public void user_clicks_on_button_to_add_expense() throws IOException {
		ExtentTest test = new Reports().createNode(createTest, "Addlication Started....!!!");
		Reports.log(test, "Starting android app", ReportStatus.pass);
		expOrInc.clickExpenseOrIncome("Expense");
	}
	
	@When("User enters the {string} and chooses the category")
	public void user_enters_the_and_chooses_the_category(String amount) throws IOException {
		CategoryName = expOrInc.addExpenseOrIncome(amount, 3);
		this.amount = amount;
	}
	
	@Given("user clicks on Income button to add Income")
	public void user_clicks_on_income_button_to_add_income() throws IOException {
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
	public void user_clicks_on_transferIcon() throws IOException {
		ExtentTest createNode = reports.createNode(createTest, "Transferring money");
		transfer = new Transfer(driver, createNode);
		transfer.clickDots();
		Reports.log(createNode, "Clicked 3 Dots", ReportStatus.Pass );
	}
	
	@When("user enters in {string} and click on back")
	public void user_enters_in_and_click_on_back(String amount) throws InterruptedException, IOException {
		transfer.openCash(amount);
		
	}
	
	@After
	public void close() {
		if(runner!=null)
			runner.closeReports();
	}
}