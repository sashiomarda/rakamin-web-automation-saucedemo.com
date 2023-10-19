Feature: Login Page saucedemo app

  @Regression @Positive
  Scenario: Success Login
    Given login page saucedemo
    When input username
    And input password
    And click login button
    Then user in dashboard page

  @Regression @Negative
  Scenario: Failed login
    Given login page saucedemo
    When input username
    And input invalid password
    And click login button
    Then user get error message