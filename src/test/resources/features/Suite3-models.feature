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

Feature: Models Page - Digital Twin Creation and Validation

  Scenario: Verify if the Models Page title contains expected text
    Given select workspace
    Then I am on the Models page "Digital Twin"
    Then the DT page title should contain "Digital Twin"

  Scenario: Verify that the Digital Twin list grid is displayed
    Given I am on the Models page "Digital Twin"
    Then the Digital Twin list grid should be displayed

  Scenario: Verify that the Digital Twin list grid contains items
    Given I am on the Models page "Digital Twin"
    Then the Digital Twin list grid size should be greater than 0

  Scenario: Verify if the Add Digital Twin button is displayed
    Given I am on the Models page "Digital Twin"
    Then the Add Digital Twin button should be displayed

  Scenario: Verify the tooltip text of the Add Digital Twin button
    Given I am on the Models page "Digital Twin"
    Then the Add Digital Twin button should have the tooltip "Add digital Twin"

  Scenario: Add a new Digital Twin with a valid name and description
    Given I click on the Add Digital Twin button
    When I enter the name "Automation Digital Twin-6"
    And I enter the description "This is a new digital twin."
    And I click on the Create button
    Then the Digital Twin should be created with the name "Automation Digital Twin-6"

  Scenario: Verify error message for blank name field when adding a Digital Twin
    Given I click on the Add Digital Twin button
    When I should see the error message "Name is required"
    
  Scenario: Verify error message for name exceeding max length when adding a Digital Twin
    Given I click on the Add Digital Twin button
    When I should see the error message "Max 120 characters allowed."

  Scenario: Verify if the Add Digital Twin page breadcrumb is displayed
    Given I am on the Add Digital Twin page
    Then I should see the Add Digital Twin breadcrumb

  Scenario: Cancel the creation of a new Digital Twin
    Given I am on the Add Digital Twin page
    When I click on the Cancel button
    Then I am on the Models page "Digital Twin"

  Scenario: Navigate from the Models page to the Digital Twin landing page
    Given Navigate to models page
    When I click on the Digital Twin button
    Then I should be on the Digital Twin landing page

  Scenario: Navigate from the Models page to the MNM page
    Given Navigate to models page
    When I click on the MNM button
    Then I should be on the MNM page