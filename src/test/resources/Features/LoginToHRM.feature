@login
Feature: Login Functionality

  
  Scenario: Login with Valid Data
    Given I enter a valid userName
    And I enter a valid password
    Then I click to the Login button
     Then I validate that I am logged in

  @smoke2
  Scenario: Login with Invalid Data
    Given I enter a valid userName
    And I enter invalid password
    Then I click to the Login button
    Then I verified the warning

  @dataExamps
  Scenario Outline: Login to HRM with different accounts
    When Fill username box with valid "<userName>" data
    And Fill password box with valid "<password>" data
    And I click to the Login button
    Then Validate account name matched with expected "<accountName>"

    Examples: 
      | userName    | password               | accountName      |
      | Admin       | Neotech@123            | Jacqueline White |
      | adacayimuk  | adacayimukadacayimuk   | ada adacayi      |
      | ihlamurcayi | ihlamurcayiihlamurcayi | ihlamur cayi     |

  @dataTabs
  Scenario Outline: Login with different users
    When Fill username box with valid "<userName>" data
    And Fill password box with valid "<password>" data
    And I click to the Login button
    And click add employee button and Send valid username, lastname, id and location
      | username | lastname | id    | location                    |
      | yelix    | yunio    | 9775 | Canadian Development Center |
      | yliobans | yater    |  8977 | New York Sales Office       |
    Then Search new added accounts and validate
      | accountName    |
      | yelix yunio    |
      | yliobans yater |

    Examples: 
      | userName | password    |
      | Admin    | Neotech@123 |
