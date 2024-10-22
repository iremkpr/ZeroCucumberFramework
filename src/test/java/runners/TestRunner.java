package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
 	
@CucumberOptions(

		features="src/test/resources/Features/",
		glue="steps", 
		dryRun= false,
		tags="@Licenses",
		monochrome=true,
		plugin = {
				// Prints the gherkin steps to the console
				"pretty",
				
				// Creates and saves the basic html report on the target folder
				"html:target/cucumber-default-report.html",
				
				// Stores every step of the execution to a json file
				"json:target/cucumber.json",
				"rerun:target/failed.txt"				
				}
		)
	
public class TestRunner {

}
