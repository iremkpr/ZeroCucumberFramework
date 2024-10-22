@tag
Feature: HRM website Login feature

		@tryLogin
		Scenario: Login HRM site with valid data
			Given Open url on browser
			And Fill the username
			Then Fill the password
			When Click the login button
			And Validate user logged in the system