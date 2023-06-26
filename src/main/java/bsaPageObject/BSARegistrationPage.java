package bsaPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.WebTestBase;

import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;

public class BSARegistrationPage {
	WebDriver driver;
	WebTestBase testBase;
	public BSARegistrationPage(WebDriver driver){
		this.driver = driver;
		testBase = new WebTestBase();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//button[text()='Accept']")
	public WebElement acceptCookies;
	
	
	@FindBy(xpath =  "//span[text()='Sign up']")
	public WebElement signUP;
	
	@FindBy(xpath =  "//input[@aria-label='Enter your first name']")
	public WebElement userName;
	
	@FindBys({@FindBy(xpath =  "//ul[starts-with(@class,'MuiList')]/li")})
	public List<WebElement> calenderDays;
	
	@FindBy(xpath = "//input[@placeholder='Postal Code / ZIP']")
	public WebElement zipCode;
	
	@FindBy(xpath = "//input[@placeholder='City']")
	public WebElement city;
	
	@FindBy(xpath = "//input[@placeholder='Email']")
	public WebElement email;
	
	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Please enter email confirmation']")
	public WebElement confirm_Email;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement password;
	
	@FindBy(xpath = "//input[@placeholder='Confirm Password']")
	public WebElement confirmPassword;
	
	@FindBy(xpath = "createprofile-profession-input")
	public WebElement occupation;
	
	@FindBy(id = "createprofile-ambition-select")
	public WebElement slidingBar;
	
	@FindBy(xpath = "//button[@type='button']")
	public WebElement letsGo;
	
	public WebElement dateSmokerOrHavingKids(String text) {
		return driver.findElement(By.xpath("//span[text()='"+text+"'][1]"));
	}
	
	public WebElement selectSpan(String text) {
		return driver.findElement(By.xpath("//span[text()='"+text+"']"));
	}
	
	
	
	public WebElement selectDiv(String text) {
		return driver.findElement(By.xpath("//div[text()='"+text+"']"));
	}
	
	public void selectCountry(String country) {
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[starts-with(@class,'MuiList')]/li/span[1]"));
		for (WebElement webElement : list) {
			if(webElement.getText().equals(country)) {
				webElement.click();
				break;
			}
		}
	}
	
	public void clickCalender(String date, String dayMonYear) {
		//date represents Date or month or year
		//dayMonYear represents Which Date or month or year
		testBase.explicitWait(60, selectDiv(date));
		selectDiv(date).click();
		for (WebElement webElement : calenderDays) {
			if(webElement.getText().equals(dayMonYear)) {
				webElement.click();
				break;
			}
		}
	}
	
}
