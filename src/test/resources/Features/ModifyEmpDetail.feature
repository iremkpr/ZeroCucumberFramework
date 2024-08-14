@tag
Feature: Modify employee details feature

	@modify
	Scenario: Admin should be able to modify employee details
					When login to the HRM
  			  And Click PIM button
  			  And Click Employee List button
  			  Then Click one Random user who has personal details
  			  And Update name
					Then Validate changes on personal detail page