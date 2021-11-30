package com.testNgClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.customException.BrowserException;
import com.excelSheet.DataProviders;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriver{
	
	public static WebDriver chrome, firefox, ieDriver, safari, opera, edge;
	public static DataProviders dp;
	
	
	@Test(priority = 0)
	@Parameters("Browsername")
	public static void browserName(String browserName) throws BrowserException {
		
		switch (browserName.toUpperCase()) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			if(chrome==null)
				chrome = new ChromeDriver();
			chrome.manage().window().maximize();
			dp = new DataProviders(chrome);
		break;
		
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			if(firefox==null)
				firefox = new FirefoxDriver();
			firefox.manage().window().maximize();
			dp = new DataProviders(firefox);
		break;
			
		case "IE":
			WebDriverManager.iedriver().setup();
			if(ieDriver==null)
				ieDriver = new InternetExplorerDriver();
			ieDriver.manage().window().maximize();
			dp = new DataProviders(ieDriver);
		break;
			
		case "SAFARI":
			WebDriverManager.safaridriver().setup();
			if(safari==null)
				safari = new SafariDriver();
			safari.manage().window().maximize();
			dp = new DataProviders(safari);
		break;
		
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			if(edge==null)
				edge = new EdgeDriver();
			edge.manage().window().maximize();
			dp = new DataProviders(edge);
		break;
			
		case "OPERA":
			WebDriverManager.operadriver().setup();
			if(opera==null)
				opera = new OperaDriver();
			opera.manage().window().maximize();
			dp = new DataProviders(opera);
		break;
		
		default:
			throw new BrowserException();
		}
	}
}
