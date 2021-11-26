package com.flipkart.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Baseclass.BaseClass;

public class Login extends BaseClass{
	private static Login login;
	private static WebDriver drivers;
	private Login() {}
	public static synchronized Login getLogin(WebDriver driver) {
		if(login==null) {
			login = new Login();
			drivers = driver;
		}	
		return login;
	}
	
	
	
	private WebElement username() {
		return driver.findElement(By.xpath(""));
	}
	
	public void getusername() {
		username();
	}
}
