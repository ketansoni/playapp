Meta:

Narrative:
As Fulfillment admin
I want to update the status of an order
So that customer is able to view it

Scenario: search google
Given I view an item order "1" status
When I update the status
Then I should see successful update message