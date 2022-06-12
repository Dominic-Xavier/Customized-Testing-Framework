Feature: CRUD Operations on Teams

Description: It consists of all the test cases related to dashboard module

Background: Launching app
	Given user opens app and passes URL
	Then User loggins using "Sachin22@gmail.com" and "sachin2" into the application

Scenario Outline: Add Team
	Given User clicks on add team button
	When user enters "<Team Name>" and "<Owner Name>" and "<Description>" and clicks done
	Then Team name should be visible on left pane
	
Examples:
|  Team Name  |Owner Name|	 Description	|
|Astrac SAmple|	 manager |Sample Description|

Scenario Outline: Edit Team
	Given User is on Dashboard module
	When User clicks on team settings
	When user removes and adds "<Team Name>" and "<Team Owner>" and "<Team Members>" and "<Description>" and clicks on done buton
	Then Verify the edited data updated successfully or not
	
Examples:
|Team Name|Team Owner|Team Members|	  Description  |
|Test Team| Xavier123|	 sachin3  |Test Description|

Scenario: Delete Team
	Given User is on Dashboard module
	When User clicks on Delete Team for the team ""
	Then Verify the team is deleted or not
	