Feature: Add employee with datatable
  
  @dataTable
  Scenario: Add employee
    When login to the HRM
    And Click pim button
    Then Add new employee
    		|FirstName|MiddleName|LastName|
    		|	calzedonia	|		elly | donna |
    		|	zara		|		mang |  zamang  |	
    Then validate employee is added