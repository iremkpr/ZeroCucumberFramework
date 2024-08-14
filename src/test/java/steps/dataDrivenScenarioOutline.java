package steps;

 
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class dataDrivenScenarioOutline extends CommonMethods {
	@When("enter valid {string} and {string}")
	public void enter_valid_and(String uName, String pass) {
		// Write code here that turns the phrase above into concrete actions
		login.userName.sendKeys(uName);
		login.password.sendKeys(pass);
	}

	@When("Click login button")
	public void click_login_button() {
		// Write code here that turns the phrase above into concrete actions
		login.loginButton.click();
	}

	@Then("Validate {string}")
	public void validate(String expectedName) {
		// Write code here that turns the phrase above into concrete actions
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(25)).pollingEvery(Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(login.accountName));
		String actual = login.accountName.getText();
		if (actual.equals(expectedName)) {
			System.out.println("PASSED");
		}
		else {
			System.out.println("FAILED");
		}
	}

}
