package fourstayGITversion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import fourstayGITversion.utilities.Driver;

public class AccountPage {

	public AccountPage() {
		PageFactory.initElements(Driver.getInstance(), this);

	}

	@FindBy(css = ".user-name")
	public WebElement accounHolderName;

	@FindBy(css = "page-btn")
	public WebElement listItem;

	@FindBy(xpath = "//button[@class='navbar-toggle']")
	public WebElement menuButton;

	@FindBy(xpath = "(//a[@class='dropdown-toggle'])[3]")
	public WebElement profilePicDropDown;

	@FindBy(linkText = "Edit Profile")
	public WebElement editProfileButton;

	@FindBy(xpath = "(//a[@href='#/profile/general'])[2]")
	public WebElement editProfileButton2;

}
