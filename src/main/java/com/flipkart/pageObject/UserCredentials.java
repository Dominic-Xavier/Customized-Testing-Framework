package com.flipkart.pageObject;

import java.awt.AWTException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Baseclass.WebTestBase;
import com.excelSheet.DataProviders;

public class UserCredentials extends DataProviders{
	
	//private static UserCredentials credentials;
		private WebDriver driver;
		//private static final Map<String, By> elementDatas = new HashMap<String, By>();
		//private UserCredentials() {}
		private DataProviders dp;
	
	public UserCredentials(WebDriver driver) {
		super(driver);
		this.driver = driver;
		element("login_btn_SignIn", By.linkText("Sign in"));
		element("login_txt_Username", By.id("email"));
		element("login_txt_Password", By.id("passwd"));
		element("login_btn_signIn", By.id("SubmitLogin"));
		element("login_lnk_Forgotpassword?", By.linkText("Forgot your password?"));
		element("login_txt_registerEmail", By.id("email_create"));
		element("login_btn_createAccount",By.id("SubmitCreate"));
	}

	
	
	
	/*public UserCredentials(WebDriver drivers) {
		driver = drivers;
		element("login_btn_SignIn", By.linkText("Sign in"));
		element("login_txt_Username", By.id("email"));
		element("login_txt_Password", By.id("passwd"));
		element("login_btn_signIn", By.id("SubmitLogin"));
		element("login_lnk_Forgotpassword?", By.linkText("Forgot your password?"));
		element("login_txt_registerEmail", By.id("email_create"));
		element("login_btn_createAccount",By.id("SubmitCreate"));
	}*/
	
	//DataProviders dp = new DataProviders(driver);
	
	/*public static UserCredentials getInstance(WebDriver drivers) {
		if(credentials==null) {
			credentials = new UserCredentials();
			//Always give element("classname_txt/btn_elementName", By.locator);
			element("login_btn_SignIn", By.linkText("Sign in"));
			element("login_txt_Username", By.id("email"));
			element("login_txt_Password", By.id("passwd"));
			element("login_btn_signIn", By.id("SubmitLogin"));
			element("login_lnk_Forgotpassword?", By.linkText("Forgot your password?"));
			element("login_txt_registerEmail", By.id("email_create"));
			element("login_btn_createAccount",By.id("SubmitCreate"));
		}
		driver = drivers;
		return credentials;
	}*/
	
	public void login(String email, String password) throws InterruptedException {
		dp = new DataProviders(driver);
		element("login_btn_SignIn").click();
		Thread.sleep(2000);
		element("login_txt_Username").sendKeys(email);
		element("login_txt_Password").sendKeys(password);
		element("login_btn_signIn").click();
		Thread.sleep(2000);
	}
	
	public void register(String email) throws InterruptedException {
		dp = new DataProviders(driver);
		element("login_btn_SignIn").click();
		Thread.sleep(2000);
		element("login_txt_registerEmail").sendKeys(email);
		element("login_btn_createAccount").click();
		Thread.sleep(2000);
	}
}