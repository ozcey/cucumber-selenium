Feature: Validating login functionality

  @run
  Scenario: I want to login into account with valid credentials
    Given User navigates to home page on the website
    And User clicks on the login button on home page
    Then User should be taken the successful login page
    And User enters a valid username
    And User enters a valid password
    When User clicks on the login button
    Then User should be taken the successful customer page

  Scenario Outline: I wnat to login into account with invalid credentials
    Given User navigates to home page on the website
    And User clicks on the login button on home page
    Then User should be taken the successful login page
    And User enters an invalid username <username>
    And User enters an invalid password <password>
    When User clicks on the login button
    Then User gets an <error> message

    Examples: 
      | username      | password | error                     |
      | ""            |   123456 | Invalid or missing email! |
      | abc@gmail.com | ""       | Missing password!         |

  Scenario: I wnat to log out account successfully
    Given User navigates to home page on the website
    And User clicks on the login button on home page
    Then User should be taken the successful login page
    And User enters a valid username
    And User enters a valid password
    When User clicks on the login button
    Then User should be taken the successful customer page
    And User clicks on the dropdwon menu on navbar
    When User clicks on the logout button
    Then User should be taken the successful login page
