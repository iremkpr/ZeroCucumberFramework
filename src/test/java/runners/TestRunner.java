package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
 	
@CucumberOptions(

		features="src/test/resources/Features",
		glue="steps",
		dryRun= false,
		tags="@trial1",
		monochrome=true
		)
	
public class TestRunner {

}
