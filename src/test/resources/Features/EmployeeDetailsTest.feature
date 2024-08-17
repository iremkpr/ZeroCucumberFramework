Feature: Employee Details Page

  @detailsModify
  Scenario Outline: Employee Details Page Modification
    Given login to the HRM
    And Click pim button
    And Find user with "<userName>"
    Then Modify the expected  "<DateOfBirth>", "<MaritalStatus>", "<Gender>", "<Nationality>", "<LicenceExpireDate>" , "<SmokerCheck>"

    Examples: 
      | userName       | DateOfBirth | MaritalStatus | Gender | Nationality | LicenceExpireDate | SmokerCheck |
      | danielo master | 11.3.1997   | Married       | Female | Turkish     | 12.30.2027        | True        |
