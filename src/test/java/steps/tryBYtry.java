package steps;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.Constants;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tryBYtry {

	public WebDriver driver;

	
	@Given("Open url on browser")
	public void open_url_on_browser() {
		// Write code here that turns the phrase above into concrete actions
		//ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
 		WebDriverManager.chromedriver().setup();
 		 driver=new ChromeDriver();
 		driver.get("https://hrm.neotechacademy.com/");
	}

	@Given("Fill the username")
	public void fill_the_username() {
		
		WebElement userName=driver.findElement(By.id("txtUsername"));
 		userName.sendKeys("Admin");
		
	}

	@Then("Fill the password")
	public void fill_the_password() {
		// Write code here that turns the phrase above into concrete actions
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys("Neotech@123");

	}

	@When("Click the login button")
	public void click_the_login_button() {
		// Write code here that turns the phrase above into concrete actions
 		WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));

		loginButton.click();
	}

	@When("Validate user logged in the system")
	public void validate_user_logged_in_the_system() {
		// Write code here that turns the phrase above into concrete actions
		
		WebElement username=driver.findElement(By.id("account-name"));
		String uName=username.getText();
		Assert.assertTrue("User name is not Jacqueline White",uName.equals("Jacqueline White"));
		System.out.println("username="+uName);
	}
}
