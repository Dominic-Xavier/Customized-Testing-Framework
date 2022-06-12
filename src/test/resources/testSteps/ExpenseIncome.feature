Feature: ExpenseIncome
Description: CRUD Operations on Expenses and Income

Background:
	Given user launches the applicatio

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

Scenario Outline: Transfer Cash
	Given user clicks on transferIcon
	When user enters in "<Amount>" and click on back
	Then the amount must get displayed in the selected category
	When user click on transfer and transfers money
	Then verify that the transferred amount is shown or not 
Examples:
|Amount|
| 600  |