package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;
import utils.ConfigReader;

public class loginPage extends CommonMethods{

	@FindBy(id="txtUsername")
	public WebElement userName;
	
	@FindBy(id="txtPassword")
	public WebElement password;
	
	@FindBy(xpath="//button")
	public WebElement loginButton;
	
	@FindBy(id="account-name")
	public WebElement accountName;
	
	@FindBy(xpath = "//div[@class='dashboardCard-title-for-card']")
	public WebElement retryLogin;
	
	public loginPage(){
		PageFactory.initElements(driver, this);
	}
	public void loginToHRM() {
		userName.sendKeys(ConfigReader.getProperty("username"));
		password.sendKeys(ConfigReader.getProperty("password"));
		loginButton.click();
	}
}
