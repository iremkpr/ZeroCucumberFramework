package steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class googleSearchSteps extends CommonMethods {

	@Given("Initialize driver as Chrome and Open Google")
	public void initialize_driver_as_chrome() throws InterruptedException {
		setUp();
 	}

	@When("Send text on Search Box")
	public void send_text_on_search_box() {
 		    google.searchbox.sendKeys("trial");
	}

	@And("Click search button")
	public void click_search_button() {
 		google.searchbox.sendKeys(Keys.ENTER);      
	}

	@And("Count line of listed results")
	public int count_line_of_listed_results() {
		
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(25))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(TimeoutException.class);
		
		wait.until(ExpectedConditions.visibilityOf(google.dic));
 		List<WebElement> linkList=google.links;
		System.out.println(linkList.size());
		return linkList.size();
 	}

	@Then("Verify result numbers")
	public void verify_result_numbers() {
 		System.out.println(google.links.size()+" links are exist on google search results ");

		 
		driver.quit();
	}

}
