package com.runner;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.excelSheet.DataProviders;

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
	
	static String data;
	
	@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
		/*try {
			data = DataProviders.getInstance().getData("Parallel Testing");
			System.out.println("Data is "+data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(data.toLowerCase().equals("yes"))*/
			return super.scenarios();
		/*else 
			return null;*/
    }
}