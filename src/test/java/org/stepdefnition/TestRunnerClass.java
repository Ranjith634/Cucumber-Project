package org.stepdefnition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources", glue = "org.stepdefnition" , monochrome = true,snippets = SnippetType.UNDERSCORE,tags = "Sanity", dryRun = false,plugin = {"html:Report"} )

public class TestRunnerClass {

}
 