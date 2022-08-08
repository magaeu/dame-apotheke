Feature: Login
  In order to buy products on shop-apotheke
  As a user
  I want to log in

  Scenario: User log in with valid credential

    Given User is on login page
    When the user filled login field with valid credentials
    Then the main page is displayed
    And the username is displayed

  Scenario: User log in with invalid credentials

    Given User is on login page
    When the user filled login field with invalid credentials
    Then an error message is displayed

  Scenario: User log in without fill required credentials

    Given User is on login page
    When the user filled without required credentials
    Then an error message is displayed
