package com.bsa;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import com.Baseclass.WebTestBase;
import com.Reports.ReportStatus;
import com.Reports.Reports;
import com.aventstack.extentreports.ExtentTest;
import com.customException.BrowserException;
import com.customException.FolderNotCreated;
import com.excelSheet.DataProviders;
import com.testNgClass.BrowserDriver;

import bsaPageObject.BSARegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BSA extends WebTestBase{
	
	BSARegistrationPage bsaReg;
	WebTestBase testBase;
	Reports reports;
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws BrowserException, IOException, FolderNotCreated {
		driver = Initialize(getAppName(), dp.getData("URL"));
		reports = new Reports();
		testBase = new WebTestBase(driver);
		bsaReg = new BSARegistrationPage(driver);
	}
	
	@Test(dataProvider = "TestData", dataProviderClass = DataProviders.class)
	public void Test(String user, String gender, String region, String month, String day, String year,
			String country, String state, String city, String zipCode, String email, String userName, String passWord) throws BrowserException, IOException, FolderNotCreated, InterruptedException {
		ExtentTest createTest = reports.createTest("Test case 1", "Verify user can able to Sign UP", driver);
		clickElement(bsaReg.acceptCookies);
		clickElement(bsaReg.signUP);
		Reports.log(createTest, "User Registration", ReportStatus.Pass);
		type(bsaReg.userName, user);
		clickElement(bsaReg.signUP);
		Reports.log(createTest, "After clicking sign UP", ReportStatus.Pass);
		//Selecting Gender
		clickElement(bsaReg.selectSpan(gender));
		Reports.log(createTest, "Clicking Next", ReportStatus.Pass);
		clickElement(bsaReg.selectSpan("Next"));
		clickElement(bsaReg.selectSpan(region));
		Reports.log(createTest, "Clicking Next", ReportStatus.Pass);
		clickElement(bsaReg.selectSpan("Next"));
		//clickElement(bsaReg.selectDiv("Month"));
		
		Reports.log(createTest, "Birth Date", ReportStatus.Pass);
		bsaReg.clickCalender("Month", month);
		
		bsaReg.clickCalender("Day", day);
		
		bsaReg.clickCalender("Year", year);
		
		Reports.log(createTest, "Filled Details", ReportStatus.Pass);
		
		clickElement(bsaReg.selectSpan("Next"));
		
		Reports.log(createTest, "Country Details", ReportStatus.Pass);
		clickElement(bsaReg.selectDiv("Country"));
		bsaReg.selectCountry(country);
		
		Thread.sleep(2000);
		
		bsaReg.clickCalender("State / Province", state);
		type(bsaReg.city, city);
		type(bsaReg.zipCode, zipCode);
		clickElement(bsaReg.selectSpan("Next"));
		
		type(bsaReg.email, email);
		type(bsaReg.confirm_Email, email);
		clickElement(bsaReg.selectSpan("Next"));
		
		type(bsaReg.username, userName);
		type(bsaReg.password, passWord);
		type(bsaReg.confirmPassword, passWord);
		clickElement(bsaReg.selectSpan("Next"));
		
		reports.closeReport();
	}
	
	
}
