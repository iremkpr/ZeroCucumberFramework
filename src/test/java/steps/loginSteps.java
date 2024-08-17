package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ConfigReader;

public class loginSteps extends CommonMethods {
	public static FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(1)).ignoring(TimeoutException.class);

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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(25))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(TimeoutException.class);

		wait.until(ExpectedConditions.visibilityOf(login.accountName));
		String name = login.accountName.getText();
		if (name.equals("Jacqueline White")) {
			System.out.println("Test succeed ! You logged in as Jacqueline White");
		} else {
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
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(25))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.visibilityOf(login.retryLogin));
		if (login.retryLogin.isDisplayed()) {
			System.out.println(
					"Test Passed! When tried to the login with invalid password it navigated to Retry Login form ");
		}
	}

	@When("Fill username box with valid {string} data")
	public void fill_username_box_with_valid_data(String userName) {
		// Write code here that turns the phrase above into concrete actions
		login.userName.sendKeys(userName);
	}

	@And("Fill password box with valid {string} data")
	public void fill_password_box_with_valid_data(String password) {
		// Write code here that turns the phrase above into concrete actions
		login.password.sendKeys(password);
	}

	@Then("Validate account name matched with expected {string}")
	public void validate_account_name_matched_with_expected(String expected) {
		// Write code here that turns the phrase above into concrete actions
		String actual = dashboard.accountName.getText();
		Assert.assertEquals(expected, actual);
	}

	// -----------------------------------------------------------------------------------------------------------------------------
	// -------------------------------------------------- FROM HERE TO DOWN
	// --------------------------------------------------
	// -----------------------------------------------------------------------------------------------------------------------------

	@When("click add employee button and Send valid username, lastname, id and location")
	public void send_valid_username_lastname_id_and_location(io.cucumber.datatable.DataTable dataTable)
			throws InterruptedException {
		dashboard.pim.click();
		List<Map<String, String>> listOfMaps = dataTable.asMaps();
		for (Map<String, String> m : listOfMaps) {

			dashboard.addEmp.click();
			fluent.until(ExpectedConditions.visibilityOf(addEmp.adEmpForm));

			addEmp.fNameBox.sendKeys(m.get("username"));
			addEmp.lNameBox.sendKeys(m.get("lastname"));
			addEmp.empId.sendKeys(m.get("id"));
			addEmp.openLocsButton.click();
			addEmp.locationSelect(addEmp.locations, m.get("location"));
			Thread.sleep(6000);

			addEmp.save.click();
			Thread.sleep(6000);
			fluent.until(ExpectedConditions.visibilityOf(personalDetails.empName));

		}
	}

	@Then("Search new added accounts and validate")
	public void search_new_added_accounts_and_validate(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> listOfMaps = dataTable.asMaps();
		for (Map<String, String> m : listOfMaps) {
			dashboard.emplist.click();
			fluent.until(ExpectedConditions.visibilityOf(empListPage.searchBox));
			empListPage.searchBox.sendKeys(m.get("accountName"));
			empListPage.searchButton.click();
			Thread.sleep(3000);
			fluent.until(ExpectedConditions.visibilityOf(empListPage.emplName));
			String expected=m.get("accountName");
			String actual=empListPage.emplName.getText();
			
			
			Thread.sleep(6000);
			Assert.assertEquals(expected, actual);
		}

	}

}
