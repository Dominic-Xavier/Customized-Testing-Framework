Feature: Login

#Just a Sample Testcase
Scenario Outline: Login Scenario
	Given user logs into the application with username "<Username>" and Password "<Password>"
	
Examples:
|	Username  |	 Password	|
|some userdata|some password|