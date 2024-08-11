package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonMethods;

 
public class GooglePage extends CommonMethods{

	@FindBy(id="APjFqb")
	public WebElement searchbox;
	
	@FindBy(xpath="//div[@class='gJBeNe d2F2Td']")
	public WebElement dic;
	
	@FindBy(xpath="//h3[@class='LC20lb MBeuO DKV0Md']")
	public List<WebElement> links;
	
	
	
	 public GooglePage() {
		 PageFactory.initElements(driver,this);
	 }
	 
}




