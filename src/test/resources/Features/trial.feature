@trial
Feature: Add Employee Feature

  @trial1
  Scenario: Add employee with details and Login new employee Account
    When login to the HRM
    And Click pim button
    Then Add new employee from dataTable
      | firstName | lastName | id      | location                    | userName       | password      |
      | aden04      | adenoglu | 9999999 | Canadian Development Center | bayilaz4am11  | adenoglu01A   |
      | Bihter104    | yoreoglu |  999990 | New York Sales Office       | police121 | ziyagilYalisi |

  Scenario Outline: login to the HRM with new added user data
    Then login to the HRM with valid "<userName>" and "<password>"

    Examples: |	userName	 	 |	password		|
				      | 12premuniuon   | askimemnu01   |
				      | 12uniqvanessa   | adenoglu01A   |
				 