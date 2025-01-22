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
Feature: Design Specification Page
  As a user,
  I want to interact with the Design Specification Page
  So that I can create, view, and manage design specifications effectively.

    
  Scenario: Verify the page title
  	Given select workspace and filter
  	When I navigate to the Design Specification page
    Then I check the design page title
    And the title should contain Design Specification

  Scenario: Verify the grid is displayed
    When I check the design grid display on the page
    Then the design grid should be visible

  Scenario: Verify grid size is greater than zero
    When I check the size of the design grid
    Then the design grid should have entries

  Scenario: Add a new design specification
    Given I see the Add Design Specification tooltip
    When I click on the Add Design Specification button
    Then I should navigate to the Add Design Specification page

  Scenario: Validate error message for blank name field
    Given I navigate to the Design Specification page
    When  I click on the Add Design Specification button
    Then  I should navigate to the Add Design Specification page
    And   I leave the Design Name field blank and validate error message
  

  Scenario: Validate error message for exceeding max name length
    Given I enter a design description exceeding 120 characters and validate error message


  Scenario: Add a valid design specification entry
    Given I navigate to the Design Specification page
    When  I click on the Add Design Specification button
    Then  I should navigate to the Add Design Specification page 
    And   I enter a valid design name "Automation-Design-Spec-6"
    And   I enter a valid design description "Sample description for the design specification."
    And   Click on design creation button
    And   I navigate to the Design Specification page
    Then  the design specification entry "Automation-Design-Spec-6" should be displayed in the grid
    

  Scenario: Cancel adding a new design specification entry
    Given I navigate to the Design Specification page
    When I click on the Add Design Specification button
    Then I should navigate to the Add Design Specification page
    And  Click on cancel create design 
    Then I should be redirected back to the Design Specification list page
