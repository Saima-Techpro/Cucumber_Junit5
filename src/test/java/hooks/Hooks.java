package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {

    /*
    This method runs before each scenario
     */

    @Before
    public void setUpScenario(){
        System.out.println("Hooks running before every scenario... ");
        Driver.getDriver(); // ensure the Driver instance is created and ready to use
    }


    /*
    This method runs after each scenario.
    If the scenario fails, it captures screenshot.
    In the end, it closes the WebDriver
     */


    @After
    public void tearDown(Scenario scenario){
        System.out.println("Hooks running after a scenario....");

        try{
            if( scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
                // Attach the screenshot to the report with the name and type
                scenario.attach(screenshot,"image/png", "screenshot of failed step");
            }
        } catch (Exception e){
            System.err.println("Error capturing screenshot!" + e.getMessage());
        }finally {
            // Close the WebDriver here
            Driver.closeDriver();
        }


    }

    @After ("@iphone or @teapot")
    public void tearDownSpecific(){
        System.out.println("This after method is conditional and will run only for the given tags");
    }

}
