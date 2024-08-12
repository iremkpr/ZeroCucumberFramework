@smoke
Feature: Google Search Feature

  Background: 
    Given Initialize driver as Chrome and Open Google

  @tag1
  Scenario: Google Search on Chrome Browser
    When Send text on Search Box
    And Click search button
    And Count line of listed results
    Then Verify result numbers
