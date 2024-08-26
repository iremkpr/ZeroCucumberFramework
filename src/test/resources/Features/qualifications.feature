@qualifications
Feature: Qualifications feature
  Admin should be able to add new qualifications

  Background: 
    Given Login with valid Admin data
    And Click to the Admin button
    And Click to the Qualification button

  @skills
  Scenario Outline: Admin should be able to add Skill Qualification
    Given Click to the specific qualification button "<qualification>"
    And Click to the add icon
    Then Fill the valid "<name>", "<Description>"
    And Click the save button
    Then Validate is the "<name>" added

    Examples: 
      | qualification | name                   | Description                |
      | Skills        | 3. Skill Qualification | The 3. Skill Qualification |

  @education
  Scenario Outline: Admin should be able to add Skill Qualification
    Given Click to the specific qualification button "<qualification>"
    And Click to the add icon
    Then Fill the valid "<name>"
    And Click the educationsave button
    Then Validate is the "<name>" added

    Examples: 
      | qualification | name                           |
      | Education     | Second Education Qualification |
