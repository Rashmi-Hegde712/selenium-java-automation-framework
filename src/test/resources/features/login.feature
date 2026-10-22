@ui @login
Feature: Login on the Ultimate QA automation practice site

  @smoke @regression
  Scenario: Registered user signs in successfully
    Given the user is on the Ultimate QA automation page
    When the user opens the login automation page
    Then the welcome message "Welcome!" is displayed
    When the user signs in with the configured credentials
    Then the "Products" page is displayed
