package fourstayGITversion.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import fourstayGITversion.utilities.Driver;

public class ItemsPage {

	
	
	public ItemsPage() {
		PageFactory.initElements(Driver.getInstance(), this);

	}

	@FindBy(id = "add")
	public WebElement location;
	
	
	
	@FindBy(xpath = "(//h5[@class='ng-binding'])[2]")
	public WebElement availableFrom;
	
	@FindBy(xpath = "(//h5[@class='ng-binding'])[3]")
	public WebElement availableTo;
	
	
	
}
