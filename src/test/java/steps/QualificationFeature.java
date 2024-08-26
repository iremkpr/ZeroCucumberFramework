package steps;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.CommonMethods;

public class QualificationFeature extends CommonMethods {
	@Given("Login with valid Admin data")
	public void login_with_valid_admin_data() {
		// Write code here that turns the phrase above into concrete actions
		login.loginToHRM();
	}

	@Given("Click to the Admin button")
	public void click_to_the_admin_button() {
		// Write code here that turns the phrase above into concrete actions
		dashboard.admin.click();
	}

	@Given("Click to the Qualification button")
	public void click_to_the_qualification_button() {
		// Write code here that turns the phrase above into concrete actions
		dashboard.qualificationButton.click();
	}

	@Given("Click to the specific qualification button {string}")
	public void click_to_the_skills_button(String qualification) {
		selectionFromList(dashboard.qualifications, qualification);
	}

	@Given("Click to the add icon")
	public void click_to_the_add_icon() {
		// Write code here that turns the phrase above into concrete actions
		qualification.qualifAddIcon.click();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(qualification.name));

	}

	@Then("Fill the valid {string}, {string}")
	public void fill_the_valid(String name, String descrp) {
		// Write code here that turns the phrase above into concrete actions
		qualification.name.sendKeys(name);
		qualification.description.sendKeys(descrp);
	}

	@Then("Click the save button")
	public void click_the_save_button() {
		// Write code here that turns the phrase above into concrete actions
		qualification.save.click();
		getWaitObject().until(ExpectedConditions.visibilityOfAllElements(qualification.addedNames));
	}
	 
	@Then("Click the educationsave button")
	public void click_the_edusave_button() {
		// Write code here that turns the phrase above into concrete actions
 		qualification.educationSave.click();
		getWaitObject().until(ExpectedConditions.visibilityOfAllElements(qualification.addedNames));
	}
 	@Then("Click the licence button")
	public void click_the_licenceSave_button() {
		// Write code here that turns the phrase above into concrete actions
 		qualification.licenceSave.click();
 		getWaitObject().until(ExpectedConditions.visibilityOfAllElements(qualification.addedNames));
	}
	@Then("Validate is the {string} added")
	public void validate_is_the_skill_added(String name) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		getWaitObject().until(ExpectedConditions.visibilityOfAllElements(qualification.addedNames));

		List<WebElement> list = qualification.addedNames;
		boolean check=false;
		for (WebElement e : list) {
			if(e.getText().equals(name)) {
				System.out.println("PASSED!");
				check=true;
				break;
			}
		}
		Assert.assertTrue("FAILED! Qualification didnt added! ",check);
		Thread.sleep(5000);
	}
	@Then("Fill the valid {string}")
	public void fill_the_valid(String name) {
	    // Write code here that turns the phrase above into concrete actions
		qualification.name.sendKeys(name);
	//	getWaitObject().until(ExpectedConditions.elementToBeClickable(qualification.educationSave));
	}

	public void selectionFromList(List<WebElement> list, String clickTo) {
		for (WebElement e : list) {
			if (e.getText().equals(clickTo)) {
				e.click();
				break;
			}
		}
	}
}
