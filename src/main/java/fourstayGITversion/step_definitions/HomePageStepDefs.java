package fourstayGITversion.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fourstayGITversion.utilities.ConfigurationReader;
import fourstayGITversion.utilities.Driver;

public class HomePageStepDefs {
	

	@Given("^the user is on fourstay home page$")
	public void the_user_is_on_fourstay_home_page() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		
	}

	@When("^the user clicks on the login link$")
	public void the_user_clicks_on_the_login_link() throws Throwable {
		Driver.getInstance().findElement(By.cssSelector(".not-login")).click();
	}

	@Then("^the email field should be displayed$")
	public void the_email_field_should_be_displayed() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 20);
		wait.until(ExpectedConditions.visibilityOf(Driver.getInstance().findElement(By.id("email"))));
		Assert.assertTrue(Driver.getInstance().findElement(By.id("email")).isDisplayed());
		
	}

}
