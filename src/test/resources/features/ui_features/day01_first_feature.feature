@googleSearch @ui
Feature: Google_Search

  Background:
    Given user is on the google homepage

  @iphone
  Scenario: TC01_iphone_search
    And user search for iPhone
    Then verify that result contains iPhone
    And user closes the application

  @teapot
  Scenario: TC02_teapot_search
    And user search for teapot
    Then verify that result contains teapot
    And user closes the application






#  ************************** FEATURE FILE ************************
#  All features file must have .feature extension
#  Feature files must be written in GHERKIN Language
#  Feature files are used to create Test scenarios / test cases
#  Feature files must start with Feature: keyword
#  Scenario keyword is used to create test case
#  One Feature file can have multiple Scenarios keyword
#  Each step of the test case must start with GHERKIN keywords => GIVEN, WHEN, THEN, AND, BUT


#  ************************** STEP DEFINITIONS ************************
#  After creating feature file, we need to generate step definitions (to write JAVA codes)
#  Use Runner class to generate missing step definitions (RECOMMENDED)
#  Use the template and add them to your Step Definition folder/class
#  Then add your Java codes in those step defs
#  Import Given, Then tags from cucumber-java library => import io.cucumber.java.en.*;
#  @tags is used to run the specific test or specific feature file as a whole in Runner Class
#   We can use multiple tags at the same time
