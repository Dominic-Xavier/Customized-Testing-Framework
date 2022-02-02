package calc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import mainPageObject.PageObject;

public class CalcPage extends PageObject{

	public CalcPage(WebDriver driver) {
		super(driver);
		element("btnSeven", By.name("Seven")); 
		element("btnPlus", By.name("Plus"));
		element("btnEight", By.name("Eight"));
		element("btnFive", By.name("Five")); 
	}
	
	public void justclick() {
		element("btnSeven").click();
		element("btnPlus").click();
		element("btnEight").click();
		element("btnFive").click();
	}

}
