package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.DataTablesPage;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.WaitUtils.waitFor;

public class DataTablesStepDefs {

    DataTablesPage dataTablesPage = new DataTablesPage();
    Map<String, String > userList;

    @Given("User clicks on New button")
    public void user_clicks_on_new_button() {
        dataTablesPage.newButton.click();
        waitFor(2);
    }
    @Given("User enters user details:")
    public void user_enters_user_details(DataTable dataTable) {
        userList = dataTable.asMap();

        String firstNameValue = userList.get("first_name");
        System.out.println("firstName = " + firstNameValue); // Angelina
        dataTablesPage.firstNameInput.sendKeys(firstNameValue);
        waitFor(1);

        String lastNameValue = userList.get("last_name");
        dataTablesPage.lastNameInput.sendKeys(lastNameValue);
        waitFor(1);

        String positionValue = userList.get("position");
        dataTablesPage.positionInput.sendKeys(positionValue);
        waitFor(1);

        String officeValue = userList.get("office");
        dataTablesPage.officeInput.sendKeys(officeValue);
        waitFor(1);


        String extensionValue = userList.get("extension");
        dataTablesPage.extensionInput.sendKeys(extensionValue);
        waitFor(1);

        String startDateValue = userList.get("start_date");
        dataTablesPage.startDateInput.sendKeys(startDateValue);
        waitFor(1);

        String salaryValue = userList.get("salary");
        dataTablesPage.salaryInput.sendKeys(salaryValue);
        waitFor(1);


    }
    @Given("User clicks on Create button")
    public void user_clicks_on_create_button() {
        dataTablesPage.createButton.click();
        waitFor(1);
    }
    @Given("User searches for {string}")
    public void user_searches_for(String firstName) {
        dataTablesPage.searchButton.sendKeys(firstName);
        waitFor(1);

    }
    @Then("Verify that name field contains the first name {string}")
    public void verify_that_name_field_contains_the_first_name(String firstName) {
        String actualText = dataTablesPage.nameField.getText();
        System.out.println("Verifying name field text: " + actualText);
        assertTrue(actualText.contains(firstName));
    }



}
