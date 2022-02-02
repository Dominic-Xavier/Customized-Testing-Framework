package testSteps;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.Baseclass.WebTestBase;
import com.Reports.ScreenRecorderUtil;
import com.customException.BrowserException;

import calc.CalcPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Calc extends WebTestBase{

	private WebDriver driver;
	private WebTestBase base;
	
	@Given("user opens the app")
	public void user_opens_the_app() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		driver  = Initialize(getAppName(), "");
		base = new WebTestBase(driver);
		ScreenRecorderUtil.startRecord("Sample_Recording");
	}
	
	@When("user clicks {string} and {string} number")
	public void user_clicks_and_number(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		CalcPage checks = new CalcPage(driver);
		checks.justclick();
	}
	
	@Then("user verifies the added number is correct or not")
	public void user_verifies_the_added_number_is_correct_or_not() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		ScreenRecorderUtil.stopRecord();
	}
	
	@After
	public void close() {
		base.closeBrowser();
	}
}
