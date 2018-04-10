Feature: Login Action 

Background: User is on Login Page
	Given User is on Home Page
	When User Navigate to LogIn Page

Scenario: Successful Login with Valid Credentials 
	And User enters UserName and Password 
	Then Message displayed Login Successfully 
	
Scenario: User enters wrong credentials
	And User enters wrong credentials
	Then Error message is displayed
	
Scenario: Successful LogOut 
	And User LogOut from the Application 
	Then Message displayed LogOut Successfully