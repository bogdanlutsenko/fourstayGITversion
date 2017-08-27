package fourstayGITversion.step_definitions;


import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import fourstayGITversion.pages.AccountPage;
import fourstayGITversion.pages.LoginPage;
import fourstayGITversion.utilities.ConfigurationReader;
import fourstayGITversion.utilities.Driver;


public class LoginForDiferentUsersStepDefs {
	
	
	private LoginPage loginPage=new LoginPage();
	private AccountPage accountPage = new AccountPage();
	
	@When("^I login as a host$")
	public void i_login_as_a_host() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 5);
		wait.until(ExpectedConditions.visibilityOf(loginPage.fourthIframe));
		Driver.getInstance().switchTo().frame(loginPage.fourthIframe);
		//Driver.getInstance().findElement(By.cssSelector("div.intercom-gradient")).click();
		loginPage.closeIframe.click();
		loginPage.closeIframe.click();
		Driver.getInstance().switchTo().defaultContent();
		loginPage.loginButton.click();
		Thread.sleep(2000);
		loginPage.emailField.sendKeys(ConfigurationReader.getProperty("host.username"));
		loginPage.passwordField.sendKeys(ConfigurationReader.getProperty("host.password"));
		loginPage.loginButtonPopUp.click();
		
	}

	@Then("^I should be able verify I am logged in$")
	public void i_should_be_able_verify_I_am_logged_in() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 20);
		wait.until(ExpectedConditions.visibilityOf(accountPage.accounHolderName));
		String name = accountPage.accounHolderName.getText();
		System.out.println(name);
		Assert.assertTrue(accountPage.accounHolderName.getText().equals(name));
		
	}

	@When("^I login as a guest$")
	public void i_login_as_a_guest() throws Throwable {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 5);
		//loginPage.logoutButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(loginPage.loginButton));
		loginPage.loginButton.click();
		Thread.sleep(2000);
		loginPage.emailField.sendKeys(ConfigurationReader.getProperty("guest.username"));
		loginPage.passwordField.sendKeys(ConfigurationReader.getProperty("guest.password"));
		loginPage.loginButtonPopUp.click();
		
	}
	
	


}
