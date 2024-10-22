package steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
//import io.github.bonigarcia.wdm.WebDriverManager;
import utils.CommonMethods;

public class faceSignUp extends CommonMethods{
	@Given("Open {string} website")
	public void open_website(String url) {
//		WebDriverManager.chromedriver().setup();
	//	WebDriver driver=new ChromeDriver();
	//driver.get(url);
	}
	@Given("Send valid userName {string} and password as {string}")
	public void send_valid_user_name_and_password_as(String name, String passw) {
	    WebElement userName=driver.findElement(By.id("email"));
	    WebElement pass=driver.findElement(By.id("pass"));
	    userName.sendKeys(name);
	    pass.sendKeys(passw);
	}
	@When("Click the Login button")
	public void click_the_login_button() {
		WebElement loginButton=driver.findElement(By.xpath("//button[@name='login']"));
		loginButton.click();
	}
	@When("Validate that user logged in succesfully")
	public void validate_that_user_logged_in_succesfully() {
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	   WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[text()='İrem Köprek']"))));
	   Assert.assertTrue("element is not exist", element.isDisplayed());
	   
	}


}
