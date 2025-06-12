package runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features/ui_features")

@SelectFile("target/failedRerun.txt")

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME ,
        value = "pretty , " +
                "html:target/cucumber-reports.html , " +
                "json:target/json-reports/cucumber.json , " +
                "junit:target/xml-reports/cucumber.xml , " +
                "rerun:target/failedRerun.txt")


@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "stepdefinitions")
@ConfigurationParameter(key = ANSI_COLORS_DISABLED_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")


public class FailedTestRunner {
}

