# Author: Miguel
# Date 02/07/2017

Feature: Buying a book
Background:
	Given this book database
	| title               | quantity | price |
	| Sailing and Ropes   | 3        | 45.00 |
	| Harpoons and Whales | 1        | 55.00 |
	| Advanced Knotting   | 0        | 50.00 |
	| Sailing 101         | 10       | 75.00 |

Scenario: buying a book that has stock
	When I try to buy "Harpoons and Whales"
	Then I must be able to buy it
	Then Its quantity should now be 0

Scenario: buying a book that has no stock
	When I try to buy "Advanced Knotting"
	Then I must not be able to buy it

Scenario: buying a book that isn't in the database
	When I try to buy "Anchor History"
	Then I should see it doesn't exist in the database