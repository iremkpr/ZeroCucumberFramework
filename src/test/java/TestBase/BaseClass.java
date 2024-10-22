package TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

 import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;
import utils.Constants;
public class BaseClass {

	public static WebDriver driver;
  
	
 	public static void setUp() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		
		ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);

 		
		String browser = ConfigReader.getProperty("browser");
 
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}

		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		String website = ConfigReader.getProperty("url");
		driver.get(website);
		
		PageInitializer.initialize();
		
	}	
 	public static void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
	

}
