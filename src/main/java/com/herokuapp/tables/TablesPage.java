package com.herokuapp.tables;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fourstayGITversion.utilities.Driver;


public class TablesPage {

	public TablesPage(){
		PageFactory.initElements(Driver.getInstance(), this);
		
		
	}
	@FindBy(css = "a.dt-button.buttons-create")
	public WebElement newButton;
	
	@FindBy(css = "button.btn")
	public WebElement createButton;
	
	@FindBy(id = "DTE_Field_first_name")
	public WebElement firstNameField;
	
	@FindBy(id = "DTE_Field_last_name")
	public WebElement lastNameField;
	
	@FindBy(id = "DTE_Field_position")
	public WebElement positionField;
	
	@FindBy(id = "DTE_Field_office")
	public WebElement officeField;
	
	@FindBy(id = "DTE_Field_extn")
	public WebElement extnField;
	
	@FindBy(id = "DTE_Field_start_date")
	public WebElement startDateField;
	
	@FindBy(id = "DTE_Field_salary")
	public WebElement salaryField;
	
	@FindBy(xpath = "//input[@type='search']")
	public WebElement searshField;
	
	@FindAll({@FindBy(xpath="//table[@id='example']/tbody/tr/td")})
	public List< WebElement> searchResult;
	
	@FindAll({@FindBy(xpath="//table[@id='example']/thead/tr/th")})
	public List< WebElement> firstRow;
	
	@FindBy(id = "example")
	public WebElement table;
	
	@FindAll({@FindBy(xpath="//table[@id='example']//tbody/tr[@id='row_43']/td")})
	public List< WebElement> brunoNashRow;
	
	@FindBy(xpath = "//table[@id='example']//tbody/tr/td[contains(text(),'Bruno Nash')]")
	public WebElement brunoNashCell;
	
	
}
