Feature: ExpenseIncome
Description: CRUD Operations on Expenses and Income

Background:
	Given user launches the application
	
Scenario Outline: Transfer Cash
	Given user clicks on transferIcon
	When user enters in "<Amount>" and click on back
Examples:
|Amount|
| 600  |

Scenario Outline: Adding Expenses
	Given user clicks on Expense button to add expense
	When User enters the "<Amount>" and chooses the category
	Then Date should br displayed on the pie chart
Examples:
|Amount|
|500|

Scenario Outline: Adding Income
	Given user clicks on Income button to add Income
	When User enters the "<Amount>" and chooses the category
	Then Date should br displayed on the pie chart
Examples:
|Amount|
|300|

