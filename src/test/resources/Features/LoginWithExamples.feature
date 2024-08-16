@tag
Feature: Login feature

  @smokeAda
  Scenario Outline: Login latest added account
    Given Open HRM WebSite
    And Send valide username "<userName>"
    And Send valide password "<password>"
    And click login button
    Then Validate "<accountName>" is matched with expected data

    Examples: 
      | userName    | password               | accountName  |
      | adacayimuk  | adacayimukadacayimuk   | ada adacayi  |
      | ihlamurcayi | ihlamurcayiihlamurcayi | ihlamur cayi |
