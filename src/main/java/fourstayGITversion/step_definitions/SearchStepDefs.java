package fourstayGITversion.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fourstayGITversion.pages.HomePage;
import fourstayGITversion.pages.ItemsPage;
import fourstayGITversion.pages.SearchResultsPage;
import fourstayGITversion.utilities.BrowserUtilities;
import fourstayGITversion.utilities.ConfigurationReader;
import fourstayGITversion.utilities.Driver;

public class SearchStepDefs {

	HomePage homePage = new HomePage();
	ItemsPage item = new ItemsPage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();

	@Given("^I am on the fourstay homepage$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
		Driver.getInstance().manage().window().maximize();

	}

	@When("^I search for hosting by location$")
	public void i_search_for_hosting_by_location() throws Throwable {

		homePage.searchField.sendKeys(ConfigurationReader.getProperty("search"));
		Thread.sleep(2000);
		homePage.moveInDate.sendKeys(ConfigurationReader.getProperty("moveInDate"));
		homePage.moveOutDate.sendKeys(ConfigurationReader.getProperty("moveOutDate"));
		homePage.myNumberOfBeds.click();
		homePage.numberOfBeds.get(3).click();
		homePage.searchButton.click();

	}

	@Then("^I should be able to see the items from that location in output$")
	public void i_should_be_able_to_see_the_items_from_that_location_in_output() throws Throwable {
		BrowserUtilities.switchTab(ConfigurationReader.getProperty("search"));
		Thread.sleep(2000);
		WebElement search=Driver.getInstance().findElement(By.xpath("(//span[@class='pac-matched'])[1]"));
		String location=search.getAttribute("innerText");
		System.out.println(location);
		
//		searchResultsPage.item.click();
//		HomePage.switchTab(Driver.getInstance(), ConfigurationReader.getProperty("tab2"));
//		if (item.location.getAttribute("value").contains("Washington, DC")) {
//			Assert.assertTrue(1 == 1);
//		} else if (item.location.getAttribute("value").contains("MD")) {
//			Assert.assertTrue(1 == 1);
//		} else if (item.location.getAttribute("value").contains("Virginia")) {
//			Assert.assertTrue(1 > 0);
//		} else {
//			Assert.assertTrue(1 < 0);
//		}

	}

	@When("^I search for hosting$")
	public void i_search_for_hosting() throws Throwable {
		homePage.searchField.sendKeys(ConfigurationReader.getProperty("search"));
		Thread.sleep(2000);
		homePage.moveInDate.sendKeys(ConfigurationReader.getProperty("moveInDate"));
		homePage.moveInDate.click();
		homePage.moveOutDate.sendKeys(ConfigurationReader.getProperty("moveOutDate"));
		homePage.myNumberOfBeds.click();
		homePage.numberOfBeds.get(2).click();
		homePage.searchButton.click();

	}

	@Then("^I should be able to see results in the output$")
	public void i_should_be_able_to_see_results_in_the_output() throws Throwable {
		BrowserUtilities.switchTab(ConfigurationReader.getProperty("tab1"));
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 10);
		wait.until(ExpectedConditions.visibilityOf(searchResultsPage.searchResults));
		Assert.assertTrue(searchResultsPage.searchResults.isDisplayed());

	}

}
