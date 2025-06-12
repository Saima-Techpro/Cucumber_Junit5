package stepdefinitions;

import io.cucumber.java.en.Given;
import utilities.Driver;

import static utilities.WaitUtils.waitFor;

public class CommonStepDefs {
    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        Driver.getDriver().get(url);
        waitFor(2);
    }
}
