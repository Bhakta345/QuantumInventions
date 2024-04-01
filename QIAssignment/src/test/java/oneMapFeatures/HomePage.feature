Feature: This feature file will test the elements in one map landing page
  I want to use this template for my feature file


  Scenario: Scenario to test all the buttons are present in landing Page
    Given User opens OneMap website
    Then User must see "Community" button
    Then User must see "School Query" button
    Then User must see "Medical" button
    Then User must see "Hawker Centres" button
    
    
  Scenario: Scenario search text box functionality
    Given User opens OneMap website
    When User enters "Bay Building" in search box
    Then User should be able to see related search results
