@login
Feature: Login Functionality

	 @smoke
  Scenario: Login with Valid Data
     Given I enter a valid userName
    And I enter a valid password
    Then I click to the Login button
    Then I validate that I am logged in
	 
	 @smoke
  Scenario: Login with Invalid Data
     Given I enter a valid userName
    And I enter invalid password
    Then I click to the Login button
    Then I verified the warning