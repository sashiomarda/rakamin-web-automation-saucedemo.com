Feature: Add to cart button

  @Regression @Positive
  Scenario: Success add to cart
    Given products page saucedemo
    When click add to cart button for Sauce Labs Backpack
    Then shopping cart badge becomes one
    And click cart button
    Then user in cart page