Feature: Calculator
Description: This is to automate desktop app

Background:
	Given user opens the app

Scenario Outline: User Adds two numbers
	When user clicks "<num1>" and "<num2>" number
	Then user verifies the added number is correct or not
	
Examples:
|num1|num2|
| 2  | 3  |