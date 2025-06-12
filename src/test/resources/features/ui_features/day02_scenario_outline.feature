@scenario_outline
Feature: Google_Search

  Background:
    Given user navigates to "https://www.google.com/"

  Scenario Outline: google_search
    And user search for "<search_items>" on google
    And user verifies that page title contains "<search_items>"
    Then user closes the application
    Examples: test_data
      | search_items |
      | iPhone       |
      | teapot       |
      | flower       |
      | tesla        |
      | toyota       |
