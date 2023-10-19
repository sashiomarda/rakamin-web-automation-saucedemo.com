Feature: Go to checkout button

  @Regression @Positive
  Scenario: Success go to checkout page
    Given cart page saucedemo
    When click checkout button
    Then user in checkout page