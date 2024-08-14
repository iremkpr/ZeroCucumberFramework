 @employeeSearch
Feature: Employee Search Feature
 
 	Background:
			Given Login to HRM site
 	
  @smoke
  Scenario: Employee search with valid ID
    When Click PIM button
    And Click Employee list button
    When Send valid id to the search box
    And click search button
		Then Validate with specific id employee exist on given list   
		
	

	@smoke @name
  Scenario: Employee search with valid Name
    When Click PIM button
    And Click Employee list button
    When Send valid name to the search box
    And click search button
		Then Validate with specific name employee exist on given list
		
	