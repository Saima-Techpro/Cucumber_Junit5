package runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/ui_features")

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,
        value = "pretty, " +
                "html:target/failed-cucumber-reports.html, " +
                "json:target/json-reports/failed-cucumber.json, " +
                "junit:target/xml-reports/failed-cucumber.xml, " +
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm")

// To publish reports
@ConfigurationParameter(key = "cucumber.publish.enabled" , value = "true")

@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions, hooks")
@ConfigurationParameter(key = ANSI_COLORS_DISABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")

@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@failed")


public class FailedTestRunner {
}
