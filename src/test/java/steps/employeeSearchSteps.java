package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class employeeSearchSteps extends CommonMethods{

@Given("Login to HRM site")
public void login_to_hrm_site() {
    // Write code here that turns the phrase above into concrete actions
	login.loginToHRM();
}
@When("Click PIM button")
public void click_pim_button() {
     dashboard.pim.click();
}
@When("Click Employee list button")
public void click_employee_list_button() {
    dashboard.emplist.click();
}
@When("Send valid id to the search box")
public void send_valid_id_to_the_search_box() {
     empListPage.searchBox.sendKeys("0044");
}
@When("click search button")
public void click_search_button() {
    // Write code here that turns the phrase above into concrete actions
    empListPage.searchButton.click();
}
@Then("Validate with specific id employee exist on given list")
public void validate_that_employee_exist_on_given_list() {
    // Write code here that turns the phrase above into concrete actions
    String actual=empListPage.empId.getText();
    if(actual.equals("0044")) {
    	System.out.println("TEST PASSED!");
    }
    else {
		System.out.println("TEST FAILED");
	}
}

@When("Send valid name to the search box")
public void sendName() throws InterruptedException {
	empListPage.searchBox.sendKeys("Odis  Adalwin ");
}
@Then("Validate with specific name employee exist on given list")
public void validationName() {
    // Write code here that turns the phrase above into concrete actions
	
    String actual=empListPage.empName.getText();
    if(actual.contains("Odis Adalwin")) {
    	System.out.println("TEST PASSED!");
    }
    else {
		System.out.println("TEST FAILED");
	}
}
}
