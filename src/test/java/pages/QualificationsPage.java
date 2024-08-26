package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

public class QualificationsPage extends CommonMethods {

	@FindBy(xpath = "//div[@class='fixed-action-btn floating-add-btn tooltipped']//i")
	public WebElement qualifAddIcon;

	/*
	 * @FindBy(xpath="") public WebElement ;
	 */
	@FindBy(id = "name")
	public WebElement name;

	@FindBy(id = "description")
	public WebElement description;

	@FindBy(xpath = "//a[@form-name='skillsModalForm']")
	public WebElement save;
	
	//div[@class='modal modal-fixed-footer open']//a[@form-name='educationModalForm']

	@FindBy(xpath="//div[@class='modal modal-fixed-footer open']//a[@form-name='educationModalForm']") 
	public WebElement educationSave;
	
	@FindBy(xpath = "//table[@class='highlight bordered']//tr//td[2]//span")
	public List<WebElement> addedNames;

	public QualificationsPage() {
		PageFactory.initElements(driver, this);
	}
}
