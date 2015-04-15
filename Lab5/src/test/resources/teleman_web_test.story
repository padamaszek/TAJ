Scenario: User searches for a single step
 
Given user is on Home page
When user opens Sport link
Then Sport page is shown

Scenario: User searches for a "Polsat"

Given user is on Home page
When user search
Then results page is shown

Scenario: User click on "Discovery Channel"

Given user is on Home page
When Channels page is shown
Then Discovery Channel page is shown

Scenario: User click on poop

Given user is on Home page
When user login on page
Then error is shown