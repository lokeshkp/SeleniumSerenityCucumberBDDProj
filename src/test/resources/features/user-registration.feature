Feature: User Registration to the Pet Store Application

Scenario: As a shopper I need to register my self as new User to the Pet Store Application
	Given I navigate to Registration Page
	And I add a new user information
	And I add account information
	And I add profile information
	And I save my information
	When I login with my credentials
	Then I must be able to view the welcome	greeting with my name