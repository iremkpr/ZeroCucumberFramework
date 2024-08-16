package steps;

import org.junit.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.CommonMethods;

public class LoginWithExamples extends CommonMethods {
    
    @Given("Open HRM WebSite")
    public void open_hrm_web_site() {
        // Assuming @Before and @After methods in Hooks initialize and quit the driver
    }

    @And("Send valide username {string}")
    public void username(String username) {
        login.userName.sendKeys(username);
    }

    @And("Send valide password {string}")
    public void password(String password) {
        login.password.sendKeys(password);
    }

    @And("click login button")
    public void click_login_button() {
        login.loginButton.click();
    }

    @Then("Validate {string} is matched with expected data")
    public void validate_is_matched_with_expected_data(String expected) {
        String actual = dashboard.accountName.getText();
        Assert.assertEquals(expected, actual);
        if (actual.equals(expected)) {
            System.out.println("actual is as expected");
        }
    }
}
