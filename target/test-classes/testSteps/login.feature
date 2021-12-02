Feature: Login
Description: This is a sample testcase for testing my framework.	

#Background: Opening Application
	#Given user opens app and passes URL "http://automationpractice.com"

#Just a Sample Testcase
Scenario Outline: Login Scenario
	Given user opens app and passes URL "http://automationpractice.com"
	Given user logs into the application with username "<Username>" and Password "<Password>"
	
Examples:
|		 Username  	 	 |	 Password	|
|vebas14497@servergem.com|vebas14497@123|

Scenario Outline: Register
	Given user opens app and passes URL "http://automationpractice.com"
	Given User enters the "<Email>" id to create an account
	
Examples:
|		   Email		 | Password |
|webas14497@servergem.com|webas14497|