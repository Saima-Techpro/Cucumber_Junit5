package stepdefinitions;

import io.cucumber.java.en.*;
import pages.DataTablesPage;
import static utilities.WaitUtils.waitFor;

public class Scenario_OutlineStepDefs {

    DataTablesPage dataTablesPage = new DataTablesPage();

    @Given("user clicks on New button")
    public void user_clicks_on_new_button() {
        dataTablesPage.newButton.click();
        waitFor(2);
    }
    @Given("user enters first name as {string}")
    public void user_enters_first_name_as(String firstName) {
        dataTablesPage.firstNameInput.sendKeys(firstName);
        waitFor(2);
    }
    @Given("user enters last name as {string}")
    public void user_enters_last_name_as(String lastName) {
        dataTablesPage.lastNameInput.sendKeys(lastName);
    }
    @Given("user enters position as {string}")
    public void user_enters_position_as(String position) {
        dataTablesPage.positionInput.sendKeys(position);
    }
    @Given("user enters office as {string}")
    public void user_enters_office_as(String office) {
        dataTablesPage.officeInput.sendKeys(office);
    }
    @Given("user enters extension as {string}")
    public void user_enters_extension_as(String extension) {
        dataTablesPage.extensionInput.sendKeys(extension);
    }
    @Given("user enters start date as {string}")
    public void user_enters_start_date_as(String startDate) {
        dataTablesPage.startDateInput.sendKeys(startDate);
    }
    @Given("user enters salary as {string}")
    public void user_enters_salary_as(String salary) {
        dataTablesPage.salaryInput.sendKeys(salary);
    }
    @Given("user clicks on Create button")
    public void user_clicks_on_create_button() {
        dataTablesPage.createButton.click();
    }
    @Given("user searches for {string}")
    public void user_searches_for(String firstName) {
        dataTablesPage.searchButton.sendKeys(firstName);


    }
    @Then("verify that name field contains the first name {string}")
    public void verify_that_name_field_contains_the_first_name(String firstName) {
        waitFor(2); // Wait for the search results to load
        String actualName = dataTablesPage.nameField.getText();
        if (!actualName.contains(firstName)) {
            throw new AssertionError("Expected name to contain: " + firstName + ", but was: " + actualName);
        }


    }


}
