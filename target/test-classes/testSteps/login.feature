Feature: Login
Description: This is a sample testcase for testing my framework.

Background: Launch Application
		Given User launches the application

#Just a Sample Testcase
Scenario Outline: Login Scenario
	Given user logs into the application with username "<Username>" and Password "<Password>"
	
Examples:
|		 Username  	 	 |	 Password	|
|vebas14497@servergem.com|vebas14497@123|

#Just a Sample Testcase
Scenario Outline: Register
	Given user logs into the application with username "<Username>" and Password "<Password>"
	
Examples:
|		 Username  	 	 |	 Password	|
|vebas14497@servergem.com|vebas14497@123|