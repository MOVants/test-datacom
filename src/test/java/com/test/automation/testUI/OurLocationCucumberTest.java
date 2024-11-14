package com.test.automation.testUI;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/OurLocation/ourLocationTest.feature", glue = "com.test.automation.testUI")
public class OurLocationCucumberTest {

}
