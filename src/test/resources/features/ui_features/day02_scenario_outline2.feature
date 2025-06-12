@scenario_outline2
Feature: data_tables_feature

  Scenario Outline: new_user_creation
    Given user navigates to "https://editor.datatables.net/"
    And user clicks on New button
    And user enters first name as "<first_name>"
    And user enters last name as "<last_name>"
    And user enters position as "<position>"
    And user enters office as "<office>"
    And user enters extension as "<extension>"
    And user enters start date as "<start_date>"
    And user enters salary as "<salary>"
    And user clicks on Create button
    And user searches for "<first_name>"
    Then verify that name field contains the first name "<first_name>"
    Examples:
      | first_name | last_name | position | office | extension | start_date | salary |
      | Melik      | White     | musician | LA     | 200       | 2024-02-01 | 2000   |
      |            | Smith     | actor    | Texas  | 100       |            | 2000   |
      | Tomas      | Cruise    | actor    | Miami  | 300       | 2020-01-02 | 3000   |
      | Tommy      | Shelby    | actor    | Texas  | 400       | 2020-01-01 | 2000   |
      | Ronaldo    | Brezil    | player   | Texas  | 500       | 2020-01-01 | 2000   |
      | Lionel     | Messi     | player   | Texas  | 500       | 2020-01-01 | 2000   |
      | Zidane     | Zidane    | actor    | Texas  | 201       | 2020-01-01 | 2000   |
      | Ali        | Hardy     | actor    | Texas  | 201       |            | 2000   |
      | Angelina   | Jolie     | actor    | Texas  | 401       | 2020-01-01 | 2000   |
      | Hasan      | Kas       | actor    | Texas  | 302       | 2020-01-01 | 2000   |
