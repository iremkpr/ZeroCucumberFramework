@tag
Feature: Login feature

	@smokeAda
  Scenario Outline: Login latest added account
    Given Open HRM WebSite
    And Send valid "<userName>"
    And Send valid "<password>"
    And click login button
    Then Validate "<accountName>" is matched with expected data

    Examples: |userName|userName|accountName|
				      | adacayimuk  | adacayimukadacayimuk   | ada adacayi  |
				      | ihlamurcayi | ihlamurcayiihlamurcayi | ihlamur cayi |
