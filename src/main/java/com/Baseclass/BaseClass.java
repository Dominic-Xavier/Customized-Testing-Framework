package com.Baseclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class BaseClass {
	
	public static WebDriver driver;
	public static AppiumDriver<MobileElement> appiumDriver; 
	private static DesiredCapabilities cap;
	
	public void openBrowser(BrowserName browserName, String url, OperatingSystem os) {
		
		switch (browserName) {
			case CHROME:
				WebDriverManager.chromedriver().operatingSystem(os).setup();
				driver = new ChromeDriver();
				driver.get(url);
			break;
				
			case FIREFOX:
				WebDriverManager.firefoxdriver().operatingSystem(os).setup();
				driver = new FirefoxDriver();
				driver.get(url);
			break;
				
			case IE:
				WebDriverManager.iedriver().operatingSystem(os).setup();
				driver = new InternetExplorerDriver();
				driver.get(url);
			break;
				
			case SAFARI:
				WebDriverManager.safaridriver().operatingSystem(os).setup();
				driver = new SafariDriver();
				driver.get(url);
			break;
			
			case EDGE:
				WebDriverManager.edgedriver().operatingSystem(os).setup();
				driver = new EdgeDriver();
				driver.get(url);
			break;
		}
		
		driver.manage().window().maximize();
	}
	
	public void launchAndroidApp(String deviceName, String udId, OS os, String platformVersion, String appPackage, String appActivity, 
			AUTOMATOR automator, String ip, String port, String path) throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udId", udId);
		cap.setCapability("platformName", os);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		cap.setCapability("automationName", automator);
		
		appiumDriver = new AndroidDriver<MobileElement>(new URL(ip+":"+port+path), cap);
		
		System.out.println("Application started");
	}
	
	public void launchAndroidApp(String deviceName, String udId, OS os, String platformVersion, String appPath, AUTOMATOR automator,
			String ip, String port, String path) throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udId", udId);
		cap.setCapability("platformName", os);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("app", appPath);
		cap.setCapability("automationName", automator);
		
		appiumDriver = new AndroidDriver<MobileElement>(new URL(ip+":"+port+path), cap);
	}
	
	public void launchIOSApp(String deviceName, String udId, OS os, String platformVersion, String appPackage, String appActivity,
			AUTOMATOR automator, String ip, String port, String path) throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udId", udId);
		cap.setCapability("platformName", os);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		cap.setCapability("automationName", automator);
		
		appiumDriver = new IOSDriver<MobileElement>(new URL(ip+":"+port+path), cap);
		
		System.out.println("Application started");
	}
	
	public void launchIOSApp(String deviceName, String udId, OS os, String platformVersion, String appPath, AUTOMATOR automator,
			String ip, String port, String path) throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udId", udId);
		cap.setCapability("platformName", os);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("app", appPath);
		cap.setCapability("automationName", automator);
		
		appiumDriver = new IOSDriver<MobileElement>(new URL(ip+":"+port+path), cap);
	}
	
	public Set<String> getWindowHandles(){
		return driver.getWindowHandles();
	}
	
	public static int getRandomNumber() {
		Random random = new Random();
		return random.nextInt();
	}
	
	public static void closeTab() {
		driver.close();
	}
	
	public static void closeBrowser() {
		driver.quit();
	}
}
