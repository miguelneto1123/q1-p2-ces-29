# Author: Miguel
# Date: 07/01/2017

@hardcoreSailor
Feature: Exact book search
# As a hardcore sailor
# I want to find exactly what I'm looking for
# So that I don't feel stupid while using the site
Background:
	Given this book database
	| title               | quantity | price |
	| Sailing and Ropes   | 3        | 45.00 |
	| Harpoons and Whales | 1        | 55.00 |
	| Advanced Knotting   | 0        | 50.00 |
	| Sailing 101         | 10       | 75.00 |

Scenario: Book is in database
	When I search for "Harpoons and Whales"
	Then I should see it's on stock
Scenario: Book isn't in database
	When I search for "Advanced Knotting"
	Then I should see it's not on stock