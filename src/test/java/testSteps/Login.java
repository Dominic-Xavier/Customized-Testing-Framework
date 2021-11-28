package testSteps;

import com.Baseclass.WebTestBase;
import com.Reports.ReportStatus;
import com.Reports.Reports;
import com.customException.FolderNotCreated;
import com.excelSheet.DataProviders;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.WebDriver;

import com.Baseclass.BrowserName;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class Login {

	DataProviders excelSheet = DataProviders.getInstance();
	static Reports reports;
	static WebTestBase base, base1;
	
	@Before
	public void launchApplication() throws IOException, FolderNotCreated, InterruptedException {
		//reports = Reports.getInstaice(this.getClass());
		String URL = excelSheet.getData("URL");
		//WebDriver chromeDriver = WebTestBase.getWebDriver(BrowserName.CHROME, URL, OperatingSystem.LINUX);
		//base = WebTestBase.getInstance(chromeDriver);
		WebDriver firefoxDriver = WebTestBase.getWebDriver(BrowserName.FIREFOX, URL, OperatingSystem.LINUX);
		base1 = WebTestBase.getInstance(firefoxDriver);
		//reports.logs("Opened successfully", ReportStatus.Pass);
		Thread.sleep(5000);
	}
	
	@Given("user logs into the application with username {string} and Password {string}")
	public void user_logs_into_the_application_with_username_and_password(String string, String string2) throws IOException, AWTException, InterruptedException {
		System.out.println("URL is "+excelSheet.getData("URL"));
		WebTestBase.enterText(string);
		Thread.sleep(5000);
	}
	
	@After
	public void closeApp() {
		base.closeTab();
		base1.closeTab();
	}
}