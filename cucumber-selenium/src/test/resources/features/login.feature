@run
Feature: Validating login functionality

  Scenario: Login into account with valid credentials
    Given User navigates to home page on the website
    And User clicks on the login button on homepage
    And User enters a valid username
    And User enters a valid password
    When User clicks on the login button
    Then User should be taken the successful login page
#
  #@tag2
  #Scenario: Log out account
    #Given User navigates to stackoverflow website
    #And User clicks on the login button on homepage
    #And User enters a valid username
    #And User enters a valid password
    #When User clicks on the login button
    #Given User clicks on the menu button on the right corner
    #And User clicks on the log out button
    #And User clicks on the Log out on all devices button
    #When User clicks on the Log out button
    #Then User should be taken the home page
