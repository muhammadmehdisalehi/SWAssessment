@Logout
Feature: Logout tests
  As a user I want to verify Logout scenarios

  Background: Home page of SauceDemo
    Given Home page is displayed

  @Logout @Smoke @Regression @Positive
  Scenario Outline: Verify valid users can logout after signing in
    When The user provides the username as "<username>" and password as "<password>"
    And The user clicks the 'Login' button
    Then The user should login successfully and is brought to the inventory page
    Then The user clicks the 'Menu' button
    And The user clicks the 'Logout' button
    Examples:
      |username       |password     |
      |standard_user  |secret_sauce |
      |problem_user   |secret_sauce |