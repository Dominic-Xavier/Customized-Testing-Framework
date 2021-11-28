package com.Baseclass;

import java.time.Duration;
import java.util.Set;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.OperatingSystem;

public class WebTestBase {
	
	private static Select select;
	private static WebDriverWait wait;
	private static WebDriver driver, chrome, firefox, ieDriver, safari, edge;
	private static WebTestBase testBase;
	
	private WebTestBase(WebDriver webDriver) {
		//Pass getInstance method Here
		driver = webDriver;
	}
	
	public synchronized static WebTestBase getInstance(WebDriver driver) {
		if(testBase==null)
			testBase = new WebTestBase(driver);
		return testBase;
	}
	
	public static synchronized WebDriver getWebDriver(BrowserName browserName, String url, OperatingSystem os) {
		
		switch (browserName) {
			case CHROME:
				WebDriverManager.chromedriver().operatingSystem(os).setup();
				if(chrome==null)
					chrome = new ChromeDriver();
				chrome.get(url);
				chrome.manage().window().maximize();
				return chrome;
			case FIREFOX:
				WebDriverManager.firefoxdriver().operatingSystem(os).setup();
				if(firefox==null)
					firefox = new FirefoxDriver();
				firefox.get(url);
				firefox.manage().window().maximize();
				return firefox;
				
			case IE:
				WebDriverManager.iedriver().operatingSystem(os).setup();
				if(ieDriver==null)
					ieDriver = new InternetExplorerDriver();
				ieDriver.get(url);
				ieDriver.manage().window().maximize();
				return ieDriver;
				
			case SAFARI:
				WebDriverManager.safaridriver().operatingSystem(os).setup();
				if(safari==null)
					safari = new SafariDriver();
				safari.get(url);
				safari.manage().window().maximize();
				return safari;
			
			case EDGE:
				WebDriverManager.edgedriver().operatingSystem(os).setup();
				if(edge==null)
					edge = new EdgeDriver();
				edge.get(url);
				edge.manage().window().maximize();
				return edge;
				
		}
		return null;
	}
	
	
	
	public Set<String> getWindowHandles(){
		return driver.getWindowHandles();
	}
	
	public void selectByValueOrVisibletext(SelectBy by, WebElement element, String text) {
		switch (by) {
		case SELECT_BY_VALUE:
			select = new Select(element);
			select.selectByValue(text);
		break;

		case SELECT_BY_VISIBLE_TEXT:
			select = new Select(element);
			select.selectByVisibleText(text);
		break;
		
		case SELECT_BY_INDEX:
			select = new Select(element);
			select.selectByIndex(Integer.parseInt(text));
		break;
		
		case DESELECT_BY_INDEX:
			select = new Select(element);
			select.deselectByIndex(Integer.parseInt(text));
		break;
		
		case DESELECT_BY_VALUE:
			select = new Select(element);
			select.deselectByValue(text);
		break;
		
		case DESELECT_BY_VISIBLE_TEXT:
			select = new Select(element);
			select.deselectByVisibleText(text);
		break;
		
		case DESELECT_ALL:
			select = new Select(element);
			select.deselectAll();
		break;
		
		}
	}
	
