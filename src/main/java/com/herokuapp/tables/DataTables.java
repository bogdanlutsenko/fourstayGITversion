package com.herokuapp.tables;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import fourstayGITversion.utilities.ConfigurationReader;
import fourstayGITversion.utilities.Driver;


public class DataTables {

	static WebDriver driver;
	TablesPage tables = new TablesPage();

	@BeforeClass
	public static void setUp() {
		driver = Driver.getInstance();
		driver.get(ConfigurationReader.getProperty("tablesUrl"));
		driver.manage().window().maximize();
	}

	@Test
	public void tables() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(tables.table));
		Assert.assertEquals(6, tables.firstRow.size());
		Assert.assertEquals("Name", tables.firstRow.get(0).getText());
		Assert.assertEquals("Position", tables.firstRow.get(1).getText());
		Assert.assertEquals("Office", tables.firstRow.get(2).getText());
		Assert.assertEquals("Extn.", tables.firstRow.get(3).getText());
		Assert.assertEquals("Start date", tables.firstRow.get(4).getText());
		Assert.assertEquals("Salary", tables.firstRow.get(5).getText());
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='example']/tbody/tr"));
		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for (WebElement cell : cells) {
				System.out.print(cell.getText() + " | ");
			}
			System.out.println();
		}
		
		tables.searshField.sendKeys("Bruno Nash");
		Assert.assertEquals("Bruno Nash", tables.brunoNashCell.getText());
		Assert.assertEquals("Software Engineer", tables.brunoNashRow.get(1).getText());
		Assert.assertEquals("London", tables.brunoNashRow.get(2).getText());

		tables.newButton.click();
		tables.firstNameField.sendKeys("John");
		tables.lastNameField.sendKeys("Smith");
		tables.positionField.sendKeys("SDET");
		tables.officeField.sendKeys("Sydney");
		tables.extnField.sendKeys("3456");
		tables.startDateField.sendKeys("2017-11-23");
		tables.salaryField.sendKeys("253");
		tables.createButton.click();
		
		tables.searshField.clear();
		tables.searshField.sendKeys("John Smith");
		wait.until(ExpectedConditions.visibilityOfAllElements(tables.searchResult));
		Assert.assertEquals("John Smith", tables.searchResult.get(0).getText());
		Assert.assertEquals("SDET", tables.searchResult.get(1).getText());
		Assert.assertEquals("Sydney", tables.searchResult.get(2).getText());
		Assert.assertEquals("3456", tables.searchResult.get(3).getText());
		Assert.assertEquals("2017-11-23", tables.searchResult.get(4).getText());
		Assert.assertEquals(tables.searchResult.get(5).getText().replaceAll(",", ""), "$253");

	}
	 @After
	 public void tearDown(){
	 driver.close();
	 }

}
