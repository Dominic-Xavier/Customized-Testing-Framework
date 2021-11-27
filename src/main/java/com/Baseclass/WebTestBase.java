package com.Baseclass;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class WebTestBase {
	
	public static WebDriver driver;
	
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
