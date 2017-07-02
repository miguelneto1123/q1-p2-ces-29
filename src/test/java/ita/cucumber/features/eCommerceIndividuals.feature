# Author: Miguel
# Date: 07/01/2017

Feature: Individual needs
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

# As a novice sailor
# I want to get suggestions when selecting a book
# So that I buy what suits me
Scenario: Book has suggestions
	When I search for "Sailing and Ropes"
	Then I should see suggestions

Scenario: Book has no suggestions
	When I search for "Advanced Knotting"
	Then I should see no suggestions

# As a gift buyer
# I want to look for a book on a specific topic
# So that I can give it to a friend
Scenario: Topic has suggestions
	When I search for "whale"
	Then I should get books on this topic

Scenario: Topic has no suggestions
	When I search for "anchor"
	Then I should get no books on this topic