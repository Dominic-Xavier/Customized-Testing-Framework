package com.testNgClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Baseclass.WebTestBase;
import com.customException.BrowserException;
import com.excelSheet.DataProviders;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserDriver {
	
	public static WebDriver driver;
	public static DataProviders dp;
	private static String browserName;
	
	@Test
	@Parameters("Browsername")
	private void browserName(String browserNames) {
		browserName = browserNames;
	}
	
	public static String getbrowserName() {
		return browserName;
	}
	
	public static WebDriver Initialize(String browserName, String URL) throws BrowserException {
		
		switch (browserName.toUpperCase()) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
			WebDriver chrome = new ChromeDriver();
			chrome.manage().window().maximize();
			chrome.get(URL);
			driver = chrome;
			dp = new DataProviders();
		return chrome;
		
		case "FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			WebDriver firefox = new FirefoxDriver();
			firefox.manage().window().maximize();
			driver = firefox;
			dp = new DataProviders();
		return firefox;
			
		case "IE":
			WebDriverManager.iedriver().setup();
			WebDriver ieDriver = new InternetExplorerDriver();
			ieDriver.manage().window().maximize();
			driver = ieDriver;
			dp = new DataProviders();
		return ieDriver;
			
		case "SAFARI":
			WebDriverManager.safaridriver().setup();
			WebDriver safari = new SafariDriver();
			safari.manage().window().maximize();
			driver = safari;
			dp = new DataProviders();
		return safari;
		
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			WebDriver edge = new EdgeDriver();
			edge.manage().window().maximize();
			driver = edge;
			dp = new DataProviders();
		return edge;
			
		case "OPERA":
			WebDriverManager.operadriver().setup();
			WebDriver opera = new OperaDriver();
			opera.manage().window().maximize();
			opera.get(URL);
			driver = opera;
			dp = new DataProviders();
		return opera;
		
		default:
			throw new BrowserException();
		}
	}
	
	@Test(priority = 0)
	private void browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("THread ID is "+Thread.currentThread().getId());
		driver.findElement(By.name("q")).sendKeys("Trisha");
	}
	
	@Test(priority = 1)
	private void browser2() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("THread ID is "+Thread.currentThread().getId());
		driver.findElement(By.name("q")).sendKeys("Samantha");
	}
}
