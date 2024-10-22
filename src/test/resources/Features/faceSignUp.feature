@face
Feature: Title of your feature
  I want to use this template for my feature file

  @signUp
  Scenario: Signup the Facebook with valid credentials
    Given Open "https://www.facebook.com/" website
    And 	Send valid userName "irem.koprek.7" and password as "irmikella01*"
    When Click the Login button
    And Validate that user logged in succesfully
 