package hooks;

import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.ExtentReportUtils;

import static utilities.ExtentReportUtils.passAndCaptureScreenshot;


public class Hooks {


    @BeforeAll
    public static void initReport(){
        // The static block in ExtentReportUtils class already initializes everything
        System.out.println("Report initialized.. ");
    }

    /*
    This method runs before each scenario
     */

    @Before
    public void setUpScenario(Scenario scenario){
        System.out.println("Hooks running before every scenario... ");
        Driver.getDriver(); // ensure the Driver instance is created and ready to use
        System.out.println("TOKEN AT RUNTIME: " + System.getenv("CUCUMBER_PUBLISH_TOKEN"));

        ExtentReportUtils.createTestReport(scenario.getName(), "Execution of scenario: " + scenario.getName());
    }


    /*
    This method runs after each scenario.
    If the scenario fails, it captures screenshot.
    In the end, it closes the WebDriver
     */


    @After
    public void tearDown(Scenario scenario){
        System.out.println("Hooks running after a scenario....");
        System.out.println("CUCUMBER_PUBLISH_TOKEN at runtime: " + System.getenv("CUCUMBER_PUBLISH_TOKEN"));

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

    // We can run @Before and @After annotations for specific tags as well
    @After ("@iphone or @teapot")
    public void tearDownSpecific(){
        System.out.println("This after method is conditional and will run only for the given tags");
    }

    @AfterAll
    public static void generateReport(){
        ExtentReportUtils.flush();
        System.out.println("Report flushed!");
    }

    @AfterStep
    public static void afterEachStep(Scenario scenario){
        if (scenario.isFailed()){
            ExtentReportUtils.fail("Step failed");
            passAndCaptureScreenshot("Screenshot of failing step is taken ");
        }else {
            ExtentReportUtils.pass("Step passed");
            // passAndCaptureScreenshot("Screenshot of passing step is taken ");
        }
    }


}
