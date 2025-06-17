package stepdefinitions;

import io.cucumber.java.en.*;
import pages.CarRentalDashboardPage;
import pages.CarRentalHomePage;
import pages.CarRentalLoginPage;
import utilities.ConfigReader;
import utilities.ExtentReportUtils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.WaitUtils.waitFor;

public class CarRentalStepDefs {

    CarRentalHomePage carRentalHomePage = new CarRentalHomePage();
    CarRentalLoginPage carRentalLoginPage = new CarRentalLoginPage();
    CarRentalDashboardPage carRentalDashboardPage = new CarRentalDashboardPage();

    @Given("user clicks on Login option")
    public void user_clicks_on_login_option() {
        carRentalHomePage.loginOption.click();
    }
    @Given("enters valid email address in email input field")
    public void enters_valid_email_address_in_email_input_field() {
        carRentalLoginPage.emailInputField.sendKeys(ConfigReader.getProperty("carRentalEmail"));
        ExtentReportUtils.info("user enters valid email address in email input field");
    }
    @Given("enters valid password in password input field")
    public void enters_valid_password_in_password_input_field() {
        carRentalLoginPage.passwordInputField.sendKeys(ConfigReader.getProperty("carRentalPassword"));
        ExtentReportUtils.info("user enters valid password in password input field");
    }
    @Given("user clicks on Login button")
    public void user_clicks_on_login_button() {
        carRentalLoginPage.loginButton.click();
        waitFor(1);
        ExtentReportUtils.info("user clicks on Login button");
    }
    @Then("verifies login is successful")
    public void verifies_login_is_successful() {
       assertTrue(carRentalDashboardPage.profileDropdown.getText().contains("Suzanne"));
       assertTrue(carRentalDashboardPage.profileDropdown.isDisplayed());
        ExtentReportUtils.info("user should be logged in");
    }
    @Then("user clicks on Logout button")
    public void user_clicks_on_logout_button() {
        carRentalDashboardPage.profileDropdown.click();
        waitFor(1);
        carRentalDashboardPage.logoutOption.click();
        waitFor(1);
        carRentalDashboardPage.acceptPopUp.click();

        // Failing test case on purpose to see if screenshots ared added to the reports or not
        //carRentalDashboardPage.cancelPopUp.click();

        ExtentReportUtils.info("user clicks on Logout button");
    }
    @Then("verifies logout is successful")
    public void verifies_logout_is_successful() {
        assertTrue(carRentalHomePage.loginOption.isDisplayed());

        ExtentReportUtils.info("user should be logged out");

    }

    @Given("enters invalid email address in email input field")
    public void enters_invalid_email_address_in_email_input_field() {
        carRentalLoginPage.emailInputField.sendKeys(ConfigReader.getProperty("fakeEmail"));
    }

    @Given("enters invalid password in password input field")
    public void enters_invalid_password_in_password_input_field() {
       carRentalLoginPage.passwordInputField.sendKeys(ConfigReader.getProperty("fakePassword"));
    }




}
