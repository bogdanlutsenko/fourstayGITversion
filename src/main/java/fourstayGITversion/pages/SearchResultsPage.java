package fourstayGITversion.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import fourstayGITversion.utilities.Driver;

public class SearchResultsPage {

	public SearchResultsPage(){
		PageFactory.initElements(Driver.getInstance(), this);
		
		
	}
	@FindBy(css = "p.ng-binding")
	public WebElement item;
	
	@FindBy(xpath = "(//img[@class='img-responsive'])[1]")
	public WebElement item2;
	
	
	
	@FindBy(css = "div.input-group.input-stay")
	public WebElement inDateate;
	
	@FindBy(css = "button.btn.btn-large.page-btn")
	public WebElement resetFilters;
	
	@FindBy(xpath = "//img[@class='img-responsive']")
	public WebElement searchResults;
	
	
	@FindBy(css = "div.carousel-inner")
	public List<WebElement> allSearchResults;
	
	@FindBy(xpath = "//select[@id='inputGroupSuccess1']")
	public WebElement numberOfBeds;
	
	@FindBy(xpath = "//select[@id='inputGroupSuccess1']/option")
	public List<WebElement> numberOfBedsOption;
	
	
	@FindBy(css = ".col-md-12>p")
	public List<WebElement> allStates;
	
	
	@FindBy(css = "span.price-bold.ng-binding")
	public List<WebElement> stayPrice;
	
}
