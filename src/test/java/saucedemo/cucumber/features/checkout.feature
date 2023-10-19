Feature: Checkout Page

  @Regression @Positive
  Scenario: Success Checkout
    Given chckout page saucedemo
    When input first name
    And input last name
    And input zip postal code
    And click continue button
    Then user in checkout overview page

  @Regression @Negative
  Scenario: Failed checkout
    Given chckout page saucedemo
    When input first name
    And input last name
    And click continue button
    Then user get checkout error message