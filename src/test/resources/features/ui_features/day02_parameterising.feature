@param @smoke
Feature: parameterising

  @tc01
  Scenario: TC01_iphone_search
    Given user navigates to "https://www.google.com/"
    And user search for "iPhone" on google
    Then user verifies that page title contains "iPhone"
    And user closes the application

  @tc02
  Scenario: TC02_teapot_search
    Given user navigates to "https://www.google.com/"
    And user search for "teapot" on google
    Then user verifies that page title contains "teapotss"
    And user closes the application

  @tc03
  Scenario: TC03_flower_search
    Given user navigates to "https://www.google.com/"
    And user search for "flower" on google
    Then user verifies that page title contains "flowersss"
    And user closes the application

  @tc04
  Scenario: TC04_tesla_search
    Given user navigates to "https://www.google.com/"
    And user search for "tesla" on google
    Then user verifies that page title contains "tesla"
    And user closes the application