Feature: Validate the Facebook with Proper username and Password

  Scenario Outline: Validate the Facebook with one set of Username and password
    Given Open the Facebook Application
    When Enter the  "<Username>" and Password
      | abc@123 |
    And Click the Login button
    Then User validates the Facebook Successfully Login

    Examples: 
      | Username  |
      | Ram@123   |
      | Kumar@123 |
      