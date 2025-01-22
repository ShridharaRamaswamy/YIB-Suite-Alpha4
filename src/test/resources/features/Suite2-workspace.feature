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
Feature: Workspace Page Validations with Data Tables
	
   #Scenario 1: Workspace Creation with Valid Data
  Scenario: Workspace Creation with Valid Data
    Given I am on the Create Workspace page
    When I create a workspace with the following details
      | Name            | Description            |
      | Workspace10     | Test description 1     |
      | Workspace11     | Test description 2     |
    Then I should see the workspaces "Workspace1" and "Workspace2" in the list
   
  #Scenario 2: Validate the "Add Workspace" Button Tooltip
  Scenario: Add Workspace Button Tooltip with Data Table
    Given I am on the Workspace page
    When I hover over the "Add Workspace" button
    Then I should see the tooltip "Add Workspace"

   #Scenario 3: Workspace Grid Visibility and Size
  Scenario: Workspace Grid Visibility and Size Validation
    Given I am on the Workspace page
    Then I should see the Workspace grid
    And the Workspace grid should have more than 0 entries
    
   #Scenario 4: Workspace Name Field Error Validations with Data Table
  Scenario: Workspace Name Field Error Validations with Data Table
    Given I am on the Create Workspace page
    When I create a workspace with invalid data


   #Scenario 5: Workspace Grid and Size Validation with Data Table
  Scenario: Validate Grid Visibility and Size
    Given I am on the Workspace page
    Then I should see the Workspace grid
    And the grid should have the following workspaces
      | Workspace Name   | Description          |
      | Workspace10      | Test Description 1   |
      | Workspace11      | Test Description 2   |

   #Scenario 6: Side Navigation Visibility Checks
  Scenario: Validate Visibility of Side Navigation Items
    Given I am on the Create Workspace page
    Then I should see the all side navigation items

   #Scenario 7: Workspace Breadcrumb Visibility
  Scenario: Workspace Breadcrumb Visibility Check
    Given I am on the Create Workspace page
    Then I should see the workspace breadcrumb displayed

   #Scenario 8: Workspace Creation Page Title and Subtitle Validation
  Scenario: Validate Workspace Creation Page Title and Subtitle
    Given I am on the Create Workspace page
    Then the page title should contain "Workspace"
    And the subtitle should contain "Create Workspace"

   #Scenario 9: Add Workspace Button Tooltip with Data Table
  Scenario: Add Workspace Button Tooltip with Data Table
    Given I am on the Workspace page
    When I hover over the "Add Workspace" button
    Then I should see the tooltip "Add Workspace"
