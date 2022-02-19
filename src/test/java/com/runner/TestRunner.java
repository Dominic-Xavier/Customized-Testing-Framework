package com.runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.Reports.Reports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.customException.FolderNotCreated;

import io.cucumber.testng.CucumberOptions;
//import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"./src/test/resources/testSteps/login.feature"},
		glue = {"testSteps"},
		monochrome = true,
		dryRun = false,
		plugin = {"pretty","json:Reports/cucumber-reports/Cucumber.json", "html:Reports/cucumber-reports.html",
				"rerun:target/failedTestCases.txt"}
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	Reports reports = new Reports();
	static ExtentReports createReport;
	ExtentTest createTest;
	
	@BeforeClass
	public void createReport() throws FolderNotCreated, IOException {
		createReport = reports.createReport(this.getClass().toString());
	}
	
	public ExtentTest createTest(String testName, String description, WebDriver driver) {
		createTest = reports.createTest(testName, description, driver);
		return createTest;
	}
	
	public ExtentTest getTest() {
		return createTest;
	}
	
	public void closeReports() {
		reports.closeReport();
	}
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
		return super.scenarios();
    }
}