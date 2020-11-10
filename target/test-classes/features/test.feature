@test
Feature: Testing Flooid Search and Validation
Description: With this feature we want to Confirm the URL and logo are Flooid

Background:
    Given I navigate to Google home page
    When I search for "Flooid"

    Scenario: Testing that the user navigates to the Flooid page
       Then I navigate to "https://www.flooid.com/"
       And the URL is flooid.com

    Scenario: Testing that the Flooid Logo is displayed
       Then I navigate to "https://www.flooid.com/"
       And I confirm the Flooid Logo is displayed
