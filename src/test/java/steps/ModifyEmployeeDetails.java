package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class ModifyEmployeeDetails extends CommonMethods {
	@When("Click Employee List button")
	public void click_employee_list_button() {
	    // Write code here that turns the phrase above into concrete actions
		dashboard.emplist.click();
	}
	@Then("Click one Random user who has personal details")
	public void click_one_random_user_who_has_personal_details() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//table[@id='employeeListTable']/tbody/tr[2]/td[2]")).click();
	    FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
	    		.withTimeout(Duration.ofSeconds(30))
	    		.pollingEvery(Duration.ofSeconds(1));
	    wait.until(ExpectedConditions.visibilityOf(personalDetails.firstName));
	   
	}
	@Then("Update name")
	public void update_date_of_birth() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    personalDetails.firstName.clear();
	    personalDetails.firstName.sendKeys("Adalwin48");
	    personalDetails.firstSaveButton.click();
	    Thread.sleep(5000);
	    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
	    wait.until(ExpectedConditions.visibilityOf(personalDetails.empName));
	    
	    
	    
	}
	@Then("Validate changes on personal detail page")
	public void checkControl() {
		 String actual=personalDetails.empName.getText();
		    if(actual.contains("Adalwin48")) {
		    	System.out.println("PASSED!!!");
		    }
		    else {
				System.out.println("FAILED!!!");
			} 
	}



}
