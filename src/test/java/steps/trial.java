package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class trial extends CommonMethods {

	@When("login to the HRM with valid {string} and {string}")
	public void login_to_the_hrm_with_valid_and(String userName, String password) {
	
 		login.userName.sendKeys(userName);
		login.password.sendKeys(password);
		login.loginButton.click();
	}

	@Then("Add new employee from dataTable")
	public void add_new_employee_from_data_table(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> listMaps = dataTable.asMaps();

		FluentWait<WebDriver> wait2 = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(TimeoutException.class);
 
		
		for (Map<String, String> m : listMaps) {
			
			dashboard.addEmp.click();
			wait2.until(ExpectedConditions.visibilityOf(addEmp.adEmpForm));

			addEmp.fNameBox.sendKeys(m.get("firstName"));
			addEmp.lNameBox.sendKeys(m.get("lastName"));
			addEmp.empId.sendKeys(m.get("id"));
			addEmp.openLocsButton.click();
			selectFromListOfElement(addEmp.locations, m.get("location"));
			clickJS(addEmp.detailButton);
			visbilityOfElementWait(addEmp.userName);
			addEmp.userName.sendKeys(m.get("userName"));
			addEmp.password.sendKeys(m.get("password"));
			addEmp.confirmPassword.sendKeys(m.get("password"));
			Thread.sleep(6000);

			//WebElement save=driver.findElement(By.id("modal-save-button"));
			addEmp.save.click();
			Thread.sleep(1000);
 			wait2.until(ExpectedConditions.visibilityOf(personalDetails.empName));

 		//	driver.navigate().refresh();
 		/*	if(!personalDetails.empName.isDisplayed()) {
 				save.click();
 	 			wait2.until(ExpectedConditions.visibilityOf(personalDetails.empName));

 			}
*/ 
		}

	}

	public static FluentWait<WebDriver> fluentWait() {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(35))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(NoSuchElementException.class);
		return wait;
	}

	public void visbilityOfElementWait(WebElement element) throws InterruptedException {
		Thread.sleep(2000);
		FluentWait<WebDriver> wait = fluentWait();
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void selectFromListOfElement(List<WebElement> elements, String option) {
		for (WebElement e : elements) {
			if (e.getText().equals(option)) {
				e.click();
				break;
			}
		}
	}

	public void clickJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

}
