package testSteps;

import com.Baseclass.WebTestBase;
import com.excelSheet.ExcelSheet;

import java.io.IOException;

import com.Baseclass.BrowserName;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class Login extends WebTestBase{
	
	ExcelSheet excelSheet = ExcelSheet.getExcelSheet();
	
	@Before
	public void launchApplication() throws IOException {
		String URL = excelSheet.getData("URL");
		openBrowser(BrowserName.CHROME, URL, OperatingSystem.LINUX);
	}
	
	@Given("user logs into the application with username {string} and Password {string}")
	public void user_logs_into_the_application_with_username_and_password(String string, String string2) throws IOException {
		System.out.println("URL is "+excelSheet.getData("URL"));
	}
	
	@After
	public void closeApp() {
		closeTab();
	}
}