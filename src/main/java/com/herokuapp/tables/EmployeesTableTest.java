package com.herokuapp.tables;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import fourstayGITversion.utilities.ConfigurationReader;
import fourstayGITversion.utilities.Driver;


public class EmployeesTableTest {

	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		driver = Driver.getInstance();
		driver.get(ConfigurationReader.getProperty("herokuUrl"));
	}

	@Test
	public void test() {
		WebElement webtable1 = driver.findElement(By.id("table1"));
		List<WebElement> rows = webtable1.findElements(By.tagName("tr"));
		System.out.println("Webtable one rows count: " + rows.size());

		WebElement webtable2 = driver.findElement(By.id("table2"));
		List<WebElement> rows2 = webtable2.findElements(By.tagName("tr"));
		System.out.println("Webtable two rows count: " + rows2.size());
		List<WebElement> cells = rows.get(0).findElements(By.tagName("th"));

		System.out.println(cells.get(0).getText());
		 //[@id='table1']/thead/tr/th[1]
		WebElement firstCell = driver.findElement(By.xpath("//table[@id='table1']/thead/tr/th[1]"));
		//table[@id='table1']//tr[1]/th[1]
		System.out.println(firstCell.getText());
	}

	@Test
	public void loopWebTables() {

		WebElement table1=driver.findElement(By.id("table1"));
		
		List<WebElement> rows=table1.findElements(By.tagName("tr"));
		System.out.println("Number of rows in table 1: "+rows.size());
		
		for(WebElement row:rows){
			System.out.println(row.getText());
		}
		
		for(WebElement row:rows){
			List<WebElement> cells=row.findElements(By.tagName("td"));
			
			for(WebElement cell:cells){
			System.out.print(cell.getText()+" | ");
		}
		System.out.println();
		}
	}
	
	@Test
	public void loopTablesXpath(){
		
	List<WebElement> rowsInTable2=
			driver.findElements(By.xpath("//table[@id='table2']/tbody/tr"));
	System.out.println("Number of rows in table2: "+rowsInTable2.size());
		
	for(int rowNum=1; rowNum<=4; rowNum++){
		for(int cellNum=1; cellNum<=6; cellNum++){
		String cellValue=driver.findElement
				(By.xpath("//table[@id='table2']/tbody/tr["+rowNum+"]/td["+cellNum+"]")).getText();
		System.out.print(cellValue+" | ");
		//System.out.println(driver.findElement(By.xpath("//table[@id='table2']/tbody/tr["+rowNum+"]")).getText());
	}
		System.out.println();
	}	
	}
	@Test
	public void GreyHoundCalendar() throws InterruptedException{
		driver.get("https://www.greyhound.com");
		driver.manage().window().maximize();
		driver.findElement(By.id("datepicker-from")).click();
		Thread.sleep(1234);
		WebElement a=driver.findElement
		(By.xpath("//div[@id='datefrom-datepicker']//table//td[@data-speak-value='Tuesday August 1 2017']"));
		a.click();	
	}
//	@After
//	public void tearDown(){
//		driver.close();
//	}
}
