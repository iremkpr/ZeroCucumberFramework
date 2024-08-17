package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class EmployeeListPage extends CommonMethods{


	@FindBy(id="employee_name_quick_filter_employee_list_value")
	public WebElement searchBox;
	
	@FindBy(id="quick_search_icon")
	public WebElement searchButton;
	
	@FindBy(xpath = "//table[@id='employeeListTable']//tbody/tr/td[2]")
	public WebElement empId;
	
	@FindBy(xpath = "//table[@id='employeeListTable']//tbody/tr/td[3]")
	public WebElement empName;
	

	@FindBy(xpath = "//table[@id='employeeListTable']//tr/td[3]")
	public WebElement emplName;

	public EmployeeListPage() {
		PageFactory.initElements(driver, this);
	}
}
