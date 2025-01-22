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
Feature: Data Integration Management
  To manage Data Integrations, users should be able to view, create, and validate entries through the UI.

    
  Scenario: Verify Data Integration page title
    Given select workspace and filter 
    When  I navigate to the Data Integration page
    Then I check the DI page title
    And the title should contain Data Integration

  Scenario: Verify the Data Integration grid is displayed
    Given I navigate to the Data Integration page
    When I check the DI grid display on the page
    Then the DI grid should be visible

  Scenario: Verify the grid contains entries
    Given I navigate to the Data Integration page
    When I check the size of the DI grid
    Then the DI grid should have entries

  Scenario: Create a new Data Integration entry
    Given I navigate to the Data Integration page
    And I click on the Create Data Integration button
    When I enter a valid name "Automation-DI-3"
    And I enter a valid description "Automation DI Creation"
    And I click the Create button
    Then the data integration entry "Automation-DI-3" should be displayed in the grid

  Scenario: Error when creating a Data Integration without a name
    Given I navigate to the Data Integration page
    And I click on the Create Data Integration button
    When I leave the DI Name field blank and validate error message
    

  Scenario: Cancel Data Integration creation
    Given I navigate to the Data Integration page
    And I click on the Create Data Integration button
    When I click the Cancel button
    Then I should be redirected back to the Data Integration list page
