#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Decision Support Page
  As a user,
  I want to interact with the Decision Support Page
  So that I can create, view, and manage decision support entries.

    
  Scenario: Verify the page title
  	Given select workspace and filter
    When  I check the page title
    Then  the title should contain Decision Support

  Scenario: Verify the grid is displayed
    When  I check the grid display on the page
    Then  the grid should be visible

  Scenario: Verify grid size is greater than zero
    When  I check the size of the grid
    Then  the grid should have entries

  Scenario: Add a new design run
    Given I check and click the Add Design Run tooltip
    When  I check and click the Add Design Run button
    Then  I should navigate to the Add Decision Support page

  Scenario: Validate error message for blank name field
    Given I should navigate to the Add Decision Support page
    When  I leave the Name field blank and validate error message
    

  Scenario: Validate error message for exceeding max name length
    Given I enter a name exceeding 120 characters and validate error message
    
   

  Scenario: Add a valid decision support entry
    Given I navigate to the Decision Support page 
    When  I check and click the Add Design Run button
    Then  I create a Design Specification with Name "Automation_DS_5" and Description "Automation Creation"
    And  the decision support entry "Automation_DS_5" should be displayed in the grid

  Scenario: Cancel adding a new decision support entry
    Given I navigate to the Decision Support page
    When  I check and click the Add Design Run button
    Then  I check and click the Cancel button
    And   I check the page title

