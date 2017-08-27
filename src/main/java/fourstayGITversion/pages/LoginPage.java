package fourstayGITversion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import fourstayGITversion.utilities.Driver;


public class LoginPage {

	public LoginPage(){
		PageFactory.initElements(Driver.getInstance(), this);
		
		
	}
	@FindBy(css = "li[class$='not-login']")
	public WebElement loginButton;
	
	@FindBy(id = "email")
	public WebElement emailField;
	
	
	@FindBy(id = "key")
	public WebElement passwordField;
	
	@FindBy(id = "btn-login")
	public WebElement loginButtonPopUp;
	
	@FindBy(xpath = "//span[.='LOGOUT']")
	public WebElement logoutButton;
	
	@FindBy(xpath= "//iframe[@name='stripeXDM_default793811_provider']")
	public WebElement firstIframe;
	
	@FindBy(id= "intercom-frame")
	public WebElement  thirdIframe;
	
	@FindBy(xpath = "/html/body/iframe[2]")
	public WebElement secondIframe;
	
	
	@FindBy(xpath = "//iframe[@class='intercom-launcher-frame']")
	public WebElement fourthIframe;
	
	@FindBy(xpath = "//div[@class='intercom-launcher-close-icon']")
	public WebElement closeIframe;
	
	
	
}
