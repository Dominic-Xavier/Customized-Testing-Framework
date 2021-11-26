package com.runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"./src/test/resources/testSteps"},
		glue = {"testSteps"},
		monochrome = true,
		dryRun = false,
		publish = true,
		plugin = {"pretty","json:Reports/cucumber-reports/Cucumber.json", "html:Reports/cucumber-reports.html",
				"rerun:target/failedTestCases.txt"}
)

public class TestRunner extends AbstractTestNGCucumberTests{
	
	/*@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/
}