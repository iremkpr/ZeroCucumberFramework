package steps;

import java.time.Duration;
import java.util.List;
import java.util.Map;
 
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class DataTable  extends CommonMethods{
	@When("login to the HRM")
	public void login_to_the_hrm() {
	   login.loginToHRM();
 	}
	@When("Click pim button")
	public void click_pim_button() {
	    dashboard.pim.click();
 	}
 
	@Then("Add new employee")
	public void add_new_employee(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
 		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
 				.withTimeout(Duration.ofSeconds(30))
 				.pollingEvery(Duration.ofSeconds(1))
 				.ignoring(TimeoutException.class);
  		
		List<Map<String, String>> listMap=dataTable.asMaps();
		for(Map<String,String> map:listMap) {

			String fName=map.get("FirstName");
			String mName=map.get("MiddleName");
			String lName=map.get("LastName");
			
	 		dashboard.addEmp.click();
			wait.until(ExpectedConditions.visibilityOf(addEmp.fNameBox));
 
			
			addEmp.fNameBox.sendKeys(fName);
			addEmp.mNameBox.sendKeys(mName);
			addEmp.lNameBox.sendKeys(lName);
		
			addEmp.empId.sendKeys("9989");
			
			addEmp.openLocsButton.click();
			addEmp.locationSelect(addEmp.locations, "Australian Regional HQ");
			addEmp.save.click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(addEmp.empName));
 		}
		
	}
	@Then("validate employee is added")
	public void validate_employee_is_added() {
	    // Write code here that turns the phrase above into concrete actions
 	}

}
