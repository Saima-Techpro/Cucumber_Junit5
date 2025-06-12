package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import pages.GoogleHomePage;
import utilities.Driver;
import utilities.WaitUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utilities.WaitUtils.waitFor;

public class GoogleStepDefs {

    GoogleHomePage googleHomePage = new GoogleHomePage(); // Create the page object

    @Given("user is on the google homepage")
    public void user_is_on_the_google_homepage() {
        Driver.getDriver().get("https://www.google.com/");
//        try{
//            googleHomePage.googlePopup.click();
//        }catch (Exception e){
//
//        }
        waitFor(1);
    }
    @Given("user search for iPhone")
    public void user_search_for_i_phone() {
        googleHomePage.searchBox.sendKeys("iPhone" + Keys.ENTER);
        waitFor(1);
    }
    @Then("verify that result contains iPhone")
    public void verify_that_result_contains_i_phone() {
        assertTrue(Driver.getDriver().getCurrentUrl().contains("iPhone"));
        waitFor(1);
    }
    @Then("user closes the application")
    public void user_closes_the_application() {
        Driver.closeDriver();
    }

    // teapot test steps
    @Given("user search for teapot")
    public void user_search_for_teapot() {
    googleHomePage.searchBox.sendKeys("teapot", Keys.ENTER);
     waitFor(1);
    }
    @Then("verify that result contains teapot")
    public void verify_that_result_contains_teapot() {
       assertTrue(Driver.getDriver().getCurrentUrl().contains("teapot"));
    }

    // day02_parameterising.feature

    @Given("user search for {string} on google")
    public void user_search_for_on_google(String searchItem) {
        googleHomePage.searchBox.sendKeys(searchItem, Keys.ENTER);
        waitFor(2);
    }
    @Then("user verifies that page title contains {string}")
    public void user_verifies_that_page_title_contains(String searchTitle) {
        assertTrue(Driver.getDriver().getTitle().contains(searchTitle));
    }























}
