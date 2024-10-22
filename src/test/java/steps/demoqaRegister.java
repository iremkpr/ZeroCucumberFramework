package steps;

 import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
 import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
  
public class demoqaRegister extends CommonMethods{
 
	@Given("Open the {string} url on chrome")
	public void open_the_url_on_chrome(String string) {
	    // Write code here that turns the phrase above into concrete actions
	//	WebDriverManager.chromedriver().setup();
	//	driver=new ChromeDriver();
	//	driver.get("https://demo.guru99.com/test/newtours/");
		
	}

	@Given("Click the register button")
	public void click_the_register_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement register=driver.findElement(By.xpath("//td/a[text()='REGISTER']"));
		register.click();
	}

	@When("Fill the informations for registration")
	public void fill_the_informations_for_registration() throws InterruptedException {
		WebElement fName=driver.findElement(By.xpath("//input[@name='firstName']"));
		WebElement lName=driver.findElement(By.xpath("//input[@name='lastName']"));
		WebElement phone=driver.findElement(By.xpath("//input[@name='phone']"));
		WebElement mail=driver.findElement(By.xpath("//input[@name='userName']"));
		WebElement adress=driver.findElement(By.xpath("//input[@name='address1']"));
		WebElement city=driver.findElement(By.xpath("//input[@name='city']"));
		WebElement state=driver.findElement(By.xpath("//input[@name='state']"));
		WebElement postCode=driver.findElement(By.xpath("//input[@name='postalCode']"));
		Select select=new Select(driver.findElement(By.xpath("//select[@name='country']")));
	
		WebElement userName=driver.findElement(By.xpath("//input[@id='email']"));
		WebElement password=driver.findElement(By.xpath("//input[@name='password']"));
		WebElement confirmPassword=driver.findElement(By.xpath("//input[@name='confirmPassword']"));

		
		 
		
		fName.sendKeys("Irem");
		lName.sendKeys("Gumus");
		phone.sendKeys("2038368290");
		mail.sendKeys("irem_skop@gmail.com");
		adress.sendKeys("North Bergen 2364 park ave");
		city.sendKeys("North Bergen");
		state.sendKeys("New Jersey");
		postCode.sendKeys("7829");
		select.selectByVisibleText("UNITED STATES");
			
		userName.sendKeys("iremkop2");
		password.sendKeys("iremkop10Aa*");
		confirmPassword.sendKeys("iremkop10Aa*");
		Thread.sleep(2000);
		
		WebElement submit=driver.findElement(By.xpath("//input[@name='submit']"));
		submit.click();
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Wait up to 10 seconds
		
		//validation
		WebElement userRegistered = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//font/b[contains(text(),'Dear')]")));

		Assert.assertTrue("User wasn't registered!",userRegistered.isDisplayed());
		
		
  	}

	@When("Click submit button")
	public void click_submit_button() {
 	}

	@Then("Validate User registered succesfully")
	public void validate_user_registered_succesfully() {
 	}


}
