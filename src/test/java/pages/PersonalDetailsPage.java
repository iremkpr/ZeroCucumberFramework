package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class PersonalDetailsPage extends CommonMethods{
	@FindBy(id="pim.navbar.employeeName")
	public WebElement empName;
	
	@FindBy(id="firstName")
	public WebElement firstName;
	
	@FindBy(xpath = "//div[@class='form-group schema-form-submit right']/button")
	public WebElement firstSaveButton;
	
	public PersonalDetailsPage(){
		PageFactory.initElements(driver, this);
	}
}
