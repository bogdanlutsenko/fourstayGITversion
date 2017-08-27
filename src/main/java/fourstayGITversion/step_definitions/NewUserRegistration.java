package fourstayGITversion.step_definitions;

import java.util.Random;
import org.junit.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fourstayGITversion.pages.AccountPage;
import fourstayGITversion.pages.HomePage;
import fourstayGITversion.pages.ProfileSettingsPage;
import fourstayGITversion.utilities.BrowserUtilities;
import fourstayGITversion.utilities.ConfigurationReader;
import fourstayGITversion.utilities.Driver;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;


public class NewUserRegistration {

	HomePage homePage = new HomePage();
	Fairy fairy = Fairy.create();
	Person person = fairy.person();
	AccountPage accountPage = new AccountPage();
	ProfileSettingsPage profileSettingsPage = new ProfileSettingsPage();
	Random random = new Random();
	
	@Given("^the user is on the FourStay sign up dialog$")
	public void the_user_is_on_the_FourStay_sign_up_dialog() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Driver.getInstance().manage().window().maximize();
		homePage.signUpButton.click();
	}

	@Given("^the user enters enter first name \"([^\"]*)\" and last name \"([^\"]*)\"$")
	public void the_user_enters_enter_first_name_and_last_name(String firstName, String lastName) throws Throwable {
		Thread.sleep(1000);
		homePage.firstNameField.sendKeys(firstName);
		homePage.lastNameField.sendKeys(lastName);

	}

	@Given("^and the user enters any unregistered email and password$")
	public void and_the_user_enters_any_unregistered_email_and_password() throws Throwable {
		int randomNum1 = random.nextInt(1000);
		int randomNum2 = random.nextInt(1000);
		//String email = person.getEmail();
		//homePage.emailField.sendKeys(email);
		homePage.emailField.sendKeys("alberteinstein"+randomNum1+randomNum2+"@gmail.com");
		homePage.passwordField.sendKeys("password");

	}

	@Given("^click on the Sign up button$")
	public void click_on_the_Sign_up_button() throws Throwable {
		homePage.mySignUpButton.click();
	}

	@When("^the user goes the account details page$")
	public void the_user_goes_the_account_details_page() throws Throwable {
		BrowserUtilities.waitForPageLoad();
		accountPage.profilePicDropDown.click();
		accountPage.editProfileButton.click();
	}

	@Then("^first name \"([^\"]*)\" and last name \"([^\"]*)\" should be displayed in the right fields$")
	public void first_name_and_last_name_should_be_displayed_in_the_right_fields(String ExpFirstName, String ExpLastName)
			throws Throwable {
		String firstName = profileSettingsPage.firstNameField.getAttribute("value");
		String lastName = profileSettingsPage.lastNameField.getAttribute("value");
		Assert.assertEquals(ExpFirstName, firstName);
		Assert.assertEquals(ExpLastName, lastName);
		
	}

}
