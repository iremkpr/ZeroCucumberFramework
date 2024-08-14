package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {
	
	@FindBy(xpath = "//form[@name='oxdModalForm']")
	public WebElement adEmpForm;
	
	@FindBy(id="first-name-box")
	public WebElement fNameBox;
	
	@FindBy(id="middle-name-box")
	public WebElement mNameBox;
 	
	@FindBy(id="last-name-box")
	public WebElement lNameBox;
	
	
	@FindBy(xpath="//div[@class='input-group-append']/button/i[2]")
	public WebElement openLocsButton;
	
	@FindBy(xpath="//div[@class='inner show']//a[@class='dropdown-item']//span")
	public List<WebElement> locations;
 
	@FindBy(id="employeeId")
	public WebElement empId;
	
	@FindBy(id="modal-save-button")
	public WebElement save;
	
	@FindBy(id="pim.navbar.employeeName")
	public WebElement empName;
	
	@FindBy(xpath="//label[@for='hasLoginDetails']")
	public WebElement detailButton;
	
	@FindBy(id="username")
	public WebElement userName;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(id="confirmPassword")
	public WebElement confirmPassword;

	
	public AddEmployeePage() {
		PageFactory.initElements(driver, this);
	}
	public void locationSelect(List<WebElement> list, String select) {
		boolean selection=false;
		for(WebElement w:list) {
			if(w.getText().equals(select)) {
				selection=true;
				w.click();
				break;
			}
		}
		if(!selection) {
			System.out.println("Your selection is not exist on list");
		}
	}
}
