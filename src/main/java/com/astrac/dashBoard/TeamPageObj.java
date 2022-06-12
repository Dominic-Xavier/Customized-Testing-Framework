package com.astrac.dashBoard;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.Baseclass.WebTestBase;
import com.Reports.ReportStatus;
import com.Reports.Reports;
import com.aventstack.extentreports.ExtentTest;

import enumVariales.AlertBox;
import enumVariales.KeyBoard;
import groovyjarjarantlr4.v4.runtime.tree.xpath.XPath;
import mainPageObject.PageObject;

public class TeamPageObj extends WebTestBase{
	
	ExtentTest test;
	
	public TeamPageObj(WebDriver driver, ExtentTest test) {
		super(driver);
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Add Team']")
	private WebElement btnAddTeam;
	
	@FindBy(name = "team_name")
	private WebElement txtTeamName;
	
	@FindBy(xpath = "//div[text()='Assign owner to this team']")
	private WebElement txtOwner;
	
	@FindBy(xpath = "//button[text()='Done']")
	private WebElement btnDone;
	
	@FindBys({@FindBy(xpath = "//ul[@id='side-menu']/table/tbody/tr/td/li/a")})
	private List<WebElement> lnkTeamNames;

	/*public TeamPageObj(WebDriver driver, ExtentTest test) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.test = test;
		element("btnAddTeam", By.xpath("//span[text()='Add Team']"));
		element("txtTeamName", By.name("team_name"));
		element("txtOwner", By.xpath("//div[text()='Assign owner to this team']"));
		element("btnDone", By.xpath("//button[text()='Done']"));
		element("lnkTeamNames", By.xpath("//ul[@id='side-menu']/table/tbody/tr/td/li/a"));
	}*/
	
	public void clickAddTeam() throws InterruptedException {
		implicitWait(10);
		btnAddTeam.click();
	}
	
	public void addTem(String teamName, String ownerName) throws IOException, AWTException, InterruptedException {
		Reports.log(test, "User enters team details", ReportStatus.PASS);
		//btnAddTeam.click();
		Thread.sleep(3000);
		txtTeamName.click();
		enterText(teamName);
		txtOwner.click();
		enterText(ownerName);
		pressEnter();
		btnDone.click();
		ifAlertIsPresent(driver, AlertBox.ACCEPT, null);
	}
	
	public void addTem(String teamName, String ownerName, List<String> members, String description) {
		
	}
	
	public List<String> getAllTeams() throws AWTException, InterruptedException {
		List<String> team_Name = new ArrayList<>();
		Thread.sleep(2000);
		List<WebElement> list = lnkTeamNames;
		Thread.sleep(2000);
		//list.get(1).click();
		//Thread.sleep(2000);
		for(WebElement ele : list) {
			String text = ele.getText();
			/*if(text.equals(" "))
				keyBoardOperations(KeyBoard.PAGE_DOWN);*/
			team_Name.add(text);
		}
		return team_Name;
	}
}