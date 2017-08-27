package fourstayGITversion.step_definitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fourstayGITversion.pages.AccountPage;
import fourstayGITversion.pages.HomePage;
import fourstayGITversion.pages.ItemsPage;
import fourstayGITversion.pages.LoginPage;
import fourstayGITversion.pages.SearchResultsPage;
import fourstayGITversion.utilities.BrowserUtilities;
import fourstayGITversion.utilities.ConfigurationReader;
import fourstayGITversion.utilities.Driver;

public class SearchStep {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	AccountPage accountPage = new AccountPage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();
	ItemsPage item = new ItemsPage();
	WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);

	@Given("^I enter school name \"([^\"]*)\"$")
	public void i_enter_school_name(String schoolName) throws Throwable {
		homePage.searchField.sendKeys(schoolName);
	}

	@Given("^I enter dates \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_dates_and(String start, String end) throws Throwable {
		homePage.moveInDate.sendKeys(start);
		homePage.moveOutDate.sendKeys(end);
	}

	@Given("^I click the search button$")
	public void i_click_the_search_button() throws Throwable {
		homePage.searchButton.click();

	}

	@When("^Input search criteria, specify date in \\((\\d+)/(\\d+)/(\\d+)\\) and date out \\((\\d+)/(\\d+)/(\\d+)\\) and click search$")
	public void input_search_criteria_specify_date_in_and_date_out_and_click_search(int InMonth, int InDay, int InYear,
			int OutMonth, int OutDay, int OutYear) throws Throwable {
		homePage.searchField.sendKeys(ConfigurationReader.getProperty("search"));
		homePage.moveInDate.sendKeys(InMonth + "/" + InDay + "/" + InYear);
		homePage.moveOutDate.sendKeys(OutMonth + "/" + OutDay + "/" + OutYear);
		homePage.myNumberOfBeds.click();
		homePage.numberOfBeds.get(2).click();
		homePage.searchButton.click();

	}

	@Then("^I should be able to see results within the searching criteria$")
	public void i_should_be_able_to_see_results_within_the_searching_criteria() throws Throwable {
		BrowserUtilities.waitForPageLoad();
		BrowserUtilities.switchTab("search");
		searchResultsPage.item2.click();
		BrowserUtilities.waitForPageLoad();
		BrowserUtilities.switchTab("dashboard/#/property");
		String availableFrom = item.availableFrom.getText();
		String availableTo = item.availableTo.getText();
		int[] dateFrom = Arrays.stream(availableFrom.split("/")).mapToInt(Integer::parseInt).toArray();
		int[] dateTo = Arrays.stream(availableTo.split("/")).mapToInt(Integer::parseInt).toArray();
		System.out.println(dateFrom[2]+"   "+dateTo[2]);
		Thread.sleep(6000);
		
		
		Assert.assertTrue(dateFrom[0] >= 03);
		Assert.assertTrue(dateFrom[2] >= 2018);
		Assert.assertTrue(dateTo[0] >= 03);
		Assert.assertTrue(dateTo[2] >= 2018);

	}

	@When("^I go the home page$")
	public void i_go_the_home_page() throws Throwable {
		BrowserUtilities.waitForPageLoad();
		wait.until(ExpectedConditions.elementToBeClickable(homePage.homePageButton));
		homePage.homePageButton.click();

	}

	@Then("^I should be able to see that all stays on result list have price tag$")
	public void i_should_be_able_to_see_that_all_stays_on_result_list_have_price_tag() throws Throwable {
		BrowserUtilities.waitForPageLoad();
		BrowserUtilities.switchTab("search");
		for (WebElement price : searchResultsPage.stayPrice) {
			List<String> myPrice = new ArrayList<>();
			myPrice.add(price.getText());
			for (String string : myPrice) {
				String pr = string.replace("$", "");
				Assert.assertTrue(!pr.isEmpty());
				System.out.println(pr);
			}
		}

	}
	
	@Then("^When I'm changing number of beds I should be able to see that number of results updates$")
	public void when_I_m_changing_number_of_beds_I_should_be_able_to_see_that_number_of_results_updates() throws Throwable {
		BrowserUtilities.waitForPageLoad();
		BrowserUtilities.switchTab("search");
		wait.until(ExpectedConditions.visibilityOfAllElements(searchResultsPage.allSearchResults));
		List<WebElement> beforeResults = new ArrayList<>();
		beforeResults=searchResultsPage.allSearchResults;
		int before=beforeResults.size();
		searchResultsPage.numberOfBeds.click();
		searchResultsPage.numberOfBedsOption.get(5).click();
		List<WebElement> afterResults = new ArrayList<>();
		afterResults=searchResultsPage.allSearchResults;
		int after=afterResults.size();
		Assert.assertTrue(!(before==after));
		
		
	}
}
