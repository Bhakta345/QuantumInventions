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

Feature: This feature will check the user rating functionality in One Map website

  Scenario Outline: Title of your scenario outline
    Given User opens OneMap website
    When Opens rating dialog box
    Then User shoud be able to input "<rating>"
    Then User shoud be able to input "<text>"
    Then User shoud be able to input "<email>"

    Examples: 
      | rating  | text 			   | email   |
      | two 		| test reply1  | a@b.com |
      | three 	| test reply2  | c@d.com |
