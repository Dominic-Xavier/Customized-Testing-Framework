package testSteps;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.Baseclass.WebTestBase;
import com.Reports.Reports;
import com.astrac.dashBoard.TeamPageObj;
import com.astrac.login.LoginAstrac;
import com.aventstack.extentreports.ExtentTest;
import com.customException.BrowserException;
import com.runner.TestRunner;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Team extends WebTestBase{
	
	LoginAstrac login;
	WebDriver driver;
	WebTestBase webTestBase;
	private TestRunner runner = new TestRunner();
	private ExtentTest createTest;
	String scenarioName;
	private TeamPageObj team;
	
	@Before
	public void before(Scenario scenario) {
		scenarioName = scenario.getName();
		System.err.println("Scenario name is "+scenarioName);
	}
	
	@Given("user opens app and passes URL")
	public void user_opens_app_and_passes_url() throws BrowserException, IOException {
		String URL = getData("URL");
		driver = Initialize(getAppName(), URL);
		webTestBase = new WebTestBase(driver);
	}
	
	@Then("User loggins using {string} and {string} into the application")
	public void user_loggins_using_and_into_the_application(String userName, String passWord) throws BrowserException, IOException {
		login = new LoginAstrac(driver);
		login.login(userName, passWord);
	}
	
	@Given("User clicks on add team button")
	public void user_clicks_on_add_team_button() throws IOException, InterruptedException {
		createTest = runner.createTest(scenarioName, "Adding a team Team", driver);
		ExtentTest test = new Reports().getTest(createTest, "Logging In");
		team = new TeamPageObj(driver, test);
		team.clickAddTeam();
	}
	
	@When("user enters {string} and {string} and {string} and clicks done")
	public void user_enters_and_and_and_clicks_done(String teamName, String ownerName, String description) throws IOException, AWTException, InterruptedException {
		team.addTem(teamName, ownerName);
	}
	
	@Then("Team name should be visible on left pane")
	public void team_name_should_be_visible_on_left_pane() throws AWTException, InterruptedException {
		List<String> list = team.getAllTeams();
		System.out.println("List of team Names are "+list);
	}
	
	@Given("User is on Dashboard")
	public void user_is_on_dashboard() {
	    
	}
	
	@When("User clicks on team settings")
	public void user_clicks_on_team_settings() {
	    
	}
	
	@When("user removes and adds <{string}> and {string} and {string} and {string} and clicks on done buton")
	public void user_removes_and_adds_and_and_and_and_clicks_on_done_buton(String string, String string2, String string3, String string4) {
	    
	}
	
	@Then("Verify the edited data updated successfully or not")
	public void verify_the_edited_data_updated_successfully_or_not() {
	    
	}
	
	@Given("User is on Dashboard module")
	public void user_is_on_dashboard_module() {
		
	}
	
	@When("User clicks on Delete Team for the team {string}")
	public void user_clicks_on_delete_team_for_the_team(String string) {
	    
	}
	
	@Then("Verify the team is deleted or not")
	public void verify_the_team_is_deleted_or_not() {
	    
	}
	
	@After
	public void close() {
		if(webTestBase!=null)
			webTestBase.closeBrowser();
		runner.closeReports();
	}
}
