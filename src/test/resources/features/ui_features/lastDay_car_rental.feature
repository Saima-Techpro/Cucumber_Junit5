@car_rental
Feature: Car_Rentals

  Background:
    Given user navigates to "https://www.speedyli.com/"

    @car_rental01
  Scenario: TC01_car_rental_login_positive_test
    And user clicks on Login option
    And enters valid email address in email input field
    And enters valid password in password input field
    And user clicks on Login button
    Then verifies login is successful
    And user clicks on Logout button
    Then verifies logout is successful
    And user closes the application

  @car_rental02
  Scenario: TC02_car_rental_login_negative_test
    And user clicks on Login option
    And enters invalid email address in email input field
    And enters valid password in password input field
    And user clicks on Login button
    Then verifies login is successful
    And user clicks on Logout button
    Then verifies logout is successful
    And user closes the application

  @car_rental03
  Scenario: TC03_car_rental_login_negative_test
    And user clicks on Login option
    And enters valid email address in email input field
    And enters invalid password in password input field
    And user clicks on Login button
    Then verifies login is successful
    And user clicks on Logout button
    Then verifies logout is successful
    And user closes the application

  @car_rental014
  Scenario: TC04_car_rental_login_negative_test
    And user clicks on Login option
    And enters invalid email address in email input field
    And enters invalid password in password input field
    And user clicks on Login button
    Then verifies login is successful
    And user clicks on Logout button
    Then verifies logout is successful
    And user closes the application

