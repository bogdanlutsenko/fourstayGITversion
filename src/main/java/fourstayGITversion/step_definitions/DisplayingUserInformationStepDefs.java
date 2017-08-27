package fourstayGITversion.step_definitions;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fourstayGITversion.pages.AccountPage;
import fourstayGITversion.pages.HomePage;
import fourstayGITversion.pages.LoginPage;
import fourstayGITversion.pages.SearchResultsPage;
import fourstayGITversion.utilities.BrowserUtilities;
import fourstayGITversion.utilities.ConfigurationReader;
import fourstayGITversion.utilities.Driver;

public class DisplayingUserInformationStepDefs {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	AccountPage accountPage = new AccountPage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();

	@Given("^I am on the fourstay login dialog$")
	public void i_am_on_the_fourstay_login_dialog() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Driver.getInstance().manage().window().maximize();
		loginPage.loginButton.click();

	}

	@Given("^I enter email \"([^\"]*)\"$")
	public void i_enter_email(String email) throws Throwable {
		Thread.sleep(2000);
		loginPage.emailField.sendKeys(email);
	}

	@Given("^I enter password \"([^\"]*)\"$")
	public void i_enter_password(String password) throws Throwable {
		loginPage.passwordField.sendKeys(password);
	}

	@When("^I click on the login button$")
	public void i_click_on_the_login_button() throws Throwable {
		loginPage.loginButtonPopUp.click();

	}

	@Then("^the user name should be \"([^\"]*)\"$")
	public void the_user_name_should_be(String userName) throws Throwable {
		BrowserUtilities.waitForPageLoad();
		Assert.assertEquals(userName, accountPage.accounHolderName.getText());
	}

	@Then("^the results should contain$")
	public void the_results_should_contain(List<String> states) throws Throwable {
		System.out.println(states);
		BrowserUtilities.switchTab("search");
		BrowserUtilities.waitForPageLoad();
		Set<String> actualStates = new HashSet<>();
		for (WebElement element : searchResultsPage.allStates) {
			actualStates.add(element.getText());
		}
		System.out.println(actualStates);
		Assert.assertTrue(actualStates.containsAll(states));
	}
	@When("^I enter this search criteria$")
	public void i_enter_this_search_criteria(List<Map<String, String>> searchCriteria) throws Throwable {
	   Map<String, String> input = searchCriteria.get(0);
		
		System.out.println(input);
		homePage.searchField.sendKeys(input.get("school"));
		homePage.moveInDate.sendKeys(input.get("start"));
		homePage.moveOutDate.sendKeys(input.get("end"));
		homePage.searchButton.click();
	}


}