	public void implicitWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public void explicitWait(WebDriver driver, long seconds, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void navigateFordWard() {
		driver.navigate().forward();
	}
	
	public void navigateBackWard() {
		driver.navigate().back();
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public static void enterText(String text) throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < text.length(); i++) {
			char charAt = text.charAt(i);
			switch (charAt) {
			case 'A':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_A);
			break;
			
			case 'a':
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);
			break;
			
			case 'B':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_B);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_B);
			break;
			
			case 'b':
				robot.keyPress(KeyEvent.VK_B);
				robot.keyRelease(KeyEvent.VK_B);
			break;
			
			case 'C':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_C);
			break;
			
			case 'c':
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_C);
			break;
			
			case 'D':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_D);
			break;
			
			case 'd':
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_D);
			break;
			
			case 'E':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_E);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_E);
			break;
			
			case 'e':
				robot.keyPress(KeyEvent.VK_E);
				robot.keyRelease(KeyEvent.VK_E);
			break;
			
			case 'F':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_F);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_F);
			break;
			
			case 'f':
				robot.keyPress(KeyEvent.VK_F);
				robot.keyRelease(KeyEvent.VK_F);
			break;
			
			case 'G':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_G);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_G);
			break;
			
			case 'g':
				robot.keyPress(KeyEvent.VK_G);
				robot.keyRelease(KeyEvent.VK_G);
			break;
			
			case 'H':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_H);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_H);
			break;
			
			case 'h':
				robot.keyPress(KeyEvent.VK_H);
				robot.keyRelease(KeyEvent.VK_H);
			break;
			
			case 'I':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_I);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_I);
			break;
			
			case 'i':
				robot.keyPress(KeyEvent.VK_I);
				robot.keyRelease(KeyEvent.VK_I);
			break;
			
			case 'J':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_J);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_J);
			break;
			
			case 'j':
				robot.keyPress(KeyEvent.VK_J);
				robot.keyRelease(KeyEvent.VK_J);
			break;
			
			case 'K':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_K);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_K);
			break;
			
			case 'k':
				robot.keyPress(KeyEvent.VK_K);
				robot.keyRelease(KeyEvent.VK_K);
			break;
			
			case 'L':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_L);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_L);
			break;
			
			case 'l':
				robot.keyPress(KeyEvent.VK_L);
				robot.keyRelease(KeyEvent.VK_L);
			break;
			
			case 'M':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_M);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_M);
			break;
			
			case 'm':
				robot.keyPress(KeyEvent.VK_M);
				robot.keyRelease(KeyEvent.VK_M);
			break;
			
			case 'N':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_N);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_N);
			break;
			
			case 'n':
				robot.keyPress(KeyEvent.VK_N);
				robot.keyRelease(KeyEvent.VK_N);
			break;
			
			case 'O':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_O);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_O);
			break;
			
			case 'o':
				robot.keyPress(KeyEvent.VK_O);
				robot.keyRelease(KeyEvent.VK_O);
			break;
			
			case 'P':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_P);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_P);
			break;
			
			case 'p':
				robot.keyPress(KeyEvent.VK_P);
				robot.keyRelease(KeyEvent.VK_P);
			break;
			
			case 'Q':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_Q);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_Q);
			break;
			
			case 'q':
				robot.keyPress(KeyEvent.VK_Q);
				robot.keyRelease(KeyEvent.VK_Q);
			break;
			
			case 'R':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_R);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_R);
			break;
			
			case 'r':
				robot.keyPress(KeyEvent.VK_R);
				robot.keyRelease(KeyEvent.VK_R);
			break;
			
			case 'S':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_S);
			break;
			
			case 's':
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S);
			break;
			
			case 'T':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_T);
			break;
			
			case 't':
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T);
			break;
			
			case 'U':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_U);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_U);
			break;
			
			case 'u':
				robot.keyPress(KeyEvent.VK_U);
				robot.keyRelease(KeyEvent.VK_U);
			break;
			
			case 'V':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_V);
			break;
			
			case 'v':
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
			break;
			
			case 'W':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_W);
			break;
			
			case 'w':
				robot.keyPress(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_W);
			break;
			
			case 'X':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_X);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_X);
			break;
			
			case 'x':
				robot.keyPress(KeyEvent.VK_X);
				robot.keyRelease(KeyEvent.VK_X);
			break;
			
			case 'Y':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_Y);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_Y);
			break;
			
			case 'y':
				robot.keyPress(KeyEvent.VK_Y);
				robot.keyRelease(KeyEvent.VK_Y);
			break;
			
			case 'Z':
				robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_Z);
				robot.keyRelease(KeyEvent.VK_SHIFT);
				robot.keyRelease(KeyEvent.VK_Z);
			break;
			
			case 'z':
				robot.keyPress(KeyEvent.VK_Z);
				robot.keyRelease(KeyEvent.VK_Z);
			break;
			
			case '0':
				robot.keyPress(KeyEvent.VK_0);
				robot.keyRelease(KeyEvent.VK_0);
			break;
			
			case '1':
				robot.keyPress(KeyEvent.VK_1);
				robot.keyRelease(KeyEvent.VK_1);
			break;
			
			case '2':
				robot.keyPress(KeyEvent.VK_2);
				robot.keyRelease(KeyEvent.VK_2);
			break;
			
			case '3':
				robot.keyPress(KeyEvent.VK_3);
				robot.keyRelease(KeyEvent.VK_3);
			break;
			
			case '4':
				robot.keyPress(KeyEvent.VK_4);
				robot.keyRelease(KeyEvent.VK_4);
			break;
			
			case '5':
				robot.keyPress(KeyEvent.VK_5);
				robot.keyRelease(KeyEvent.VK_5);
			break;
			
			case '6':
				robot.keyPress(KeyEvent.VK_6);
				robot.keyRelease(KeyEvent.VK_6);
			break;
			
			case '7':
				robot.keyPress(KeyEvent.VK_7);
				robot.keyRelease(KeyEvent.VK_7);
			break;
			
			case '8':
				robot.keyPress(KeyEvent.VK_8);
				robot.keyRelease(KeyEvent.VK_8);
			break;
			
			case '9':
				robot.keyPress(KeyEvent.VK_9);
				robot.keyRelease(KeyEvent.VK_9);
			break;
			
			case ' ':
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_SPACE);
			break;
			}
		}
		
	}
	
	public void closeTab() {
		driver.close();
	}
	
	public void closeBrowser() {
		driver.quit();
	}
}