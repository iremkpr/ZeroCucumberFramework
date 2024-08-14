package steps;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
 import utils.CommonMethods;
import utils.ConfigReader;

public class loginSteps extends CommonMethods {
	 

	@Given("I enter a valid userName")
	public void validUserName() {
	    // Write code here that turns the phrase above into concrete actions
	    login.userName.sendKeys(ConfigReader.getProperty("username"));
	}

	@Then("I click to the Login button")
	public void clickLoginButton() {
	    // Write code here that turns the phrase above into concrete actions
	   login.loginButton.click();
	}
	
	@And("I enter a valid password")
	public void validPassword() {
		login.password.sendKeys(ConfigReader.getProperty("password"));
	}
	@Then("I validate that I am logged in")
	public void validateLoggedIn() {
	   Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			   .withTimeout(Duration.ofSeconds(25))
			   .pollingEvery(Duration.ofSeconds(1))
			   .ignoring(TimeoutException.class);
	   
	   wait.until(ExpectedConditions.visibilityOf(login.accountName));
	   String name=login.accountName.getText();
	   if(name.equals("Jacqueline White")) {
		   System.out.println("Test succeed ! You logged in as Jacqueline White");
	   }
	   else {
		System.out.println("Test Failed!");
	   }
	   driver.quit();
	}

	@And("I enter invalid password")
	public void invalidPassword() {
		login.password.sendKeys("invalid");
	}
	
	@Then("I verified the warning")
	public void verifyWarning() {
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(25))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.visibilityOf(login.retryLogin));
		if(login.retryLogin.isDisplayed()) {
			System.out.println("Test Passed! When tried to the login with invalid password it navigated to Retry Login form ");
		}
 	}
}
