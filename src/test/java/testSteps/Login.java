package testSteps;

import com.Baseclass.BaseClass;
import com.Baseclass.BrowserName;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class Login extends BaseClass{
	
	@Before
	public void launchApplication() {
		openBrowser(BrowserName.CHROME, "https://www.flipkart.com/", OperatingSystem.LINUX);
	}
	
	@Given("user logs into the application with username {string} and Password {string}")
	public void user_logs_into_the_application_with_username_and_password(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@After
	public void closeApp() {
		closeTab();
	}
}
