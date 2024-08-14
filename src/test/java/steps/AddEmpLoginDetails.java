package steps;

 
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.en.Then;
import utils.CommonMethods;

public class AddEmpLoginDetails extends CommonMethods{
	@Then("add new employee	with Login details")
	public void add_new_employee_with_login_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		dashboard.addEmp.click();
		FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(1));
		wait.until(ExpectedConditions.visibilityOf(addEmp.adEmpForm));
		

		List<Map<String, String>> data=dataTable.asMaps();
		for(Map<String,String> m:data) {
			addEmp.fNameBox.sendKeys(m.get("FirstName"));
			addEmp.lNameBox.sendKeys(m.get("LastName"));
			addEmp.empId.sendKeys(m.get("id"));
			addEmp.openLocsButton.click();
			addEmp.locationSelect(addEmp.locations, "Australian Regional HQ");
			
			jsClick(addEmp.detailButton);
			
			addEmp.userName.sendKeys(m.get("EmployeeName"));
			addEmp.password.sendKeys(m.get("Password"));
			addEmp.confirmPassword.sendKeys(m.get("Password"));
			Thread.sleep(2000);
			addEmp.save.click();
			wait.until(ExpectedConditions.visibilityOf(addEmp.adEmpForm));

			
		}
		
		
	}
 
 
	@Then("validate to employee added")
	public void validate_to_employee_added(io.cucumber.datatable.DataTable dataTable) {
 		
		List<Map<String,String>> maps=dataTable.asMaps();
	   for(Map<String,String> m: maps) {
		   String accountName=m.get("AccountName");
		   if(personalDetails.empName.getText().equals(accountName)) {
			   System.out.println("PASSED !!");
		   }
		   else {
			System.out.println("FAILED !!");
		}
	   }
	}

	
	public static void jsClick(WebElement button) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", button);
		
	}
}
