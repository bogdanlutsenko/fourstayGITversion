package fourstayGITversion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import fourstayGITversion.utilities.Driver;

public class ProfileSettingsPage {

	public ProfileSettingsPage(){
		PageFactory.initElements(Driver.getInstance(), this);
	
	}
	
	
	@FindBy(xpath = "//input[@ng-model='$parent.other.FirstName']")
	public WebElement firstNameField;
	
	@FindBy(xpath= "//input[@ng-model='$parent.other.LastName']")
	public WebElement lastNameField;
	
	
	@FindBy(xpath= "(//input[@name='phone'])[2]")
	public WebElement phoneField;
	
	@FindBy(xpath= "//input[@ng-model='$parent.other.email']")
	public WebElement emailField;
	
}
