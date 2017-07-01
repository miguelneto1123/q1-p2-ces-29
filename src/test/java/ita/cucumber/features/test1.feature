# Author: Miguel
# Date: 07/01/2017

@test1
Feature: Calculator
	#As a user
	#I want to use a calculator
	#So that I don't have to calculate myself
	Scenario: Add two numbers
	Given I have a calculator
	When I add 2 and 3
	Then the result should be 5