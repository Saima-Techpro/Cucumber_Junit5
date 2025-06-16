package runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/ui_features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME ,
        value = "pretty , " +  // creates reports on the console as well
                "html:target/cucumber-reports.html , " +
                "json:target/json-reports/cucumber.json , " +
                "junit:target/xml-reports/cucumber.xml , " +
                "rerun:target/failedRerun.txt")

// To publish reports
@ConfigurationParameter(key = "cucumber.publish.enabled" , value = "true")

@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions , hooks")

@ConfigurationParameter(key = ANSI_COLORS_DISABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@param")

public class Runner {
}


/*
    - Runner class is used to run the feature files / specific tests. Also, to add report plug ins.
    - Runner class connects JAVA classes (step definitions) with NON-JAVA (feature) files.
    - @RunWith() is imported from JUint 4 but that's older version. JUnit5 is latest (JUnit Jupiter)
    - @RunWith() annotation is deprecated. So we use @Suite in its place

For parallel testing, use any of the following commands on the terminal
mvn clean test
mvn clean verify
mvn clean install
 */




/*

 ************************** Runner with JUnit 4 (Older version) ************************

  NOTE: You need to use this one for your internship project
         You would only need to add following dependencies:
         1. Selenium-Java
         2. Selenium-cucumber
         3. JUnit 4
         4. Others according to the needs of your project


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty", // creates reports on the console as well
                "html:target/cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-reports/cucumber.xml",
                "rerun:target/failedRerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true, //makes the console reports more readable
        features = "./src/test/resources/features",  // provides path of the features folder
        glue = {"stepdefinitions", "hooks"},  // provides path of the stepdefinitions folder and hooks folder
        dryRun = false,    // generates the missing step definitions, without running the existing step definitions
        tags = "@iPhone"
)

public class Runner {
}



/*
Runner class is used to run the feature files
And to add report plug ins
Runner class is used to connect the JAVA (step definitions) and NON-JAVA (feature files ) parts
@RunWith(Cucumber.class)  makes the Runner class runnable
@CucumberOptions is used to connect the feature files with their step definitions. It is also used for configurations and report plugins
features => provides path of the features folder
glue is used to connect feature file with it step definitions
dryRun = true generates the missing step definitions, without running the existing step
dryRun = false must be used to run the tests normally
@tags us used to run specific test scenarios




 */
