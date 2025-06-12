package stepdefinitions;

import io.cucumber.java.en.*;
import pages.DataTablesPage;
import utilities.Driver;
import utilities.ExcelUtils;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.WaitUtils.waitFor;

public class ExcelStepDefs {

    // Create page object
    DataTablesPage dataTablesPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> dataList;  // create a List of Map to store data coming from the excel sheet

    @Given("user enters {string} from {string} and verifies new user is created")
    public void user_enters_from_and_verifies_new_user_is_created(String sheetName, String excelFileName) {
        //        String pathOfFile = "src/test/resources/data_sheet.xlsx";

        String pathOfFile = "src/test/resources/"+excelFileName; // dynamic
        excelUtils = new ExcelUtils(pathOfFile, sheetName);
        // initiated excelUtils object with the path of the excel file and the name of the sheet that we want to get data from


        // Initiate the List of Map here
        dataList = excelUtils.getDataList(); // getDataList() takes the data from excel sheet, and transforms (returns) it as Java object (List of Map)

        // Now that the data coming from excelUtils is transferred into Java object => dataList, we can send it to the url

        for (Map<String, String> eachData : dataList){

            dataTablesPage = new DataTablesPage();

            dataTablesPage.newButton.click();
            waitFor(1);
            dataTablesPage.firstNameInput.sendKeys(eachData.get("first_name"));
            waitFor(1);
            dataTablesPage.lastNameInput.sendKeys(eachData.get("last_name"));
            waitFor(1);
            dataTablesPage.positionInput.sendKeys(eachData.get("position"));
            waitFor(1);
            dataTablesPage.officeInput.sendKeys(eachData.get("office"));
            waitFor(1);
            dataTablesPage.extensionInput.sendKeys(eachData.get("extension"));
            waitFor(1);
            dataTablesPage.startDateInput.sendKeys(eachData.get("start_date"));
            waitFor(1);
            dataTablesPage.salaryInput.sendKeys(eachData.get("salary"));
            waitFor(1);
            dataTablesPage.createButton.click();
            waitFor(1);
            dataTablesPage.searchButton.sendKeys(eachData.get("first_name"));

            // user verifies new user is created
            waitFor(1);
            assertTrue(dataTablesPage.nameField.getText().contains(eachData.get("first_name")));

            waitFor(1);
            Driver.getDriver().navigate().refresh();

        }

    }


}
