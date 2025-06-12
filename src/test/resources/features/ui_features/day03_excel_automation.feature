@excel
Feature: Excel_Automation
#  Option 1: Create one giant test method by writing one single test step
#  Scenario: user_creation
#    Given user navigates to "https://editor.datatables.net/" and user enters "name of the sheet" from "excel file name" and verifies new user is created and user closes the application



#  Option 2: Create small but multiple test methods by writing each small test step separately
  Scenario: user_creation
    Given user navigates to "https://editor.datatables.net/"
    And user enters "user_data" from "data_sheet.xlsx" and verifies new user is created
    And user closes the application



#  name of the sheet : user_data
#  name of the excel file: data_sheet.xlsx