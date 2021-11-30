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
	
	static Reports reports;
	static UserCredentials userCredentials;
	
	@Before
	public void launchApplication() throws IOException, FolderNotCreated, InterruptedException {
		//reports = Reports.getInstaice(this.getClass());
		String URL = dp.getData("URL");
		passURL(URL);
	}
	
	@Given("User launches the application")
	public void user_launches_the_application() throws IOException, BrowserException {
		browserName("Chrome");
		String URL = dp.getData("URL");
		passURL(URL);
	}
	
	@Given("user logs into the application with username {string} and Password {string}")
	public void user_logs_into_the_application_with_username_and_password(String username, String password) throws IOException, AWTException, InterruptedException {
		//userCredentials = UserCredentials.getInstance();
		userCredentials = UserCredentials.getInstance();
		userCredentials.login(username, password);
	}
	
	@After
	public void closeApp() {
		closeTab();
	}
}