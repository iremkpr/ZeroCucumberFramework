@tag
Feature: Register feature in Demoqa WebSite 
   

  @demoqaRegisteration
  Scenario: Register Demoqa website with valid data
    Given Open the "https://demo.guru99.com/test/newtours/" url on chrome
    And Click the register button
    When Fill the informations for registration
    And Click submit button
    Then Validate User registered succesfully

 