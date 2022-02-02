package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"./src/test/resources/testSteps/desktop.feature"},
		glue = {"testSteps"},
		monochrome = true,
		dryRun = false,
		plugin = {"pretty","json:Reports/cucumber-reports/Cucumber.json", "html:Reports/cucumber-reports.html",
				"rerun:target/failedTestCases.txt"}
		)

public class DeskTop extends AbstractTestNGCucumberTests {
	
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
		return super.scenarios();
    }
	
}
