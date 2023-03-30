@Login
Feature: Login tests
  As a user I want to verify Login scenarios

  Background: Home page of SauceDemo
    Given Home page is displayed

@ValidLogin @Smoke @Regression @Positive
  Scenario Outline: Verify valid users can sign in
    When The user provides the username as "<username>" and password as "<password>"
    And The user clicks the 'Login' button
    Then The user should login successfully and is brought to the inventory page
    Examples:
      |username       |password     |
      |standard_user  |secret_sauce |
      |problem_user   |secret_sauce |

  @LockedOutLogin @Smoke @Regression @Positive
  Scenario Outline: Verify locked out user gets locked out message
    And The user provides the username as "<username>" and password as "<password>"
    And The user clicks the 'Login' button
    Then The user should be shown a locked out message
    Examples:
      |username       |password     |
      |locked_out_user|secret_sauce |

  @InValidLogin @Smoke @Regression @Negative
  Scenario Outline: Verify invalid users cannot sign in
    And The user provides the username as "<username>" and password as "<password>"
    And The user clicks the 'Login' button
    Then The user should be shown an invalid username/password message
    Examples:
      |username       |password     |
      |fake_user      |bogus        |