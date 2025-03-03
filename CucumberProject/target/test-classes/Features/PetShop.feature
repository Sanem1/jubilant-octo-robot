#Author: Sanem Tel
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
@tag
Feature: Pet Shop Category Test
  I want to use this template for my feature file

@tag1
Scenario: User selects the Pet Shop category and sorts products by lowest price
Given Given The user navigates to homepage on "<browser>"
When The user selects the Pet Shop category from the Kategoriler section
Then The user verifies that the page is displayed
When The user sorts the products by lowest price first
Then The user verifies that the products are sorted by lowest price first

 Examples:
      | browser  |
      | chrome  |
      | firefox  |
