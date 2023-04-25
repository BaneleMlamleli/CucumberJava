package org.example.Runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
// import org.example.StepDefinition.LoginSteps.java.StepDefinition;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\org\\example\\Features\\AdminPage.feature", glue = { "org.example.StepDefinition" }, 
monochrome = true, plugin = {"pretty", "html:target/HtmlReports.html", "json:target/JsonReports.json", "junit:target/XmlReport.xml"}/*, tags = "@smoketest"*/)
public class TestRunnerClass {
    //xxx
}