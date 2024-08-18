package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "src/test/resources/Features/",
		glue = "steps",
		dryRun = false,
		tags = "@excelDataTable",
		monochrome = true,
		
		plugin = {
				// "pretty",
				"html:target/cucumber-default-report.html",
				"json:target/cucumber.json",
				"rerun:target/failed.txt"
				}
		)

public class RegressionRunner {

}
