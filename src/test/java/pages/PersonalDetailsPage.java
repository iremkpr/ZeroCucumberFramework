package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class PersonalDetailsPage extends CommonMethods {
	@FindBy(id = "pim.navbar.employeeName")
	public WebElement empName;

	@FindBy(id = "firstName")
	public WebElement firstName;

	@FindBy(xpath = "//div[@class='form-group schema-form-submit right']/button")
	public WebElement firstSaveButton;

	@FindBy(xpath = "//input[@id='emp_birthday']/..//i")
	public WebElement birthDateIcon;

	@FindBy(xpath = "//input[@id='emp_birthday']/..//div[@class='select-wrapper picker__select--month']/input")
	public WebElement birthMonthOpenIcon;

	@FindBy(xpath = "//input[@id='emp_birthday']/..//div[@class='select-wrapper picker__select--month']//li")
	public List<WebElement> birthMonths;

	@FindBy(xpath = "//input[@id='emp_birthday']/..//td/div[@class='picker__day picker__day--infocus']")
	public List<WebElement> birthDays;

	@FindBy(xpath = "//input[@id='emp_birthday']/..//div[@class='select-wrapper picker__select--year']/input")
	public WebElement birthYearOpenIcon;

	@FindBy(xpath = "//input[@id='emp_birthday']/..//div[@class='select-wrapper picker__select--year']//ul/li")
	public List<WebElement> birthYears;

	@FindBy(xpath = "//div[@id='emp_marital_status_inputfileddiv']//input")
	public WebElement maritalStatusIcon;

	@FindBy(xpath = "//input[@value='Married']/..//ul/li/span")
	public List<WebElement> maritalStatusOptions;

	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']//input")
	public WebElement genderIcon;

	@FindBy(xpath = "//div[@id='emp_gender_inputfileddiv']/div//li/span")
	public List<WebElement> genders;

	@FindBy(xpath = "//div[@id='nation_code_inputfileddiv']//input")
	public WebElement nationalityIcon;

	@FindBy(xpath = "//div[@id='nation_code_inputfileddiv']//ul//span")
	public List<WebElement> nationalities;

	@FindBy(xpath = "//label[@for='emp_dri_lice_exp_date']/..//i")
	public WebElement licenceDateIcon;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/..//div[@class='select-wrapper picker__select--month']/input")
	public WebElement licMonthOpenIcon;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/..//div[@class='select-wrapper picker__select--month']//li/span")
	public List<WebElement> licMonths;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/..//div[@class='select-wrapper picker__select--year']/input")
	public WebElement licYearOpenIcon;

	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/..//div[@class='select-wrapper picker__select--year']//li/span")
	public List<WebElement> licYears;
	
	@FindBy(xpath = "//input[@id='emp_dri_lice_exp_date']/..//table//td/div[@class='picker__day picker__day--infocus']")
	public List<WebElement> licDays;

	@FindBy(xpath = "//label[@for='smoker']")
	public WebElement smocker;
	
	public PersonalDetailsPage() {
		PageFactory.initElements(driver, this);
	}
}
