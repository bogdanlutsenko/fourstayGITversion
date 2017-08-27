package fourstayGITversion.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import fourstayGITversion.utilities.Driver;

public class HomePage {
	
	public HomePage() {
		PageFactory.initElements(Driver.getInstance(), this);

	}

	@FindBy(id = "iLocName")
	public WebElement searchField;
	
	@FindBy(id = "rentoutfrom2")
	public WebElement moveInDate;
	
	@FindBy(id = "rentoutto2")
	public WebElement moveOutDate;
	
	@FindBy(id = "themates")
	public WebElement myNumberOfBeds;
	
	@FindBy(id = "search")
	public WebElement searchButton;
	
	@FindAll({@FindBy(xpath="//a[@class='list-option-select']")})
	public List< WebElement> numberOfBeds;
	
	@FindBy(css = "a.navbar-brand.hstay-logo")
	public WebElement homePageButton;
	
	
	@FindBy(xpath = "(//li[@class='btn menu btn-log zl-margin not-login'])[2]")
	public WebElement signUpButton;
	
	@FindBy(id = "FirstName")
	public WebElement firstNameField;
	
	@FindBy(id = "LastName")
	public WebElement lastNameField;
	
	@FindBy(xpath = "(//input[@id='email'])[3]")
	public WebElement emailField;
	
	@FindBy(xpath = "(//input[@id='key'])[2]")
	public WebElement passwordField;
	
	@FindBy(id = "btn-signup")
	public WebElement mySignUpButton;
	
	
	
}
