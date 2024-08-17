package steps;

import java.util.ArrayList;
import java.util.Arrays;
 import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.When;
import utils.CommonMethods;

public class dashboard extends CommonMethods {

	@When("I want to validate the dashboard menu items")
	public void i_want_to_validate_the_dashboard_menu_items() {
		// Write code here that turns the phrase above into concrete actions
		login.loginToHRM();

		String[] arr = {"Admin", "PIM", "My Info", "Discipline", "Reports Catalog", "More", "Maintenance" };
		List<String> expecedMenu = new ArrayList<>();
		expecedMenu.addAll(Arrays.asList(arr));

		List<String> actualMenu = new ArrayList<>();
		for (WebElement e : dashboard.menuItems) {
			actualMenu.add(e.getText());
		}
		System.out.println(actualMenu);
		Assert.assertEquals(expecedMenu, actualMenu);
	}

}
