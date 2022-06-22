package testSteps;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import com.Baseclass.CloudConnection;

import enumVariales.BrowserName;

public class NewTest {
	
	WebDriver driver;
	
	@Test
	public void f() throws MalformedURLException, AWTException {
		Robot robot = new Robot();
		driver = CloudConnection.connectWithSauceLabs(BrowserName.CHROME);
		driver.get("http://automationpractice.com/");
		String title = driver.getTitle();
		System.out.println("Title is "+title);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("Sampledata");
		driver.findElement(By.id("passwd")).sendKeys("Sampledata");
		driver.findElement(By.id("SubmitLogin")).click();
	}
}
