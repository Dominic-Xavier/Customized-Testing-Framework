package com.astrac.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import mainPageObject.PageObject;

public class LoginAstrac extends PageObject{

	public LoginAstrac(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		element("txtEmail", By.name("email"));
		element("txtPassword",By.name("password"));
		element("btnLogin", By.xpath("//button[text()='Login']"));
		element("lnkForgetPassword", By.linkText("Forgot password?"));
	}
	
	public void login(String email, String password) {
		element("txtEmail").sendKeys(email);
		element("txtPassword").sendKeys(password);
		element("btnLogin").click();
	}
}
