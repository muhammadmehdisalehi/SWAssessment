@Cart&Checkout @Filter @Product
Feature: Filter, Cart & Checkout tests

  Background: Home page of SauceDemo
    Given Home page is displayed
    When The user provides the username as "standard_user" and password as "secret_sauce"
    And The user clicks the 'Login' button

  @Filters @Smoke @Regression @Positive
  Scenario Outline: Verify valid users can Filter products
    Then The user should login successfully and is brought to the inventory page
    Then The user clicks the 'Filter' button
    And The user selects "<Filter Options>" option
    And verify selected "<Filter Options>" is applied

    Examples:
      | Filter Options |
      | low to high |
      | high to low |
      | A to Z      |
      | Z to A      |

  @AddToCart @Smoke @Regression @Positive @SingleItem
  Scenario: Place a single item in the shopping cart
    And The user adds "1" item by clicking Add To Cart
    And The user clicks on the shopping cart
    Then There should be "1" items in the shopping cart


  @AddToCart @Smoke @Regression @Positive @MultipleItem
  Scenario: Place multiple items in the shopping cart
    And The user adds "4" item by clicking Add To Cart
    And The user clicks on the shopping cart
    Then There should be "4" items in the shopping cart

  @UpdateCart @Smoke @Regression @Positive
  Scenario: Remove items in the shopping cart
    And The user adds "4" item by clicking Add To Cart
    And The user clicks on the shopping cart
    Then There should be "4" items in the shopping cart
    And the user removes "1" item from cart
    Then There should be "3" items in the shopping cart


  @checkout @Smoke @Regression @Positive
  Scenario: Validate Order Totals and checkout
    And The user adds "3" item by clicking Add To Cart
    And The user clicks on the shopping cart
    Then There should be "3" items in the shopping cart
    And The user clicks 'Checkout'
    And The user provides the first name as "Mehdi" and last name as "Salehi" and zip code as "74600"
    And The user clicks 'Continue'
    Then verify that sum of individual items is equal to the items total
    And The user clicks 'Finish'
    Then Verify checkout is complete



