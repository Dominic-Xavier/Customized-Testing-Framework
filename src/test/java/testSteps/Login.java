package testSteps;

import com.Baseclass.WebTestBase;
import com.Reports.ReportStatus;
import com.Reports.Reports;
import com.customException.BrowserException;
import com.customException.FolderNotCreated;
import com.excelSheet.DataProviders;
import com.flipkart.pageObject.UserCredentials;
import com.testNgClass.BrowserDriver;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class Login extends WebTestBase{

	private WebDriver driver;
	private WebTestBase webTestBase;
	private UserCredentials userCredentials;
	
	@Given("user opens app and passes URL {string}")
	public void user_opens_app_and_passes_url(String URL) throws BrowserException, IOException {
		//System.out.println("Browser name is "+getbrowserName());
		driver = Initialize(getbrowserName(), URL);
		webTestBase = new WebTestBase(driver);
		//String data = dp.getData("URL");
		//Initialize(getbrowserName());
	}
	@Given("user logs into the application with username {string} and Password {string}")
	public void user_logs_into_the_application_with_username_and_password(String username, String password) throws InterruptedException {
		//UserCredentials userCredentials = UserCredentials.getInstance(driver);
		userCredentials = new UserCredentials(driver);
		userCredentials.login(username, password);
		webTestBase.closeTab();
	}
	
	@Given("User enters the {string} id to create an account")
	public void user_enters_the_id_to_create_an_account(String email) throws InterruptedException {
		//UserCredentials userCredentials = UserCredentials.getInstance(driver);
		userCredentials = new UserCredentials(driver);
		userCredentials.register(email);
		webTestBase.closeTab();
	}
	
	@After
	public void close() {
		webTestBase.closeBrowser();
	}
}