@dataTables @smoke
Feature: data_tables_feature

@failed
  Scenario: Create and verify a new entry in DataTables
    Given user navigates to "https://editor.datatables.net/"
    And User clicks on New button
    And User enters user details:
      | first_name | Angelina   |
      | last_name  | Jolie      |
      | position   | actor      |
      | office     | Texas      |
      | extension  | 401        |
      | start_date | 2020-01-01 |
      | salary     | 2000       |
    And User clicks on Create button
    And User searches for "Angelina"
    Then Verify that name field contains the first name "Angelina"


