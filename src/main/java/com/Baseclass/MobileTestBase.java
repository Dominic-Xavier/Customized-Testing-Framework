package com.Baseclass;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MobileTestBase{
	
	public static WebDriver appiumDriver; 
	private static DesiredCapabilities cap;
	
	public WebDriver launchAndroidApp(String deviceName, String udId, String os, String platformVersion, String appPackage, 
			String appActivity, AUTOMATOR automator, String ip, String port, String path) throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udId", udId);
		cap.setCapability("platformName", os);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("appPackage", appPackage);
		cap.setCapability("appActivity", appActivity);
		cap.setCapability("automationName", automator.toString());
		
		appiumDriver = new AndroidDriver<MobileElement>(new URL(ip+":"+port+path), cap);
		
		System.out.println("Application started");
		return appiumDriver;
	}
	
	public WebDriver launchAndroidApp(String deviceName, String udId, String os, String platformVersion, String appPath, 
			AUTOMATOR automator,String ip, String port, String path) throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udId", udId);
		cap.setCapability("platformName", os);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("app", appPath);
		cap.setCapability("automationName", automator.toString());
		
		appiumDriver = new AndroidDriver<MobileElement>(new URL(ip+":"+port+path), cap);
		System.out.println("Application started");
		return appiumDriver;
	}
	
	public WebDriver launchIOSApp(String deviceName, String udId, String os, String platformVersion, String appPackage, String appActivity,
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
		return appiumDriver;
	}
	
	public WebDriver launchIOSApp(String deviceName, String udId, String os, String platformVersion, String appPath, 
			AUTOMATOR automator,String ip, String port, String path) throws MalformedURLException {
		cap = new DesiredCapabilities();
		cap.setCapability("deviceName", deviceName);
		cap.setCapability("udId", udId);
		cap.setCapability("platformName", os);
		cap.setCapability("platformVersion", platformVersion);
		cap.setCapability("app", appPath);
		cap.setCapability("automationName", automator);
		
		appiumDriver = new IOSDriver<MobileElement>(new URL(ip+":"+port+path), cap);
		System.out.println("Application started");
		return appiumDriver;
	}
	
}
