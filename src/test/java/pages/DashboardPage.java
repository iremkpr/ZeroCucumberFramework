package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

 import utils.CommonMethods;

public class DashboardPage extends CommonMethods {

	@FindBy(id="account-name")
	public WebElement accountName;
	
	@FindBy(xpath = "//li[@id='menu_pim_viewPimModule']/a//span[2]")
	public WebElement pim;

	@FindBy(xpath = "//a[@id='menu_pim_viewEmployeeList']/span[2]")
	public WebElement emplist;
	
	@FindBy(xpath = "//a[@id='menu_pim_addEmployee']/span[2]")
	public WebElement addEmp;

	@FindBy(xpath = "//li[contains(@class,'l1')]/a/span[2]")
	public List<WebElement> menuItems;
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
}
