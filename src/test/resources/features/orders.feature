Feature: Purchase pets from store

Background: User must be logged in
	Given I login to the application with valid test and test
	
Scenario Outline: As a user I must able to serach pets from the store and purchase them by entering details
	When I search for a <petType> it must show up in the search results
	And I view details about the pet <pet> and add it to cart
	And I proceed to checkout
	And I enter my payment details <cardType>, <cardNumber>, <expiryDate>,<firstName>,<lastName>,<addr1>,<addr2>,<city>,<state>,<zip>,<country>
	And I click on Continue
	When I Submit the order, the store must provide me a confirmation message on the place order
	
	Examples:
	|pet					|petType|cardType	|cardNumber			|expiryDate	|firstName	|lastName	|addr1	|addr2	|city	|state	|zip	|country|
	|Male Adult Bulldog		|Bulldog|Visa		|9999999939999999	|04/26		|Lokesh		|KP			|33		|Wdrive	|Mobile	|AP		|2556	|India	|
	|Female Puppy Bulldog	|Bulldog|Visa		|9999999939999999	|04/26		|Lokesh		|KP			|33		|Wdrive	|Mobile	|KA		|6008	|India	|
	

Scenario Outline: As a user, I want to view the Pet Types
	
	When I search for a <petType> it must show up in the search results
	
	Examples:
	|petType|
	|Bulldog|