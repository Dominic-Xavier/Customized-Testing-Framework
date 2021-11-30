package com.flipkart.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Baseclass.WebTestBase;
import com.excelSheet.DataProviders;

public class UserCredentials extends WebTestBase{
	private static UserCredentials credentials;
	private UserCredentials() {
		/*element("login_btn_SignIn", By.linkText("Sign in"));
		element("login_txt_Username", By.id("email"));
		element("login_txt_Password", By.id("passwd"));
		element("login_btn_signIn", By.id("SubmitLogin"));
		element("login_lnk_Forgotpassword?", By.linkText("Forgot your password?"));
		element("login_txt_registerEmail", By.id("email_create"));
		element("login_btn_createAccount", By.id("SubmitCreate"));*/
	}
	
	private By signin = By.linkText("Sign in");
	
	public static UserCredentials getInstance() {
		if(credentials==null) {
			credentials = new UserCredentials();
			//Always give element("classname_txt/btn_elementName", By.locator);
			/*element("login_btn_SignIn", By.linkText("Sign in"));
			element("login_txt_Username", By.id("email"));
			element("login_txt_Password", By.id("passwd"));
			element("login_btn_signIn", By.id("SubmitLogin"));
			element("login_lnk_Forgotpassword?", By.linkText("Forgot your password?"));
			element("login_txt_registerEmail", By.id("email_create"));
			element("login_btn_createAccount",By.id("SubmitCreate"));*/
			
		}
		return credentials;
	}
	
	public void login(String username, String password) {
		//explicitWait(drivers, 60, element("login_btn_SignIn"));
		/*element("login_btn_SignIn").click();
		element("login_txt_Username").sendKeys(username);
		element("login_txt_Password").sendKeys(password);
		element("login_btn_signIn").click();*/
		
		drivers.findElement(signin).click();
	}
	
	public void register(String email) {
		element("login_txt_registerEmail").sendKeys(email);
		element("login_btn_createAccount").click();
	}
}
