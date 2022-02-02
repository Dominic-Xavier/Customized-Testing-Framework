package com.runner;

import org.testng.annotations.DataProvider;
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
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
		return super.scenarios();
    }
	
}