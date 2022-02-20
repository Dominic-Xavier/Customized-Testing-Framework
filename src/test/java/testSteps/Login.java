package testSteps;

import com.Baseclass.WebTestBase;
import com.Reports.ReportStatus;
import com.Reports.Reports;
import com.Reports.ScreenRecorderUtil;
import com.aventstack.extentreports.ExtentTest;
import com.flipkart.pageObject.UserCredentials;
import com.runner.TestRunner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class Login extends WebTestBase{
	
	private WebDriver driver;
	private WebTestBase webTestBase;
	private UserCredentials userCredentials;
	private TestRunner runner = new TestRunner();
	private ExtentTest createTest;
	
	@Before
	public void createTest() {
		//createTest = runner.createTest(this.getClass().toString(), "Login Scenario");
		//createTest = runner.createTest("Login", "Login Scenario");
	}
	
	@Given("user opens app and passes URL")
	public void user_opens_app_and_passes_url() throws Exception {
		//System.out.println("Browser name is "+getbrowserName());
		String URL = getData("URL");
		driver = Initialize(getAppName(), URL);
		
		webTestBase = new WebTestBase(driver);
		//Reports.log(createTest, "BrowserOpened Successfully", ReportStatus.pass);
	}
	
	@Given("user logs into the application with username {string} and Password {string}")
	public void user_logs_into_the_application_with_username_and_password(String username, String password) throws Exception {
		//UserCredentials userCredentials = UserCredentials.getInstance(driver);
		createTest = runner.createTest("Login", "Login Scenario", driver);
		ScreenRecorderUtil.startRecord("Sample_Recording");
		userCredentials = new UserCredentials(driver, createTest);
		userCredentials.login(username, password);
		Reports.log(createTest, "Logged In", ReportStatus.pass);
		webTestBase.closeTab();
		ScreenRecorderUtil.stopRecord();
		Reports.log(createTest, "", ReportStatus.VIDEO);
	}
	
	@Given("User enters the {string} id to create an account")
	public void user_enters_the_id_to_create_an_account(String email) throws Exception {
		//UserCredentials userCredentials = UserCredentials.getInstance(driver);
		createTest = runner.createTest("Register", "Registration Scenario", driver);
		ScreenRecorderUtil.startRecord("Sample_Recording");
		userCredentials = new UserCredentials(driver, createTest);
		userCredentials.register(email);
		webTestBase.closeTab();
		ScreenRecorderUtil.stopRecord();
		Reports.log(createTest, "Regestered Successfully", ReportStatus.pass);
		Reports.log(createTest, "", ReportStatus.VIDEO);
	}
	
	@After
	public void close() {
		webTestBase.closeBrowser();
		runner.closeReports();
	}
}