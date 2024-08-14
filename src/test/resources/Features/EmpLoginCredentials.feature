Feature: Add new Employee
			@details
			Scenario: Add new employee with login credentials
					When login to the HRM
					And   Click pim button
					Then add new employee	with Login details
							|FirstName|		LastName	| id|  EmployeeName| Password|
    					|	 danielo	| master |9999|dandinidanielo|Neotech@123|
					And validate to employee added
							|AccountName|
							|danielo master|
							